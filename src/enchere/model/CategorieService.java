/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liely
 */
public class CategorieService {
    private ResultSet result = null;
    private Connection connection = null;
    private Statement statement = null;
    private Categorie categorie = null;
    
    //Cette méthode calcul le CA à partir de tous les objets d'une catégorie
    public float calculCA(String libCategorie){
        float CA=0;
        
        for(Objet numObjet: getListObjetCategorie(libCategorie) ){
            
            CA=numObjet.calculCAObjet(numObjet);
           
            CA+=CA;
            
        }
       

        return CA;
    }
    
    //Compter le nombre d'objet d'une catégorie
     public int calculNbObjet(String  libCategorie) {
        int nbObjets=0;
        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            String query="SELECT count(objet.idObjet) from objet, categorie where objet.IdCodeCat=categorie.IdCodeCat and LibCat='"+libCategorie+"' ";
            result = statement.executeQuery(query);
            while(result.next()){
                nbObjets = result.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return nbObjets;

    }
     //recupérer tous les objets d'une catégorie
     public ArrayList<Objet> getListObjetCategorie(String  libCategorie) {
        ArrayList<Objet> listObjetCategorie;
        listObjetCategorie=new ArrayList<>();
        Objet objet;
        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            String query="SELECT * from objet, categorie where objet.IdCodeCat=categorie.IdCodeCat and LibCat='"+libCategorie+"' ";
            result = statement.executeQuery(query);
            while(result.next()){
                objet=ObjetService.fromResultRowToObjet(result);
                listObjetCategorie.add(objet) ;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return listObjetCategorie;

    }
    /* recuperer categorie à partir de l'id */
    public Categorie getCategorie(int id) {
        
        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("Select * from categorie where IdCodeCat=1");
            while(result.next()){
                 categorie = fromResultRowToCategorie(result);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return categorie;

    }

    /* récupérer toutes les categories */
    public List<Categorie> getCategories() throws ClassNotFoundException  {
        List<Categorie> categories = new ArrayList<Categorie>();

        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("Select * from categorie");
            while (result != null && result.next()) {
                Categorie categorie = fromResultRowToCategorie(result);
                categories.add(categorie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categories;
    }

    /* transformer une ligne de resultset en categorie
    le curseur doit être sur la bonne ligne*/
    private Categorie fromResultRowToCategorie(ResultSet result) {
        int id=0;
        String name = null;
        try {
            id = result.getInt("IdCodeCat");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            name = result.getString("LibCat");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Categorie(id, name);
        }

    
   
    }
