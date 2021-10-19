package enchere.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Membre {
    private ArrayList<String> typeMembre = new ArrayList<String>();
    private dbConnexionManager db;
    
    public Membre() {
    }
    
    public ResultSet getTypeMembres() {
        ResultSet rs = null;
        rs = db.executeQuery("Select * from TypeMembre");
        System.out.println(rs);
        try{
            while(rs.next()){
                typeMembre = (ArrayList<String>) rs.getArray("nomTypeMembre");
            }
            
        }catch (SQLException s){
            System.out.println(s);
        }
        return rs;
    }
}
