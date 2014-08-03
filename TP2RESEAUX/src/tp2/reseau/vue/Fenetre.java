package tp2.reseau.vue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import tp2.reseau.model.Machine;


import java.util.Map;

/**Classe abstraite don herite toutes fenetre de l'application
 * @author boug18087415
 *
 */
/**
 * @author boug18087415
 *
 */
public abstract class Fenetre extends JFrame implements FenetreMachines{


//	public class TxtNombreListener implements DocumentListener {
//
//
//		@Override
//		public void removeUpdate(DocumentEvent e) {
//			//			valider();
//
//		}
//
//		@Override
//		public void insertUpdate(DocumentEvent e) {
//			valider();
//
//		}
//
//		private void valider() {
//			try{
//				//	int salaire = Integer.parseInt(txtSalaire.getText());
//
//			}
//			catch(NumberFormatException e){
//				signalerErreur("Veuillez saisir un nombre");
//			}
//
//
//		}
//
//		@Override
//		public void changedUpdate(DocumentEvent e) {
//			valider();
//
//		}
//
//	}

	public static String BOUTON_QUITTER = "Quitter";
	public static String BOUTON_DEMARRER = "Obtenir Info";
	public static String BOUTON_FICHIER = "Envoyer fichier";
	public static String LBL_L0C_NOM = "Nom de la machine locale:";
	public static String LBL_LOC_IP = "IP de la machine locale:";
	public static String LBL_LOC_LOOP_IP = "IP boulcle de la machine locale:";
	public static String LBL_LOC_CPLT_NOM  = "Nom complet de la machine locale:";
	public static String LBL_RESEAU  = "Machines de mon réseau";
	public static String ENTETE_MACHINES [] = {"Machine ", "Adresse IP"};

	protected JTextField txtFichier;
	protected JTextField txtNomMachine;

	protected JButton 	btnDemarrer, 
	btnEnvoyerFichier;
	
	/**Table modele qui permet de modifier le tableau representant la liste des voisins
	 * 
	 */
	protected TableModel tableModele;
	protected JLabel 	lblNomLocal, 
	lblNomCLocal , 
	lblIPLocalm, 
	lblIPLoop;


	/**
	 * Create the frame.
	 */
	public Fenetre() {
		Object [][] data =  {{"nom.Reseau.lan", "***.***.***.***"},{"", ""}};
		tableModele = new TableModel(ENTETE_MACHINES, data);

	}


	public void signalerErreur(String string) {

		JOptionPane.showMessageDialog(null,
				string,"Message",
				JOptionPane.INFORMATION_MESSAGE);
	}

	



	@Override
	public void update(String message) {
		this.signalerErreur(message);
	}

	/* (non-Javadoc)
	 * @see tp2.reseau.model.Observateur#update(boolean)
	 */
	@Override
	public void update(boolean reussiteService) {
		String message = "La demande a ";
		message += reussiteService?"réussie":"echoué";
		signalerErreur(message);

	}
	/* (non-Javadoc)
	 * @see tp2.reseau.model.Observateur#update(java.util.Map)
	 */
	@Override
	public void update(Map<String, Machine> voisins) {
		int nbreMachines = voisins.keySet().size();

		Object [][] listeMachines = new Object[nbreMachines][2];
		Object [] machines = (voisins.values().toArray());
		for(int i =0; i<nbreMachines; i++){
			listeMachines[i] [0] =((Machine) machines[i]).getNom();
			listeMachines[i] [1] =((Machine) machines[i]).getAdresseIp();
		}
		
		tableModele.setData(listeMachines);
	}


	
	public JTextField getTxtNomMachine() {
		return txtNomMachine;
	}


	public abstract String geIPMachine();


	


}
