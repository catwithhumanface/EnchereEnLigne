/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enchere.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liely
 */
public class ObjetService {
    private ResultSet result = null;
    private Connection connection = null;
    private Statement statement = null;
    private Categorie categorie = null;

    public ObjetService() {
        
    }
    
    public static Objet fromResultRowToObjet(ResultSet result) {
        int numO=0;
        String titreA = "";
        int prixAchat=0;
        int prixDepart=0;
        Objet objet=null;
        
        try {
            numO = result.getInt("IdObjet");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            prixAchat = result.getInt("PrixAchat");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            prixDepart = result.getInt("PrixDepart");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        objet=new Objet(numO);
        objet.setPrixAchat(prixAchat);
        objet.setPrixDepart(prixDepart);
        
        return objet;
    }
   
}
