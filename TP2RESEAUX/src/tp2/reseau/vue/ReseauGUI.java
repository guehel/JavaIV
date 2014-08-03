/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.reseau.vue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import tp2.reseau.model.Machine;
import tp2.reseau.model.MachineLocale;


/**fenetre d'affichage de l'application
 * @author boug18087415
 *
 */
public class ReseauGUI extends Fenetre {

    /**
     * Creates new form ReseauGUI
     */
    private PnlCentral pnlCentral;
    private PnlMachine pnlMachineLocale;
    private PnlMachine pnlMachineDistante;

    public ReseauGUI() {
       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1024, 550);
        this.setResizable(false);
        pnlCentral = new PnlCentral(tableModele);
        pnlMachineLocale = new PnlMachine();
        pnlMachineDistante = new PnlMachine();
        pnlMachineDistante.setTitre("MACHINE DISTANTE");
        pnlMachineDistante.getBtn().setEnabled(false);
        pnlMachineDistante.getBtn().setText("Fichier destination");
        pnlMachineDistante.getTextField().setText("C:\\temp\\tp2.txt");
        add(pnlMachineLocale, BorderLayout.WEST);
        add(pnlCentral, BorderLayout.CENTER);
        add(pnlMachineDistante, BorderLayout.EAST);
    }

      


	@Override
	public String geIPMachine() {
		String IP = "";
		int ligneSelectionne = pnlCentral.getSelectedLine();
		if(ligneSelectionne<0)signalerErreur("Aucune Ligne selectionnée");
			
		else  IP = (String) tableModele.getValueAt(ligneSelectionne, 1);
		return IP;
	}




	@Override
	public JButton getBtnQuitter() {
			return null;
	}




	@Override
	public JButton getBtnDemarrer() {
		return pnlCentral.getBtn();
	}




	@Override
	public JButton getBtnEnvoyerFichier() {
		return pnlMachineLocale.getBtn();
	}




	@Override
	public JTextField getTxtFichier() {
		// TODO Auto-generated method stub
		return pnlMachineLocale.getTextField();
	}


	@Override
	public void update(Machine machine) {
		PnlMachine pan = pnlMachineDistante;
		pan.getLblIPLocalm().setText("");
		MachineLocale lMachine  = null;
		try
		{
		lMachine = (MachineLocale)machine;
		pan = pnlMachineLocale;
		pan.getLblIPLocalm().setText(lMachine.getAdresseLocale());
		}
		catch(Exception e)
		{	
			
		}
		pan.getLblNomCLocal().setText(machine.getAdresseIp());
		pan.getLblNomLocal().setText(machine.getNom());
		pan.getLblIPLoop().setText(machine.getNomComplet());
	

	}
   
}
