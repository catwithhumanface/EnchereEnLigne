package enchere.model;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Enchere {
    private int montantPasE;
    private int montantMaxE;
    private Date dateheureEnchere;
    private int idMembre;
    private int idObjet;
    
    public Enchere(){
        
    }
    
    public Enchere(int montantPasE, int montantMaxE, Date dateheureEnchere, int idMembre, int idObjet) {
        this.montantPasE = montantPasE;
        this.montantMaxE = montantMaxE;
        this.dateheureEnchere = dateheureEnchere;
        this.idMembre = idMembre;
        this.idObjet = idObjet;
    }
    
    public int getMontantPasE() {
        return montantPasE;
    }

    public void setMontantPasE(int montantPasE) {
        this.montantPasE = montantPasE;
    }

    public int getMontantMaxE() {
        return montantMaxE;
    }

    public void setMontantMaxE(int montantMaxE) {
        this.montantMaxE = montantMaxE;
    }

    public Date getDateheureEnchere() {
        return dateheureEnchere;
    }

    public void setDateheureEnchere(Date dateheureEnchere) {
        this.dateheureEnchere = dateheureEnchere;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdObjet() {
        return idObjet;
    }
  
    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }
  
    public Boolean validerEncherir(int montantMax, int montantPas, int idObjet,int idMembre, Timestamp dateheureEnchere){
        Boolean flag = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        // les requetes qui cherchent les ID correspondant et insérer les infos de vente
        String sql = GestionVenteSQL.VALIDERENCHERIR;
        
        ResultSet result = null;
        try {
            connection = DbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,montantPas);
            pstmt.setInt(2, montantMax);
            pstmt.setTimestamp(3,dateheureEnchere);
            pstmt.setInt(4,idMembre);
            pstmt.setInt(5,idObjet);
            
            // vérifier si les données sont bien saisis
            int i = pstmt.executeUpdate();
            if (i ==1) {
                //changer le prixAchat de l'objet
                pstmt = connection.prepareStatement(GestionVenteSQL.UPDATEOBJET);
                pstmt.setInt(1, montantPas);
                pstmt.setInt(2, idObjet);
                System.out.println(montantPas + " " + idObjet);
                int k = pstmt.executeUpdate();
                if(k == 1){
                    flag = true;
                }
              }
        } catch (SQLException| ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
          DbConnexionManager.closeObjects(connection, pstmt);
        }
        return flag;
    }

    
    
    
    
}