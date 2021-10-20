package enchere.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Membre {
    
    private ArrayList<String> typeMembre = new ArrayList<String>();
    
    public Membre() {
        
    }
    
    public ArrayList<String> getTypeMembres() {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = dbConnexionManager.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("Select * from TypeMembre");
            while(result.next()){
                typeMembre.add(result.getString("nomTypeMembre"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, statement);
        }
        return typeMembre;
    }
    
    public static Boolean checkPseudo(String pseudo){
        Boolean flag = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = MembreSQL.CHECKPSEUDO;
        try {
            connection = dbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, pseudo);
            
            result = pstmt.executeQuery();
            if(result.next()){
                flag = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, pstmt);
        }
        return flag;
    }
    
    public static Membre getLoginMembre(String pseudo, String mdp, int type){
        Membre membre = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        
        String sql = MembreSQL.SIGN_IN;
        try {
            connection = dbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, type);
            pstmt.setString(2, pseudo);
            pstmt.setString(3, mdp);
            
            result = pstmt.executeQuery();
            
            if(result.next()){
               if(type==1){
                   membre = new MembreClient(Integer.parseInt(result.getString("idMembre")), result.getString("PseudoMembre"), 
                           result.getString("DateNM"), result.getString("RueM"), result.getString("VillM"), result.getString("PaysM"),
                           result.getString("EtatM"), result.getString("NumTel"), result.getString("Email"), result.getString("NomM"), 
                           result.getString("PrenomM"), result.getString("PasseWordM"));
               }else if(type==2){
                   membre = new MembreServiceInformatique(Integer.parseInt(result.getString("idMembre")), result.getString("PseudoMembre"), 
                           result.getString("DateNM"), result.getString("RueM"), result.getString("VillM"), result.getString("PaysM"),
                           result.getString("EtatM"), result.getString("NumTel"), result.getString("Email"), result.getString("NomM"), 
                           result.getString("PrenomM"), result.getString("PasseWordM"));
               }else if(type==3){
                   membre = new MembreServiceJuridique(Integer.parseInt(result.getString("idMembre")), result.getString("PseudoMembre"), 
                           result.getString("DateNM"), result.getString("RueM"), result.getString("VillM"), result.getString("PaysM"),
                           result.getString("EtatM"), result.getString("NumTel"), result.getString("Email"), result.getString("NomM"), 
                           result.getString("PrenomM"), result.getString("PasseWordM"));
               }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, pstmt);
        }
        return membre;
    }
}
