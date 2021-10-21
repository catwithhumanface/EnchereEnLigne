package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Frais {
    private ArrayList<Float> listFraisInsertion ;
    private ArrayList<Float> listFraisCommission;
    private ResultSet result = null;
    private Connection connection = null;
    private Statement statement = null;
    
    
    public Frais(){
        
    }
    //Cette fonction retourne la liste des frais d'insertions
       public ArrayList<Float> getListFraisInsertion() {
        listFraisInsertion=new ArrayList<>();
        float fraisInsertion;
        fraisInsertion=0;
        
        try {
            Connection connection = DbConnexionManager.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery("Select * from fraisinsertion");
            while(result.next()){
                 fraisInsertion= result.getFloat("FraisInsertion");
                 listFraisInsertion.add(fraisInsertion);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
       
        return listFraisInsertion;

    }
       //Cette fonction retourne la liste des frais d'insertions
       public ArrayList<Float> getListFraisCommission() {
        listFraisCommission=new ArrayList<>();
        float fraisCommission;
        fraisCommission=0;
        
        try {
            Connection connection = DbConnexionManager.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeQuery("Select * from fraiscommission");
            while(result.next()){
                 fraisCommission= result.getFloat("FraisCommission");
                 listFraisCommission.add(fraisCommission);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, statement);
        }
        System.out.println("liste frais"+listFraisCommission);
        return listFraisCommission;
        

    }
}
