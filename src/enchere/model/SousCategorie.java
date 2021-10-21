package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class SousCategorie {
    // Afficher les infos dans la page mise en vente
    public ArrayList<String> getTypeSousCat(String cateChoix){
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement pstmt = null;
       
        try {    
            connection = DbConnexionManager.getConnection();
            pstmt= connection.prepareStatement(GestionVenteSQL.GETSOUSCAT);
            pstmt.setString(1, cateChoix);
            
            rs = pstmt.executeQuery();
            while(rs.next()){           
                String cateAjout = rs.getString("LibSousCat");
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