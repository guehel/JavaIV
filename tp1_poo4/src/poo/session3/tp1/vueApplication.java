package poo.session3.tp1;

import java.util.Observable;
import java.util.Observer;

public class vueApplication extends vueEmploye implements Observer {

	@Override
	public void update(Observable observable, Object arg1) {
		Employe employe = ((ModeleEmploye)observable).getEmploye();
		String message =  ((ModeleEmploye)observable).getMessage();
		String [] cles =  ((ModeleEmploye)observable).getKey();
		super.changerVueAjouter(employe, message);
		super.changerVueRechercher( message,cles );

	}

}
