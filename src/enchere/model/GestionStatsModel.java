/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liely
 */
public class GestionStatsModel {
    private ResultSet result = null;
    private Connection connection = null;
    private Statement statement = null;
    private Statistique statistique ;
    
    public GestionStatsModel(){
        statistique=new Statistique();
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
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            name = result.getString("LibCat");
        } catch (SQLException ex) {
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Categorie(id, name);
        }
   
    //Cette fonction retourne la liste des semaines de la BDD à partir des statistiques
    public ArrayList<String> listSemaineStat() throws ClassNotFoundException{
         ArrayList<String> listSemaineStat = new ArrayList<String>();
         String semaine;
        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("Select AnneeSemaine from statistique");
            while (result != null && result.next()) {
                semaine=result.getString(1);
                listSemaineStat.add(semaine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listSemaineStat;
    }
    
    //recupérer tous les objets d'une catégorie
    public ArrayList<Objet> getListObjetCategorie(String  libCategorie) {
        
        ArrayList<Objet> listObjetCategorie;
        listObjetCategorie=new ArrayList<>();
        Objet objet;
        try {
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            String query="SELECT * from objet, categorie where objet.IdCodeCat=categorie.IdCodeCat  and LibCat='"+libCategorie+"' ";
            result = statement.executeQuery(query);
            while(result.next()){
                objet=fromResultRowToObjet(result);
                listObjetCategorie.add(objet) ;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return listObjetCategorie;

    }

    
    //Cette méthode calcul le CA à partir de tous les objets d'une catégorie 
    public float calculCA(String libCategorie) throws ClassNotFoundException{
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
            String query="SELECT count(objet.idObjet) from objet, categorie where objet.IdCodeCat=categorie.IdCodeCat AND  LibCat='"+libCategorie+"' ";
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
  
    //Calcul du nombre de visite des objets apaprtenant à une catégorie
    public int calculNbVisiteCategorie(String libCategorie) throws ClassNotFoundException{
        int nbVisiteCategorie=0;
        for(Objet objet: getListObjetCategorie(libCategorie) ){
            //On initialise les visites chaque semaine
            
               
               nbVisiteCategorie=objet.getVisiteObjet();
               nbVisiteCategorie+=nbVisiteCategorie; 
            
        }
        return nbVisiteCategorie;
    }
   

     
    public void insertStat() throws ClassNotFoundException{
        LocalDate launchDate;
        String launchSemaine;
        //launchDate est la date de début de lancement de l'application
        launchDate=LocalDate.of(2021, 10, 01);
        //launchSemaine est la première semaine depuis le début du lancement de l'application
        launchSemaine=statistique.calculSemaine(launchDate);
        LocalDate lastDate;
        int firstDate=Integer.parseInt(launchSemaine);
        //LastDate est la semaine actuelle
        lastDate=LocalDate.now();
        String lastDateString=statistique.calculSemaine(lastDate);
        int lastDateInt=Integer.parseInt(lastDateString);
        
        for( int semaine=firstDate;semaine<=lastDateInt;semaine++ ){
            //Récupération des valeurs totales par semaine 
            float CATotal=statistique.calculTotalCA();
            int visTotal=statistique.calculVisiteTotal();
            int nbObjet=statistique.calculNbObjetTotal();
            //On verifie que les stats n'existe pas dans la BDD
            if (!listSemaineStat().contains(""+semaine)){
                System.out.println("semia"+listSemaineStat()+semaine);
                try {
                    connection = DbConnexionManager.getConnection();
                    statement = connection.createStatement();
                    int result = statement.executeUpdate("Insert into statistique values('"+semaine+"','"+CATotal+"','"+visTotal+"','"+nbObjet+"')");
                } 
                catch (SQLException ex) {
                     System.err.println(ex);
                }
            }
            
        }
    }
    //Cette requête permet d'avoir un objet à partir d'un résultat
     public Objet fromResultRowToObjet(ResultSet result) {
        int numO=0;
        String titreA = "";
        int prixAchat=0;
        int prixDepart=0;
        Objet objet=null;
        
        try {
            numO = result.getInt("IdObjet");
        } catch (SQLException ex) {
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            prixAchat = result.getInt("PrixAchat");
        } catch (SQLException ex) {
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            prixDepart = result.getInt("PrixDepart");
        } catch (SQLException ex) {
            Logger.getLogger(GestionStatsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        objet=new Objet(numO);
        objet.setPrixAchat(prixAchat);
        objet.setPrixDepart(prixDepart);
        
        return objet;
    }
  
    

}
