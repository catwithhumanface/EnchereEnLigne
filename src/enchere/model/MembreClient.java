package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    
    public void inscrire(String nom, String prenom, String dateN, String email, String rue, String cpm, 
                String ville, String pays, String numtel, String pseudo, String mdp){
        Membre membre = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = dbConnexionManager.getConnection();
            statement = connection.createStatement();
            String query = "insert into Membre (PseudoMembre, DateNM, RueM, CPM, VillM, PaysM, Numtel, Email, NomM, PrenomM, PasseWordM, idTypeMembre)"
                    + "values ('"+ pseudo +"', '"+dateN+ "', '"+ rue + "', '"+ cpm + "', '"+ ville +"', '"+ pays + "', '"+ numtel+ "', '" 
                            + email + "', '"+ nom+ "', '"+ prenom+ "', '"+ mdp + "' , 1)";
            System.out.println(query);
                            
            result = statement.executeQuery(query);
            if(result.next()){
               System.out.println("inscription reussie");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, statement);
        }
    }
    
}
