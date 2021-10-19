package enchere.controler;

import enchere.model.*;
import java.util.ArrayList;

public class GestionMembresControler {
	private MembreServiceCommercial membreServiceCommercial;
	private MembreServiceInformatique membreServiceInformatique;
	private MembreServiceJuridique membreServiceJuridique;
	private MembreClient membreClient;
        private Membre membre;
	
	public GestionMembresControler() {
            membre = new Membre();
//            Membre m = new MembreClient();
//            if(m instanceof MembreClient){
//                MembreClient m2 = (MembreClient) m;
//            }
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
            //return Membre.getLoginMembre(pseudo, mdp, typeInt);
        }
        
        public void inscrire(String nom, String prenom, String dateN, String email, String rue, String cpm, 
                String ville, String pays, String numtel, String pseudo, String mdp){
            membreClient.inscrire(nom, prenom, dateN, email, rue, cpm, ville, pays, numtel, pseudo, mdp);
            
        }
}
