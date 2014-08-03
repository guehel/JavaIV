//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : tp2
//  @ File Name : 
//  @ Date : 2014-06-06
//  @ Author : Guehel Bouanga
//
//

package tp2.reseau.model;

import java.util.Map;




/**
 * Classe abstraite qui herite de Thread implementes les methodes communes a toutes les service rendus a une machine locale 
 * et definie les methodes abstraites que doit devinir toute les classe service */
public abstract class ServiceAbstrait  implements  Observable, Runnable {
	
	
	/** Classe qui sera notifi� du resultat de l'excution du thread
	 * */
	protected Observateur observateur;
	
	
	
	/**Contructeur
	 * @param observateur qui sera notifi� du resultat de l'excution du thread
	 */
	public ServiceAbstrait(Observateur observateur) {
		super();
		this.observateur = observateur;
	}

	/** 
	 * execute la methode demarrer*/
	public void run() {
		demarrer();
	}
	
	/**
	 * methode abstraite qui execute le service correspondant */
	public abstract void demarrer();
	
	/**
	 * retourne vrai si le service a ete reussi */
	public abstract boolean reussie();
	
	/**
	 * modifie la valeur de observateur */
	public void setObservateur(Observateur observateur) {
		this.observateur = observateur;
	}
	
	/** Notifie l'observateur avec le parametre machine
	 * @param machine Object machine qui est retourne lors qu'elle est reachable
	 * */
	public void notify(Machine machine) {
		observateur.update(machine);
	}
	
	/**Notifie l'observateur de la reussite du service
	 *  */
	public void notify(boolean reussie) {
		observateur.update(this.reussie());
	}
	/**Notifie methode de L'iunterface Observable NomImplemente
	 *  */
	@Override
	public void notify(Map<String, Machine> machine) {
		
	}
	/**Notifie methode de L'iunterface Observable NomImplemente
	 *  */
	@Override
	public void notify(String machine) {	
		observateur.update(machine);
	}
	
}
