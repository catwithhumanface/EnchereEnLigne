package enchere.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Categorie {
    private int id;
    private String libCategorie;
    private ArrayList<Objet> listObjets;
    
    public Categorie(){
        
    }
    
    Categorie(int id, String libelle) {
       this.id=id;
       this.libCategorie=libelle;
       listObjets=new ArrayList<>();
    }
    
    
    // Afficher les catégorie dans la page mise en vente
    public ArrayList<String> getTypeCategorie() {
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        Connection connection = null;
        Statement statement = null;

        try {

            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(GestionVenteSQL.GetCATE);
            while (rs.next()) {
                String cateAjout = rs.getString("LibCat");
                result.add(cateAjout);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return result;

   }
  
    public String getName(){
        return this.libCategorie;
    }

    public int getId() {
        return id;
    }
    
    
  }
