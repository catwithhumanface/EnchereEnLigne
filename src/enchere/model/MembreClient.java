package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembreClient extends Membre {
    private int idMembre;
    private String pseudoMembre;
    private Date dateNM;
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

    public MembreClient(int idMembre, String pseudoMembre, Date dateNM, String rueM, String villeM, String paysM, String etatM, String numTel, String email, String nomM, String prenomM, String passeWordM) {
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
        this.passeWordM = passeWordM;
    }
    
    public int getIdMembre() {
        return idMembre;
    }

    public String getPseudoMembre() {
        return pseudoMembre;
    }

    public Date getDateNM() {
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
    
    //inscrire un membre en tant que client
    public Boolean inscrire(String nom, String prenom, Date dateN, String email, String rue, String cpm, 
                String ville, String pays, String numtel, String pseudo, String mdp){
        
        Boolean flag = false;
        Membre membre = new Membre();
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        String sql = MembreSQL.SIGN_UP;
        try {
            connection = DbConnexionManager.getConnection();
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
            DbConnexionManager.closeObjects(connection, pstmt);
        }
        return flag;
    }
    
    public ArrayList<Objet> getMesVentes(int id){
        ArrayList<Objet> objets = new ArrayList<Objet>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String sql = MembreSQL.GETMESVENTES;
        try {
            connection = DbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();
            
            while(result.next()){
                int idObjet = result.getInt(1);
                String titreA = result.getString(2);
                String descO = result.getString(3);
                int prixDepart = result.getInt(4);
                int prixReserve = result.getInt(5);
                int prixAchatImmediat = result.getInt(6);
                String regiondelivraison = result.getString(7);
                Date datedecloture = result.getDate(8);
                String etatVente = result.getString(9);
                int prixAchat = result.getInt(10);
                int idMembre = result.getInt(11);
                int idFrais = result.getInt(12);
                int idCodeCat = result.getInt(13);
                int idSousCategorie = result.getInt(14);
                int idSous_sous = result.getInt(15);
                
                Objet objet = new Objet(idObjet, titreA, descO, prixDepart, prixReserve, prixAchatImmediat, regiondelivraison,
                        datedecloture, etatVente, prixAchat, 0, idMembre, idFrais, idCodeCat, idSousCategorie, idSous_sous); 

                objets.add(objet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, pstmt);
        }
        return objets;
    }
    
    public ArrayList<Enchere> getMesEncheres(int id){
        ArrayList<Enchere> encheres = new ArrayList<Enchere>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        String sql = MembreSQL.GETMESENCHERES;
        try {
            connection = DbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();
            
            while(result.next()){
                int montantPasE = result.getInt(1);
                int montantMaxE = result.getInt(2);
                Date dateHeureEnchere = result.getDate(3);
                int idMembre = result.getInt(4);
                int idObjetGot = result.getInt(5);
                Enchere enchere = new Enchere(montantPasE, montantMaxE, dateHeureEnchere, idMembre, idObjetGot);
                encheres.add(enchere);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbConnexionManager.closeObjects(connection, pstmt);
        }
        return encheres;
    }
    
    
}