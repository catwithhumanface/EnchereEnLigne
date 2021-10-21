package enchere.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Categorie {
    private int id;
    private String libCategorie;
    private CategorieService cs;
    private ArrayList<Objet> listObjets;
    
    

    Categorie(int id, String libelle) {
       this.id=id;
       this.libCategorie=libelle;
       cs=new CategorieService();
       listObjets=new ArrayList<>();
    }
    public String getName(){
        return this.libCategorie;
    }

    public int getId() {
        return id;
    }
    
    
  }
