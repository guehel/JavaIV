package tp2.java4.vue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import tp2.java4.modele.Reserve;
import tp2.java4.modele.SimStock;


public abstract class VueStock extends JFrame implements Observer {
	protected int production1;
	protected int production2;
	protected int consommation;
	protected int delaiProd1;
	protected int delaiPod2;
	protected int delaiConso;
	
	protected JButton btnDemarrer;
	protected JButton btnArreter;
	
	protected int parseText(String texte) {
		int e=0;
//			e = Integer.parseInt(texte.trim()) ; 
		NumberFormat n = NumberFormat.getInstance();
		try {
			e = ((Long)n.parse(texte.trim())).intValue();
		} catch (ParseException e1) {
			
		}
		return e;
	}
	public JButton getBtnDemarrer() {
		return btnDemarrer;
	}
	public JButton getBtnArreter() {
		return btnArreter;
	}
	public abstract int getProduction1() ;
	public abstract int getProduction2() ;
	public abstract int getConsommation() ;
	public abstract int getDelaiProd1() ;
	public abstract int getDelaiProd2() ;	
	public abstract int getDelaiConso() ;
	public VueStock(){
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
			Reserve reserve=null;
			reserve = (Reserve)arg0;
			ajouterLigne(reserve);
			
		
	}
	protected  abstract void ajouterLigne(Reserve reserve);
}
	
