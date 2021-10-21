package enchere.model;

import java.sql.Date;

public class MembreServiceCommercial extends MembreServiceJuridique {

    public MembreServiceCommercial(int idMembre, String pseudoMembre, Date dateNM, String rueM, String villeM, String paysM, String etatM, String numTel, String email, String nomM, String prenomM, String passeWordM) {
        super(idMembre, pseudoMembre, dateNM, rueM, villeM, paysM, etatM, numTel, email, nomM, prenomM, passeWordM);
    }
    
}
