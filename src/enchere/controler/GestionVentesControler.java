package enchere.controler;
import enchere.model.Categorie;
import enchere.model.SousCategorie;
import enchere.model.Sous_sousCate;
import enchere.model.Objet;
import java.util.ArrayList;
import enchere.model.RegionL;
import java.sql.Date;

public class GestionVentesControler {
    private Categorie categorie;
    private SousCategorie souscate;
    private Sous_sousCate sousSous;
    private Objet objet;
    private RegionL region;
    
    public GestionVentesControler(){
        categorie = new Categorie();
        souscate = new SousCategorie();
        sousSous = new Sous_sousCate();
        objet = new Objet();
        region = new RegionL();
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
            int FraisPort,String Cate,String souscate,String Sous_sous)
    {
        objet.misenVente(TitreA, DescO, PrixDepart, PrixReserver, PrixAchatimmediat, Regiondelivraison, Datedecloture, 
                FraisPort, Cate, souscate,Sous_sous);}
}