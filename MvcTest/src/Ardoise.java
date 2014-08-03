import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ardoise extends JPanel {

	public Ardoise (){
		setBackground(Color.yellow);
		setPreferredSize(new Dimension(200,150));
	}
	
	public void dessiner(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(60, 35, 80, 80);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dessiner(g);
	}
	public static void main(String[] args) {
	JFrame frame = new JFrame("Un disque");
	frame.setContentPane(new Ardoise());
	frame.setLocation(400, 300);
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
