package tp2.java4.modele;

public class Consommation extends Action {

	
	public Consommation(Reserve reserve) {
		super(reserve);
		
	}

	public synchronized void calculer(int quantite) {
		reserve.consomme(quantite);

	}

}
