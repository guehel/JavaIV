package sem5.NIOSelector.exercices.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import sem5.NIOSelector.exercices.Observer;

public class vueExoNIO extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField txtMessage;
	private JComboBox cbGroupe;
	private JButton btnRejoindre;
	private JTextArea textArea;
	private JButton btnEnvoyer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueExoNIO frame = new vueExoNIO();
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
	public vueExoNIO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 518);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGroupeDeDiffusion = new JLabel("Groupe de diffusion");
		panel.add(lblGroupeDeDiffusion);
		
		cbGroupe = new JComboBox();
		cbGroupe.setModel(new DefaultComboBoxModel(new String[] {"Mondial 2014", "Le retour aux etudes", "Les vacances"}));
		panel.add(cbGroupe);
		
		btnRejoindre = new JButton("rejoindre");
		panel.add(btnRejoindre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(100, 30));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 337, 341);
		panel_1.add(textArea);
		
		JLabel lblMessage = new JLabel("message");
		lblMessage.setBounds(10, 363, 81, 14);
		panel_1.add(lblMessage);
		
		txtMessage = new JTextField();
		txtMessage.setBounds(101, 363, 224, 20);
		panel_1.add(txtMessage);
		txtMessage.setCaretColor(Color.BLUE);
		txtMessage.setToolTipText("Saisissez votre texte");
		txtMessage.setColumns(35);
		
		btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(252, 402, 73, 23);
		panel_1.add(btnEnvoyer);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
	}

	public JTextField getTxtMessage() {
		return txtMessage;
	}

	public JComboBox getCbGroupe() {
		return cbGroupe;
	}

	public JButton getBtnRejoindre() {
		return btnRejoindre;
	}

	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}

	@Override
	public void update(String message) {
		String mess = textArea.getText()+"\nEnvoie: "+message;
		this.textArea.setText(mess);
	}

	@Override
	public void update(byte[] message) {
				
	}
}
