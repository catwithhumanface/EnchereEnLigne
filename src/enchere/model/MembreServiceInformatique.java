package enchere.model;

public class MembreServiceInformatique extends Membre {
    private int idMembre;
    private String pseudoMembre;
    private String dateNM;
    private String rueM;
    private String villeM;
    private String paysM;
    private String etatM;
    private String numTel;
    private String email;
    private String nomM;
    private String prenomM;
    private String passeWordM;
    
    public MembreServiceInformatique(int idMembre, String pseudoMembre, String dateNM, String rueM, String villeM, String paysM, String etatM,
            String numTel, String email, String nomM, String prenomM, String passeWordM){
        this.idMembre = idMembre;
        this.pseudoMembre = pseudoMembre;
        this.dateNM = dateNM;
        this.rueM = rueM;
        this.villeM = villeM;
        this.paysM = paysM;
        this.etatM = etatM;
        this.numTel = numTel;
        this.email = email;
        this.nomM = nomM;
        this.prenomM = prenomM;
    }
}
