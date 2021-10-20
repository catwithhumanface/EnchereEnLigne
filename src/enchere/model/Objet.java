package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;

public class Objet {

    dbConnexionManager c = new dbConnexionManager();
    GestionVenteSQL SqlVente = new GestionVenteSQL();

    public void misenVente(String TitreA, String DescO, int PrixDepart, int PrixReserver,
            int PrixAchatimmediat, String Regiondelivraison, Date Datedecloture,
            int FraisPort, String Cate, String SousCate, String Sous_sous) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        // les requetes qui cherchent les ID correspondant et insérer les infos de vente
        String sql = GestionVenteSQL.MISENVENTE;
        String sqlGetCate = GestionVenteSQL.GETIDCATE;
        String sqlGetCateSous = GestionVenteSQL.GETIDCATESous;
        String sqlGetCateSous_sous = GestionVenteSQL.GETIDCATESous_sous;

        int IdCodeCat = 1;
        int IdSousCategorie = 1;
        int IdSous_sous = 1;

        ResultSet result = null;

        try {

            connection = dbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sqlGetCate);
            pstmt.setString(1,Cate);
            
            result = pstmt.executeQuery();

            if (result.next()) {
                IdCodeCat = result.getInt("IdCodeCat");
            }

            pstmt = connection.prepareStatement(sqlGetCateSous);
            pstmt.setString(1,SousCate);
         
            result = pstmt.executeQuery();

            while (result.next()) {
                IdSousCategorie = result.getInt("idSousCategorie");
                
            }

            pstmt = connection.prepareStatement(sqlGetCateSous_sous);
            pstmt.setString(1,Sous_sous);
            result = pstmt.executeQuery();

            while (result.next()) {
                IdSous_sous = result.getInt("idSous_sous");
            }
            
            // Remplir tous les variables 
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, TitreA);
            pstmt.setString(2, DescO);
            pstmt.setInt(3, PrixDepart);
            pstmt.setInt(4, PrixReserver);
            pstmt.setInt(5, PrixAchatimmediat);
            pstmt.setString(6, Regiondelivraison);
            pstmt.setDate(7, Datedecloture);
            pstmt.setInt(8, FraisPort);
            pstmt.setInt(9, IdCodeCat);      
            pstmt.setInt(10, IdSousCategorie);
            pstmt.setInt(11, IdSous_sous);
            
            // vérifier si les données sont bien saisis
            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println("Mise en vente reussie");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, pstmt);
        }
    }

}
