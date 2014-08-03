package sem5.NIOSelector.exercices.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.EventListener;

import sem5.NIOSelector.exercices.ModeleApplication;
import sem5.NIOSelector.exercices.vue.vueExoNIO;

public class ControeleurExercice1 {
	public class KeyEntrerListener  extends AbstractKeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				System.out.println(e.getKeyChar());
				modifModele();}

		}
		}
	
	public class EnvoieListener  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			modifModele();
		}
	}

	private void modifModele(){
		String message = vue.getTxtMessage().getText();
		message = message.trim();
		modele.diffuser(message);

	}

	private ModeleApplication modele;
	private vueExoNIO vue;

	public class AjoutGroupeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String groupe = (String)vue.getCbGroupe().getSelectedItem();
			String ipGroupe = "224.2.2.";
			ipGroupe =ipGroupe+getGroupe(groupe);
			modele.rejoindreGroupe(ipGroupe);
		}

		private int getGroupe(String groupe){
			int n= 1;
			switch(groupe){
			case "Les vacances":
				break;
			case "Le retour aux etudes":
				n= 2;
				break;
			case "Mondial 2014":
			default:
				n= 3;
				break;
			}
			return n;
		}

	}



	public ControeleurExercice1(ModeleApplication modele, vueExoNIO vue) {
		super();
		this.modele = modele;
		this.vue = vue;
		this.modele.addObserver(vue);
		String defaultIpGroupe ="224.2.2.1" ;
		this.modele.rejoindreGroupe(defaultIpGroupe );
		this.modele.ecouter();
		ActionListener ajouter = new EnvoieListener();

		vue.getBtnRejoindre().addActionListener(new AjoutGroupeListener());
		vue.getBtnEnvoyer().addActionListener( ajouter);

		this.vue.setVisible(true);

	}



	public static void main(String[] args) {
		vueExoNIO vue = new vueExoNIO();
		try {
			ModeleApplication modele = new ModeleApplication(55555);
			ControeleurExercice1 c = new ControeleurExercice1(modele, vue);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
