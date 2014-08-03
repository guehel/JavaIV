package tp2.java4.modele;

public class Ajout extends  Action {
	

	public Ajout(Reserve reserve) {
		super(reserve);
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void calculer(int quantite) {
		reserve.ajoute(quantite);
		
	}

}
