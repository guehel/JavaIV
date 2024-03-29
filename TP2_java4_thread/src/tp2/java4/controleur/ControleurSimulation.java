package tp2.java4.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tp2.java4.modele.ActionStock;
import tp2.java4.modele.Ajout;
import tp2.java4.modele.Consommation;
import tp2.java4.modele.Processus;
import tp2.java4.modele.Reserve;
import tp2.java4.modele.SimStock;
import tp2.java4.vue.FenetreSimulation;
import tp2.java4.vue.VueStock;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ControleurSimulation.java
//  @ Date : 2014-06-02
//  @ Author : 
//
//




public class ControleurSimulation implements ActionListener{
	
	private VueStock vue;
	private SimStock simulateur;
	public ControleurSimulation(){
		vue  = new FenetreSimulation();
		
		vue.getBtnArreter().addActionListener(this);
		vue.getBtnDemarrer().addActionListener(this);
		vue.setVisible(true);
	
	}
	private void setParameters(){
		Reserve reserve=null ;
		try {
			reserve  = new Reserve(500);
			
		} catch (Exception e) {	
		}
		reserve.addObserver(vue);
		simulateur = new SimStock(reserve);
		ActionStock ajout1 = new Ajout(reserve);
		ActionStock ajout2 = new Ajout(reserve);
		ActionStock consommation = new Consommation(reserve);
		Processus processus1 = new Processus(vue.getProduction1(), vue.getDelaiProd1(), ajout1);
		Processus processus2 = new Processus(vue.getProduction2(), vue.getDelaiProd2(), ajout2);
		Processus processus3 = new Processus(vue.getConsommation(), vue.getDelaiConso(), consommation);
		simulateur.addProcessus(processus1);
		simulateur.addProcessus(processus2);
		simulateur.addProcessus(processus3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vue.getBtnDemarrer())){
			 setParameters();
			simulateur.startProcessus();
		}else if(e.getSource().equals(vue.getBtnArreter())){
			simulateur.stopProcessus();
		}
		
	}
	
}
