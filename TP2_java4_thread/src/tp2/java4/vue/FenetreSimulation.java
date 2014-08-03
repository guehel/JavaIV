package tp2.java4.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import tp2.java4.modele.Reserve;

public class FenetreSimulation extends VueStock {

	private JPanel contentPane;
	private JLabel lblRupturesDeStock;
	private JFormattedTextField txtProd1;
	private JFormattedTextField txtProd2;
	private JFormattedTextField txtConsommation;
	private JFormattedTextField txtDelaiProd1;
	private JFormattedTextField txtDelaiProd2;
	private JFormattedTextField txtDelaiConso;
	private JTextField txtStock;
	private JTextField txtRuptures;
	private JTextField txtTransactions;
	private JTextField txtMoyenne;
	private JTextField txtPenalites;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreSimulation frame = new FenetreSimulation();
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
	public FenetreSimulation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduction = new JLabel("Production 1");
		lblProduction.setBounds(34, 56, 81, 14);
		contentPane.add(lblProduction);
		
		JLabel lblQuantite = new JLabel("quantite");
		lblQuantite.setBounds(178, 22, 46, 14);
		contentPane.add(lblQuantite);
		
		JLabel lblDelaiDeProd = new JLabel("delai");
		lblDelaiDeProd.setBounds(297, 22, 81, 14);
		contentPane.add(lblDelaiDeProd);
		
		JLabel lblProduction_1 = new JLabel("Production 2");
		lblProduction_1.setBounds(34, 104, 81, 14);
		contentPane.add(lblProduction_1);
		
		JLabel lblConsommation = new JLabel("Consommation");
		lblConsommation.setBounds(34, 153, 81, 14);
		contentPane.add(lblConsommation);
		
		txtProd1 = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtProd1.setBounds(178, 53, 46, 20);
		contentPane.add(txtProd1);
		
		txtProd2 = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtProd2.setBounds(178, 101, 46, 20);
		contentPane.add(txtProd2);
		
		txtConsommation = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtConsommation.setBounds(178, 150, 46, 20);
		contentPane.add(txtConsommation);
		
		txtDelaiProd2 = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtDelaiProd2.setBounds(284, 101, 46, 20);
		contentPane.add(txtDelaiProd2);
		
		txtDelaiConso = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtDelaiConso.setBounds(284, 150, 46, 20);
		contentPane.add(txtDelaiConso);
		
		txtDelaiProd1 = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtDelaiProd1.setBounds(284, 53, 46, 20);
		contentPane.add(txtDelaiProd1);
		
		txtStock = new JTextField();
		txtStock.setBounds(27, 237, 58, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(39, 212, 46, 14);
		contentPane.add(lblStock);
		
		lblRupturesDeStock = new JLabel("Ruptures");
		lblRupturesDeStock.setBounds(107, 212, 65, 14);
		contentPane.add(lblRupturesDeStock);
		
		txtRuptures = new JTextField();
		txtRuptures.setBounds(107, 237, 65, 20);
		contentPane.add(txtRuptures);
		txtRuptures.setColumns(10);
		
		JLabel lblStockMoy = new JLabel("Stock moy.");
		lblStockMoy.setBounds(340, 212, 81, 14);
		contentPane.add(lblStockMoy);
		
		txtMoyenne = new JTextField();
		txtMoyenne.setBounds(350, 237, 86, 20);
		contentPane.add(txtMoyenne);
		txtMoyenne.setColumns(10);
		
		JLabel lblPenalites = new JLabel("Penalites");
		lblPenalites.setBounds(461, 212, 46, 14);
		contentPane.add(lblPenalites);
		
		txtPenalites = new JTextField();
		txtPenalites.setBounds(444, 237, 86, 20);
		contentPane.add(txtPenalites);
		txtPenalites.setColumns(10);
		
		btnDemarrer = new JButton("Demarrer");
		btnDemarrer.setBounds(79, 266, 89, 23);
		contentPane.add(btnDemarrer);
		
		btnArreter = new JButton("Arreter");
		btnArreter.setBounds(391, 268, 89, 23);
		contentPane.add(btnArreter);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setBounds(222, 212, 65, 14);
		contentPane.add(lblTransaction);
		
		txtTransactions = new JTextField();
		txtTransactions.setBounds(201, 237, 86, 20);
		contentPane.add(txtTransactions);
		txtTransactions.setColumns(10);
	}

	@Override
	public int getProduction1() {
		
		return parseText(txtProd1.getText());
	}

	@Override
	public int getProduction2() {
		// TODO Auto-generated method stub
		return parseText(txtProd2.getText());
	}

	@Override
	public int getConsommation() {
		// TODO Auto-generated method stub
		return parseText(txtConsommation.getText());
	}

	@Override
	public int getDelaiProd1() {
		return parseText(txtDelaiProd1.getText());
	}

	@Override
	public int getDelaiProd2() {
		return parseText(txtDelaiProd2.getText());
	}

	@Override
	public int getDelaiConso() {
		return parseText(txtDelaiConso.getText());
	}

	@Override
	protected void ajouterLigne(Reserve reserve) {
		txtStock.setText(reserve.getStock()+"");
		txtTransactions.setText(reserve.getLastChange()+"");
		txtMoyenne.setText(reserve.getMoyenneStock()+"");
		txtPenalites.setText(reserve.getPenalites()+"");
		txtRuptures.setText(reserve.getCompteur()+"");
	}
}
