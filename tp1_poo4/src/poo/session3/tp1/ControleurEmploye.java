package poo.session3.tp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurEmploye {

	public class QuitterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			modele.finalize();
			System.exit(0);

		}

	}

	public class EnregistrerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Employe employe = new Employe();
			String numero = (String)vue.getTxtNumero().getText();
			String salaire =  (String)vue.getTxtSalaire().getText();
			String nom = vue.getTxtNom().getText().trim().toUpperCase();
			try{
				if(nom.isEmpty()){vue.changerVueAjouter( "Le nom est vide");}
				else{
					employe.setNom(nom);
					employe.setSalaire(Float.parseFloat(salaire));
					employe.setNumero(Integer.parseInt(numero));
					modele.ajouter(employe);
				}
			}
			catch(NumberFormatException ex){
				vue.changerVueAjouter( "Un champ saisi est erronne");
			}	

		}

	}
	public class RechercherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Employe employe = new Employe();
			String numero = (String)vue.getCbNumero().getSelectedItem();
			try{
				employe.setNumero(Integer.parseInt(numero));
				modele.rechercher(employe);
			}
			catch(NumberFormatException ex){
				vue.changerVueRechercher( "le numero saisi n est pas un nombre");
			}

		}

	}

	private ModeleEmploye modele;
	private vueApplication vue;

	public ControleurEmploye(){
		modele = new ModeleEmploye();
		vue = new vueApplication();
		initModele();
		initVue();
	}

	private void initVue() {
		vue.getBtnQuitter().addActionListener(new QuitterListener());
		vue.getBtnAjouter().addActionListener(new EnregistrerListener());
		vue.getBtnRechercher().addActionListener(new RechercherListener());
		vue.setVisible(true);


	}

	private void initModele() {
		modele.addObserver(vue);
		modele.start();

	}




}
