package enchere.controler;

import enchere.model.Objet;
import java.sql.Connection;
import java.util.ArrayList;

public class GestionVentesControler {
    private ArrayList<Objet> objets = new ArrayList<Objet>();
    private Objet objet = new Objet();
    
    public GestionVentesControler(){
        
    }
    
    public ArrayList<Objet> getLesObjets() {
        return objet.getLesObjets();
    }
}
