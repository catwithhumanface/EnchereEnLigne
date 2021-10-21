package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;

public class Objet {

    private int numO;
    private int idObjet;
    private String titreA;
    private String descO;
    private int prixDepart;
    private int prixReserve;
    private int prixAchatImmediat;
    private int fraisPort;
    private int regionLiv;
    private int dateCloture;
    private String etatVente;
    private int prixAchat;
    private int visiteObjet;
     private Frais frais;
     
    public Objet(int numO){
        this.numO=numO;
        frais = new Frais();
        }

    public void setNumO(int numO) {
        this.numO = numO;
    }

    public void setPrixDepart(int prixDepart) {
        this.prixDepart = prixDepart;
    }

    public void setEtatVente(String etatVente) {
        this.etatVente = etatVente;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setVisiteObjet(int visiteObjet) {
        this.visiteObjet = visiteObjet;
    }
    
    public int getNumO() {
        return numO;
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


    public int getDateCloture() {
        return dateCloture;

    public String getRegiondelivraison() {
        return regiondelivraison;
    }

    public Date getDatedecloture() {
        return datedecloture;


    public String getEtatVente() {
        return etatVente;
    }

    public int getPrixAchatFinal() {
        return prixAchat;
    }

    public int getVisiteObjet() {
        return visiteObjet;
    }
    //Calcul les frais d'insertion d'un objet 
     public float calculFraisInsertion( Objet objet) {
         
        int prixDepart=0;
        float fraisInsertionObjet=0;
        prixDepart=objet.getPrixDepart();
        
        if(prixDepart>100){
            fraisInsertionObjet=frais.getListFraisInsertion().get(3);
        }
        else if(prixDepart>25 && prixDepart<99.99){
             fraisInsertionObjet=frais.getListFraisInsertion().get(2);
        }
        else if(prixDepart>10 && prixDepart<24.99){
             fraisInsertionObjet=frais.getListFraisInsertion().get(1);
        }
        else if(prixDepart>0 && prixDepart<9.99){
             fraisInsertionObjet=frais.getListFraisInsertion().get(0);
        }
        System.out.println("NUM  "+objet.getNumO()+"fraisInsertion"+fraisInsertionObjet+"prix dep"+prixDepart);
        return fraisInsertionObjet;

    }
    //Calcul les frais de commission sur un objet  
     public float calculFraisCommission(Objet objet) {
        int prixAchat=0;
        float fraisCommissionObjet=0;
        prixAchat=objet.getPrixAchatFinal();
        if(prixAchat>1000){
            fraisCommissionObjet=frais.getListFraisCommission().get(2);
        }
        else if(prixAchat>50 && prixAchat<=1000){
             fraisCommissionObjet=frais.getListFraisCommission().get(1);
        }
        else if(prixAchat>0 && prixAchat<=50){
             fraisCommissionObjet=frais.getListFraisCommission().get(0);
        }
       System.out.println("frais commission"+fraisCommissionObjet+prixAchat);
        return fraisCommissionObjet*prixAchat;
    }
     //Cette méthode calcul le CA  sur un objet
    public float calculCAObjet(Objet objet) {
      float CAObjet=0;
      float fraisCommissionObjet=0;
      float fraisInsertionObjet=0;
      
      fraisCommissionObjet=calculFraisCommission(objet);
      fraisInsertionObjet=calculFraisInsertion(objet);
      
      CAObjet=fraisCommissionObjet+fraisInsertionObjet;
      return CAObjet;
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

    public void misenVente(String TitreA, String DescO, int PrixDepart, int PrixReserver,
            int PrixAchatimmediat, String Regiondelivraison, Date Datedecloture,
            int FraisPort, String Cate, String SousCate, String Sous_sous) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        
        // les requetes qui cherchent les ID correspondant et insérer les infos de vente
        String sql = GestionVenteSQL.MISENVENTE;
        String sqlGetCate = GestionVenteSQL.GETIDCATE;
        String sqlGetCateSous = GestionVenteSQL.GETIDCATESous;
        String sqlGetCateSous_sous = GestionVenteSQL.GETIDCATESous_sous;

        int IdCodeCat = 1;
        int IdSousCategorie = 1;
        int IdSous_sous = 1;

        ResultSet result = null;

        try {

            connection = dbConnexionManager.getConnection();
            pstmt = connection.prepareStatement(sqlGetCate);
            pstmt.setString(1,Cate);
            
            result = pstmt.executeQuery();

            if (result.next()) {
                IdCodeCat = result.getInt("IdCodeCat");
            }

            pstmt = connection.prepareStatement(sqlGetCateSous);
            pstmt.setString(1,SousCate);
         
            result = pstmt.executeQuery();

            while (result.next()) {
                IdSousCategorie = result.getInt("idSousCategorie");
                
            }

            pstmt = connection.prepareStatement(sqlGetCateSous_sous);
            pstmt.setString(1,Sous_sous);
            result = pstmt.executeQuery();

            while (result.next()) {
                IdSous_sous = result.getInt("idSous_sous");
            }
            
            // Remplir tous les variables 
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, TitreA);
            pstmt.setString(2, DescO);
            pstmt.setInt(3, PrixDepart);
            pstmt.setInt(4, PrixReserver);
            pstmt.setInt(5, PrixAchatimmediat);
            pstmt.setString(6, Regiondelivraison);
            pstmt.setDate(7, Datedecloture);
            pstmt.setInt(8, FraisPort);
            pstmt.setInt(9, IdCodeCat);      
            pstmt.setInt(10, IdSousCategorie);
            pstmt.setInt(11, IdSous_sous);
            
            // vérifier si les données sont bien saisis
            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println("Mise en vente reussie");
              }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
          dbConnexionManager.closeObjects(connection, pstmt);
        }
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
