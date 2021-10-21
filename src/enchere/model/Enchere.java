package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Enchere {
    public Enchere(){
    }
    
    public void validerEncherir(int montantMax, int montantPas, int idObjet,int idMembre,Timestamp dateheureEnchere){
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        // les requetes qui cherchent les ID correspondant et insérer les infos de vente
        String sql = GestionVenteSQL.VALIDERENCHERIR;

        ResultSet result = null;

        try {

            connection = DbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,montantMax);
            pstmt.setInt(2, montantPas);
            pstmt.setTimestamp(3,dateheureEnchere);
            pstmt.setInt(4,idMembre);
            pstmt.setInt(5,idObjet);
            
         
            
            // vérifier si les données sont bien saisis
            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println("Enchérir réussie");
              }
        } catch (SQLException| ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
          DbConnexionManager.closeObjects(connection, pstmt);
        }
    
        
        
    }

}
