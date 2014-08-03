package tp2.java4.persistance;

import java.util.Observable;
import java.util.Observer;

import tp2.java4.modele.Reserve;

public class Enregistreur implements Observer{

	public void calculerMoyenne() {
		// TODO Auto-generated method stub
		
	}

	public void calculerPenalites() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Reserve reserve = (Reserve)arg0;
		System.out.println("modif  "+ reserve.getLastChange());
		System.out.println("Compteur "+ reserve.getCompteur());
		System.out.println("Penalité "+ reserve.getPenalites());
		System.out.println("Stock "+ reserve.getStock());
		System.out.println("Moyenne "+ reserve.getMoyenneStock());
	}

}
