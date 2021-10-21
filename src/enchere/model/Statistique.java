package enchere.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statistique {
    private String semaine;
    private int totalCA;
    private ResultSet result = null;
    private Connection connection = null;
    private Statement statement = null;
    private Categorie categorie = null;
    private GestionStatsModel gsm;
    
    public Statistique(){
        
    }
    //Calcul semaine, year+Semaine
    public String calculSemaine(LocalDate date) throws ClassNotFoundException{
       
        int numeroSemaine;
        int numeroAnnee;
        //Calcul du numéro d'une semaine et conversion en string
        numeroSemaine=date.get(java.time.temporal.WeekFields.of(java.util.Locale.getDefault()).weekOfWeekBasedYear());
        String WWString = String.valueOf(numeroSemaine);
        //Calcul de l'annee et conversion de l'année en String
        numeroAnnee=date.getYear();
       
        String yearString = String.valueOf(numeroAnnee);
       
        //Insérer les semaines dans la BDD
        semaine=yearString+WWString;
       
        return semaine;
    }

    public void setTotalCA(int totalCA) {
        this.totalCA = totalCA;
    }
    
    public float calculTotalCA(){
        gsm=new GestionStatsModel();
        float CATotal=0;
        float CACategorie=0;
       
            //On vérifie si la semaine n'est pas déja crée, on initialise le CA lors d'une nouvelle semaine
            
                
                try {
                    for(Categorie categorie : gsm.getCategories()){
                        String libelleCategorie=categorie.getName();
                        //Lors d'une nouvelle semaine on initialise le CA
                       
                        CATotal=CATotal+CACategorie;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
                }
            
       
        return CATotal;
    }
    public int calculVisiteTotal(){
        gsm=new GestionStatsModel();
        int visiteTotal=0;
        int visiteCategorie=0;
        try {
            for(Categorie categorie : gsm.getCategories()){
                String libelleCategorie=categorie.getName();
                visiteCategorie=gsm.calculNbVisiteCategorie(libelleCategorie);
                visiteTotal=visiteCategorie+visiteTotal;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visiteTotal;
    }
    public int calculNbObjetTotal(){
        gsm=new GestionStatsModel();
        int nbObjetTotal=0;
        int nbObjetCategorie=0;
        try {
            for(Categorie categorie : gsm.getCategories()){
                String libelleCategorie=categorie.getName();
                nbObjetCategorie=gsm.calculNbVisiteCategorie(libelleCategorie);
                nbObjetTotal=nbObjetCategorie+nbObjetTotal;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nbObjetTotal;
    }
    
    
}
