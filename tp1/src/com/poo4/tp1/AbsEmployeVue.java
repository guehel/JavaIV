package com.poo4.tp1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AbsEmployeVue extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtNom;
	private JTextField txtSalaire;
	private JTextField textField;
	private JButton btnEnregistrer;
	private JButton btnRechercher;
	private JButton btnQuitter;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbsEmployeVue frame = new AbsEmployeVue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AbsEmployeVue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCentre = new JPanel();
		contentPane.add(pnlCentre, BorderLayout.CENTER);
		pnlCentre.setLayout(null);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(39, 29, 46, 14);
		pnlCentre.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(193, 26, 86, 20);
		pnlCentre.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(39, 72, 46, 14);
		pnlCentre.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(193, 69, 86, 20);
		pnlCentre.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblSalaire = new JLabel("Salaire");
		lblSalaire.setBounds(39, 114, 46, 14);
		pnlCentre.add(lblSalaire);
		
		txtSalaire = new JTextField();
		txtSalaire.setBounds(193, 111, 86, 20);
		pnlCentre.add(txtSalaire);
		txtSalaire.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(39, 171, 344, 20);
		pnlCentre.add(textField);
		textField.setColumns(10);
		
		JPanel pnlSud = new JPanel();
		contentPane.add(pnlSud, BorderLayout.SOUTH);
		
		btnEnregistrer = new JButton("Enregistrer");
		pnlSud.add(btnEnregistrer);
		
		btnRechercher = new JButton("Rechercher");
		pnlSud.add(btnRechercher);
		
		btnQuitter = new JButton("Quitter");
		pnlSud.add(btnQuitter);
		
		JPanel pnlNord = new JPanel();
		contentPane.add(pnlNord, BorderLayout.NORTH);
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

	public JTextField getTxtSalaire() {
		return txtSalaire;
	}

	public JButton getBtnEnregistrer() {
		return btnEnregistrer;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	@Override
	public void update(Observable modele, Object arg1) {
		Employe emp =((EmployeModele)modele).getEmploye();
		String message =((EmployeModele)modele).getMessage();
		this.textField.setText(message);
		this.txtNumero.setText(emp.getNumero()+"");
		this.txtNom.setText(emp.getNom());
		this.txtSalaire.setText(emp.getSalaire()+"");
		
	}
	
	
}
