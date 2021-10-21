package enchere.controler;

import enchere.model.*;
import java.util.ArrayList;
import java.util.List;


public class GestionStatsControler {
    
    private Categorie categorie;
    private CategorieService cs;
    
    public GestionStatsControler(){
        //categorie=new Categorie();
        cs=new CategorieService();
    }
    public List<String> getMyLibCategories() throws ClassNotFoundException{
        //Retourne la liste des libellés des catégories
        List<Categorie> categories;
        List<String> libCategories;
        libCategories= new ArrayList<String>();
        // categories stock tourne toutes les catégories de la BDD
        categories=cs.getCategories();
       for(Categorie categorie : categories){
           libCategories.add(categorie.getName());
       }
       return libCategories;
    }
    public int getNbObjets(String libCategorie){
       return  cs.calculNbObjet(libCategorie);
    }
    public float getCACategorie(String libCategorie){
                return cs.calculCA(libCategorie);
    }
    
}
