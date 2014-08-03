package exo.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur {

	public static void main(String[] args) {
	final Modele modele = new Modele(50);
	
	VueCompteur vue = new VueCompteur();
	vue.getBtnOnOff().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			modele.onOff();
			
		}
	});
	
	vue.getBtnStart().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modele.demarrer();
			
		}
	});
	
	vue.getBtnReset().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modele.reset();
			
		}
	});
	modele.addObserver(vue);
	vue.setVisible(true);

	}

}
