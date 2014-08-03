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
 * Interface qu'implemente tous les observable */
public interface Observable {
	/** sert a l'ajout de'observateur*/
	public void setObservateur(Observateur observateur);
	
	/** 
	 * avertie l'observateur de l'existance d'une machine*/
	public void notify(Machine machine);
	
	/**avertie l'osbervateur avec  une addresse machine */
	public void notify(String machine);
	
	/** avertie l'observateur de la liste des machines */
	public void notify(Map <String, Machine> machine);
	
	/** avertie d'un changement d'etat*/
	public void notify(boolean reussie);
}
