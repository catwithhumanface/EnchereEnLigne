package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MembreClient extends Membre {
    private int idMembre;
    private String pseudoMembre;
    private String dateNM;
    private String rueM;
    private String villeM;
    private String paysM;
    private String etatM;
    private String numTel;
    private String email;
    private String nomM;
    private String prenomM;
    private String passeWordM;
   
    public MembreClient(){
        
    }
    
    public MembreClient(int idMembre, String pseudoMembre, String dateNM, String rueM, String villeM, String paysM, String etatM,
            String numTel, String email, String nomM, String prenomM, String passeWordM){
        this.idMembre = idMembre;
        this.pseudoMembre = pseudoMembre;
        this.dateNM = dateNM;
        this.rueM = rueM;
        this.villeM = villeM;
        this.paysM = paysM;
        this.etatM = etatM;
        this.numTel = numTel;
        this.email = email;
        this.nomM = nomM;
        this.prenomM = prenomM;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public String getPseudoMembre() {
        return pseudoMembre;
    }

    public String getDateNM() {
        return dateNM;
    }

    public String getRueM() {
        return rueM;
    }

    public String getVilleM() {
        return villeM;
    }

    public String getPaysM() {
        return paysM;
    }

    public String getEtatM() {
        return etatM;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getEmail() {
        return email;
    }

    public String getNomM() {
        return nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public String getPasseWordM() {
        return passeWordM;
    }

    public Boolean inscrire(String nom, String prenom, Date dateN, String email, String rue, String cpm, 
                String ville, String pays, String numtel, String pseudo, String mdp){
        
        Boolean flag = false;
        Membre membre = new Membre();
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        String sql = MembreSQL.SIGN_UP;
        try {
            connection = dbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, pseudo);
            pstmt.setDate(2, dateN);
            pstmt.setString(3, rue);
            pstmt.setString(4, cpm);
            pstmt.setString(5, ville);
            pstmt.setString(6, pays);
            pstmt.setString(7, numtel);
            pstmt.setString(8, email);
            pstmt.setString(9, nom);
            pstmt.setString(10, prenom);
            pstmt.setString(11, mdp);
            
            int i = pstmt.executeUpdate();
            
            if(i==1){
               flag = true;
               System.out.println("inscription reussie");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, pstmt);
        }
        return flag;
    }
    
}
