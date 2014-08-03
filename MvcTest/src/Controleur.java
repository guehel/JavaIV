import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controleur {
	private UnTest fenetre;
	private Modele modele;

	private class TexteListener implements ActionListener {

	

		@Override
		public void actionPerformed(ActionEvent arg0) {
		String texteSaisie= fenetre.getTexte();
		modele.setTexte(texteSaisie);

		}

	}
	
	
	public Controleur(){
		fenetre = new UnTest();
		fenetre.setVisible(true);
		modele = new Modele(); 
		modele.addObserver(fenetre);
		fenetre.getBtnEntrerText().addActionListener(new TexteListener());
	}

}
