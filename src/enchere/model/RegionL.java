/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tong
 */
public class RegionL {
    // Afficher les infos dans la page mise en vente
    public ArrayList<String> getTypeRegion(){
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        Connection connection = null;
        Statement statement = null;
       
        try {
            
            connection = DbConnexionManager.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(GestionVenteSQL.REGION);
            while(rs.next()){
                String cateAjout = rs.getString("regionL");
                result.add(cateAjout);  
            }       
                  
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        return result;
    }
    
}
