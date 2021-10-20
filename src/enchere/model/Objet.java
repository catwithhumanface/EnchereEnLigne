package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Objet {
    private int idObjet;
    private String titreA;
    private String descO;
    private int prixDepart;
    private int prixReserve;
    private int prixAchatImmediat;
    private String regiondelivraison;
    private Date datedecloture;
    private String etatVente;
    private int prixAchat;
    private int idMembre;
    private int idFrais;
    private int idCodeCat;
    
    private ArrayList<Objet> objets = new ArrayList<Objet>();
    
    public Objet(){
        
    }

    public Objet(int idObjet, String titreA, String descO, int prixDepart, int prixReserve, int prixAchatImmediat, String regiondelivraison, Date datedecloture, String etatVente, int prixAchat, int idMembre, int idFrais, int idCodeCat) {
        this.idObjet = idObjet;
        this.titreA = titreA;
        this.descO = descO;
        this.prixDepart = prixDepart;
        this.prixReserve = prixReserve;
        this.prixAchatImmediat = prixAchatImmediat;
        this.regiondelivraison = regiondelivraison;
        this.datedecloture = datedecloture;
        this.etatVente = etatVente;
        this.prixAchat = prixAchat;
        this.idMembre = idMembre;
        this.idFrais = idFrais;
        this.idCodeCat = idCodeCat;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public String getTitreA() {
        return titreA;
    }

    public String getDescO() {
        return descO;
    }

    public int getPrixDepart() {
        return prixDepart;
    }

    public int getPrixReserve() {
        return prixReserve;
    }

    public int getPrixAchatImmediat() {
        return prixAchatImmediat;
    }

    public String getRegiondelivraison() {
        return regiondelivraison;
    }

    public Date getDatedecloture() {
        return datedecloture;
    }

    public String getEtatVente() {
        return etatVente;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public int getIdFrais() {
        return idFrais;
    }

    public int getIdCodeCat() {
        return idCodeCat;
    }

    public ArrayList<Objet> getObjets() {
        return objets;
    }
    
    //récupérer tous les objets en vente afin d'afficher sur la page consultation
    public ArrayList<Objet> getLesObjets() {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = dbConnexionManager.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery("Select * from Objet");
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
                Objet objet = new Objet(idObjet, titreA, descO, prixDepart, prixReserve, prixAchatImmediat, regiondelivraison, datedecloture, etatVente, prixAchat, idMembre, idFrais, idCodeCat);
                objets.add(objet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dbConnexionManager.closeObjects(connection, statement);
        }
        return objets;
    }
}
