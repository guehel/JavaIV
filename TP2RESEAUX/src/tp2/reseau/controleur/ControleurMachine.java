package tp2.reseau.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;

import tp2.reseau.vue.ReseauGUI;
import tp2.reseau.model.MachineLocale;
import tp2.reseau.vue.Fenetre;

public class ControleurMachine {


	public class FichierListener implements ActionListener {
		String IPMachineCliente;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			 choisirFichier();

			
		}
		
		private void choisirFichier(){
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(vue);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				String nomFichier = file.getAbsolutePath();
				 vue.getTxtFichier().setText(nomFichier);
				machineLocale.envoyerFichier(file);
			}
		}

	

	}

	public class DemarrerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ipVoisin = vue.geIPMachine();
			if(estAdresseValide(ipVoisin)){
				machineLocale.rechercherVoisin(ipVoisin);
			}else{
				vue.signalerErreur("le format de l'adresse est invalide");
			}
			
		}


	}
	
	private boolean estUrlFichier(String nomFichier) {
		// TODO verifier le regex
		return true;
	}

	private boolean estAdresseValide(String nomFichier) {
		// TODO verifier le regex
		return true;
	}



	private MachineLocale machineLocale;
	private Fenetre vue;

	public ControleurMachine(MachineLocale machineLocale, Fenetre vue) {
		super();
		this.machineLocale = machineLocale;
		this.vue = vue;
		initApp();
	}

	private void initApp() {
		machineLocale.setObservateur(vue);
		vue.getBtnDemarrer().addActionListener(new DemarrerListener());
		vue.getBtnEnvoyerFichier().addActionListener(new FichierListener());
		vue.addWindowListener(new WindowAdapter() {
				
			@Override
			public void windowClosing(WindowEvent e) {
				   System.out.println("Closed");
	                e.getWindow().dispose();
	                System.exit(0);
				
			}
			

		});
		vue.setVisible(true);

	}

	public static void main(String[] args) {
		
		MachineLocale machine = null;
		Fenetre fenetre = null;
		fenetre = new ReseauGUI();
		try {
			machine = new MachineLocale();
			ControleurMachine controleur = new ControleurMachine(machine, fenetre);
			machine.demarrerServeur(55555);
			machine.decouvrirVoisins();
		
			
		} catch (UnknownHostException e) {
			fenetre.setVisible(true);
			fenetre.signalerErreur("le programme n'a pu etre charge");
			System.exit(0);
		}
		

	}

}
