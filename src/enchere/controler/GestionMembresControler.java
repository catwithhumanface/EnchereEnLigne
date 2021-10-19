package enchere.controler;

import enchere.model.Membre;
import enchere.model.MembreClient;
import enchere.model.MembreServiceCommercial;
import enchere.model.MembreServiceInformatique;
import enchere.model.MembreServiceJuridique;

public class GestionMembresControler {
	private MembreServiceCommercial membreServiceCommercial;
	private MembreServiceInformatique membreServiceInformatique;
	private MembreServiceJuridique membreServiceJuridique;
	private MembreClient membreClient;
        private Membre membre;
	
	public GestionMembresControler() {
            membre = new Membre();
	}
        
        public void getTypeMembres(){
            membre.getTypeMembres();
        }
        
}
