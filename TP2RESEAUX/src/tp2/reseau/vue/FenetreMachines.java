package tp2.reseau.vue;



import javax.swing.JButton;
import javax.swing.JTextField;

import tp2.reseau.model.Observateur;



/**Interface pour les fenetre de l'application
 * @author boug18087415
 *
 */
public interface FenetreMachines extends Observateur{
	
	
	public JButton getBtnQuitter();
	public JButton getBtnDemarrer();
	public JButton getBtnEnvoyerFichier();
	public JTextField getTxtFichier();
	


	


}
