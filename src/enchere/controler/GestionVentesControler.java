package enchere.controler;
import enchere.model.Categorie;
import enchere.model.Enchere;
import enchere.model.MembreClient;
import enchere.model.SousCategorie;
import enchere.model.Sous_sousCate;
import enchere.model.Objet;
import enchere.model.Enchere;
import java.util.ArrayList;
import enchere.model.RegionL;
import java.sql.Date;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GestionVentesControler {
    private ArrayList<Objet> objets = new ArrayList<Objet>();
    private Categorie categorie;
    private SousCategorie souscate;
    private Sous_sousCate sousSous;
    private RegionL region;
    private Enchere enchere;
    private MembreClient membreClient;
    
    public GestionVentesControler(){
        categorie = new Categorie();
        souscate = new SousCategorie();
        sousSous = new Sous_sousCate();
        objet = new Objet();
        region = new RegionL();
        enchere = new Enchere();
    }
    
    public  ArrayList<String> getTypeRegion(){
        return region.getTypeRegion(); 
    }
    public ArrayList<String> getCategorie(){
        return categorie.getTypeCategorie(); 
    }
    
    public ArrayList<String> getSousCategorie(String Cateajout){
        
        return souscate.getTypeSousCat(Cateajout);
    
    }
    
    public ArrayList<String> getSous_sousCat (String sousCate){
        
        
        return sousSous.getSous_sousCat(sousCate);
    
    }
    
    public void validerMisenVente(String TitreA,String DescO,int PrixDepart,int PrixReserver, 
            int PrixAchatimmediat,String Regiondelivraison, Date Datedecloture, 
            int FraisPort,String Cate,String souscate,String Sous_sous){
        objet.misenVente(TitreA, DescO, PrixDepart, PrixReserver, PrixAchatimmediat, Regiondelivraison, Datedecloture, 
                FraisPort, Cate, souscate,Sous_sous);
     }
     
     
    public ArrayList<Objet> getLesObjets() {
        return objet.getLesObjets();
    }
    
    public void validerEnchere(int montantPas,int montantMax,int idNumo,int idMembre,Timestamp dateheure){
        enchere.validerEncherir(montantPas,montantMax,idNumo,idMembre,dateheure);
     }
                
    public ArrayList<Enchere> getEncheres(int idObjet){
        return objet.getEncheres(idObjet);
    }
    
    public String getNomPrenomMembre(int idMembre){
        return objet.getNomPrenomMembre(idMembre);
    }
}
