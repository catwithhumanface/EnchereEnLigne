package enchere.controler;

import enchere.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GestionStatsControler {
    
    private Categorie categorie;
    private GestionStatsModel gsm;
    private Statistique stat;
    public GestionStatsControler(){
        //categorie=new Categorie();
        gsm=new GestionStatsModel();
        stat=new Statistique();
    }
    public List<String> getMyLibCategories() throws ClassNotFoundException{
        //Retourne la liste des libellés des catégories
        List<Categorie> categories;
        List<String> libCategories;
        libCategories= new ArrayList<String>();
        // categories stock tourne toutes les catégories de la BDD
        categories=gsm.getCategories();
        for(Categorie categorie : categories){
            libCategories.add(categorie.getName());
        }
        return libCategories;
    }
    public int getNbObjets(String libCategorie){
       return  gsm.calculNbObjet(libCategorie);
    }
    public float getCACategorie(String libCategorie) throws ClassNotFoundException{
                return gsm.calculCA(libCategorie);
    }
    public int getNbVisiteCategorie(String libCategorie) throws ClassNotFoundException{
        return gsm.calculNbVisiteCategorie(libCategorie);
    }
    
    public int getNbObjetTotal(){
        return stat.calculNbObjetTotal();
    }
    //Cette fonction retourne les visites totales pour une semaine
    private int getNbVisiteTotal(){
        return stat.calculVisiteTotal();
    }
    //Cette fonction retourne le CA Total par catégorie pour une semaine
    private float getCATotal(){
        return stat.calculTotalCA();
    }
    public void insererStat() throws ClassNotFoundException{
        gsm.insertStat();
    }
    public String afficherSemaine() throws ClassNotFoundException{
        LocalDate dateActuelle;
        dateActuelle=LocalDate.now();
        
        return stat.calculSemaine(dateActuelle);
    }
    
}
