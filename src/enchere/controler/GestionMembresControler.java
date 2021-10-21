package enchere.controler;

import enchere.model.*;
import java.util.ArrayList;
import java.sql.Date;

public class GestionMembresControler {
    private MembreServiceCommercial membreServiceCommercial;
    private MembreServiceInformatique membreServiceInformatique;
    private MembreServiceJuridique membreServiceJuridique;
    private MembreClient membreClient;
    private Membre membre;

    public GestionMembresControler() {
        membre = new Membre();
        membreClient = new MembreClient();
    }

    public ArrayList<String> getTypeMembres(){
        return membre.getTypeMembres();
    }
    
    public Membre getLoginMembre(String pseudo, String mdp, String type){
        int typeInt =0;
        if(type.equals("Client")) {
            typeInt =1;
        }else if(type.equals("Service Informatique")) {
            typeInt =2;
        }else if(type.equals("Service Commercial")) {
            typeInt =3;
        }else if(type.equals("Service Juridique")) {
            typeInt =4;
        }
        return membre.getLoginMembre(pseudo, mdp, typeInt);
    }

    public Boolean inscrire(String nom, String prenom, Date dateN, String email, String rue, String cpm, 
            String ville, String pays, String numtel, String pseudo, String mdp){

        return membreClient.inscrire(nom, prenom, dateN, email, rue, cpm, ville, pays, numtel, pseudo, mdp);

    }

    public Boolean checkPseudo(String pseudo){
        return membreClient.checkPseudo(pseudo);
    }
    
    public ArrayList<Objet> getMesVentes(int idMembre){
        return membreClient.getMesVentes(idMembre);
    }
    
    public ArrayList<Enchere> getMesEncheres(int idMembre){
        return membreClient.getMesEncheres(idMembre);
    }
}