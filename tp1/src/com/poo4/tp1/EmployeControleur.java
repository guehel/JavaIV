package com.poo4.tp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EmployeControleur {
	private EmployeModele modele;
	private AbsEmployeVue vue;
	
	public EmployeControleur(){
		try {
			modele = new EmployeModele();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vue = new AbsEmployeVue();
		modele.addObserver(vue);
		initVue();
		vue.setVisible(true);
	}

	private void initVue() {
		vue.getBtnQuitter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
					
			}
		});
		
		vue.getBtnEnregistrer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numero;
				String nom;
				double salaire;
				try{
					numero = Integer.parseInt(vue.getTxtNumero().getText());
					salaire = Double.parseDouble(vue.getTxtSalaire().getText());
					nom = vue.getTxtNom().getText().trim();
					modele.enregistrerEmploye(new Employe(numero, salaire, nom));
				}
				catch(NumberFormatException exp){
					modele.enregistrerEmploye(null);
				}
				
				
			}
		});
		
		vue.getBtnRechercher().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numero;
				Employe emp = new Employe();
				try{
					numero = Integer.parseInt(vue.getTxtNumero().getText());
					emp.setNumero(numero);
					modele.trouverEmpoye(emp);
				}
				catch(NumberFormatException exp){
					modele.trouverEmpoye(null);
				}
				
			}
		});
	}
	

}
