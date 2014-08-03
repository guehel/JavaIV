package exo.threads;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueCompteur extends JFrame implements Observer {
	
	private JTextField txtCompteur;
	private JButton btnStart;
	private JButton btnReset;
	private JButton btnOnOff;
	
	public VueCompteur(){
		this.setTitle("Compteur");
		txtCompteur = new JTextField(20);
//		txtCompteur.setEditable(false);
		btnReset = new JButton("Reset");
		btnStart = new JButton("Start");
		btnOnOff = new JButton("OnOff");
		JPanel p = new JPanel();
		p.add(txtCompteur);
		p.add(btnStart);
		p.add(btnReset);
		p.add(btnOnOff);
		this.getContentPane().add(p,BorderLayout.CENTER);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.setVisible(true);
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String compteur = ((Modele)arg0).getNombre()+"";
		this.txtCompteur.setText(compteur);
		

	}
	
	public JTextField getTxtompteur() {
		return txtCompteur;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnOnOff() {
		return btnOnOff;
	}
	
	

}
