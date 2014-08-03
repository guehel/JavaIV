package poo.session3.tp1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vueEmploye extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtNom;
	private JTextField txtSalaire;
	private JButton btnAjouter ;
	private JButton btnRechercher;
	private JButton btnQuitter;
	private JComboBox cbNumero;
	private JTextArea txtResultat;
	private JTextPane txtInformations;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueEmploye frame = new vueEmploye();
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
	public vueEmploye() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNord = new JPanel();
		contentPane.add(pnlNord, BorderLayout.NORTH);
		
		JPanel pnlSud = new JPanel();
		contentPane.add(pnlSud, BorderLayout.SOUTH);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pnlSud.add(btnAjouter);
		
		btnRechercher = new JButton("Rechercher");
		pnlSud.add(btnRechercher);
		
		btnQuitter = new JButton("Quitter");
		pnlSud.add(btnQuitter);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ajouter", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 11, 46, 14);
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(96, 8, 86, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 40, 46, 14);
		panel.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(96, 37, 86, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblSalaire = new JLabel("Salaire");
		lblSalaire.setBounds(10, 80, 46, 14);
		panel.add(lblSalaire);
		
		txtSalaire = new JTextField();
		txtSalaire.setBounds(96, 68, 86, 20);
		panel.add(txtSalaire);
		txtSalaire.setColumns(10);
		
		txtInformations = new JTextPane();
		txtInformations.setEditable(false);
		txtInformations.setBounds(262, 31, 147, 108);
		panel.add(txtInformations);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setBounds(262, 11, 86, 14);
		panel.add(lblInformations);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rechercher", null, panel_1, null);
		panel_1.setLayout(null);
		
		cbNumero = new JComboBox();
		cbNumero.setBounds(52, 36, 57, 20);
		panel_1.add(cbNumero);
		
		JLabel lblNumero_1 = new JLabel("Numero");
		lblNumero_1.setBounds(52, 9, 46, 14);
		panel_1.add(lblNumero_1);
		
		txtResultat = new JTextArea();
		txtResultat.setBounds(231, 34, 164, 121);
		panel_1.add(txtResultat);
		
		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setBounds(234, 9, 69, 14);
		panel_1.add(lblResultat);
	
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

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public JComboBox getCbNumero() {
		return cbNumero;
	}
	public void changerVueAjouter( String message){
		this.txtInformations.setText(message);
	}
	public void changerVueAjouter(Employe employe, String message) {
		
		this.txtNom.setText(employe.getNom());
		this.txtNumero.setText(employe.getNumero()+"");
		this.txtSalaire.setText(employe.getSalaire()+"");
		changerVueAjouter( message);
		
	}
	public void changerVueRechercher( String message){
		this.txtResultat.setText(message);
	}
	public void changerVueRechercher( String message, String[] cles) {
		 DefaultComboBoxModel model = (DefaultComboBoxModel) cbNumero.getModel();
		  model.removeAllElements();

	        for (String item : cles) {
	            model.addElement(item);
	        }
	        cbNumero.setModel(model);
		changerVueRechercher(message);
		
	}
	
}
