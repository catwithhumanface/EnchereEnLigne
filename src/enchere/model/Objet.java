package enchere.model;

public class Objet {
    private int numO;
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
    }

    public String getTitreA() {
        return titreA;
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
    }

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
//       System.out.println(fraisCommissionObjet);
//       System.out.println(fraisInsertionObjet);
      return CAObjet;
  }
     
    

}
