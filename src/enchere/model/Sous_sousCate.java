package enchere.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sous_sousCate {
    
    // Afficher les infos dans la page de mise en vente
    
    
    public ArrayList<String> getSous_sousCat(String souscateChoix){
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement pstmt = null;
       
        try {    
            connection = DbConnexionManager.getConnection();
            pstmt= connection.prepareStatement(GestionVenteSQL.GETSOUS_SOUS);
            pstmt.setString(1, souscateChoix);
            
            rs = pstmt.executeQuery();
            while(rs.next()){           
                String cateAjout = rs.getString("LibSous_sous");
                result.add(cateAjout);  
            }       
                  
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, pstmt);
        }
        return result;
    }


}
