package enchere.model;

import java.sql.Date;

public class Enchere {
    private int montantPasE;
    private int montantMaxE;
    private Date dateheureEnchere;
    private int idMembre;
    private int idObjet;
    
    public Enchere(){
        
    }
    
    public Enchere(int montantPasE, int montantMaxE, Date dateheureEnchere, int idMembre, int idObjet) {
        this.montantPasE = montantPasE;
        this.montantMaxE = montantMaxE;
        this.dateheureEnchere = dateheureEnchere;
        this.idMembre = idMembre;
        this.idObjet = idObjet;
    }
    
    public int getMontantPasE() {
        return montantPasE;
    }

    public void setMontantPasE(int montantPasE) {
        this.montantPasE = montantPasE;
    }

    public int getMontantMaxE() {
        return montantMaxE;
    }

    public void setMontantMaxE(int montantMaxE) {
        this.montantMaxE = montantMaxE;
    }

    public Date getDateheureEnchere() {
        return dateheureEnchere;
    }

    public void setDateheureEnchere(Date dateheureEnchere) {
        this.dateheureEnchere = dateheureEnchere;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }
    
    
    
}
