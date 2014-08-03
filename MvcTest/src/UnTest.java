import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class UnTest extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblResultat;
	private JButton btnEntrerText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnTest frame = new UnTest();
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
	public UnTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	 lblResultat = new JLabel("Resultat");
		lblResultat.setBounds(33, 11, 46, 14);
		contentPane.add(lblResultat);
		
		textField = new JTextField();
		textField.setBounds(33, 93, 210, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	 btnEntrerText = new JButton("entrer text");
		btnEntrerText.setBounds(33, 180, 89, 23);
		contentPane.add(btnEntrerText);
	}

	
	public JButton getBtnEntrerText() {
		return btnEntrerText;
	}

	public String getTexte() {
		// TODO Auto-generated method stub
		return textField.getText();
	}

	public JTextField getTextField() {
		return textField;
	}

	@Override
	public void update(Observable o, Object arg) {
		String texte = ((Modele)o).getTexte();
		lblResultat.setText(texte);
	}
}
