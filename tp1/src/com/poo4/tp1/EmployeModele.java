package com.poo4.tp1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;

public class EmployeModele extends Observable {
	
	private EmployeDAO acces;
	private String message;
	private Employe employe;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	public EmployeModele() throws FileNotFoundException, IOException{
		out = new ObjectOutputStream(new FileOutputStream(new File("employes.txt"), true));
		in = new ObjectInputStream(new FileInputStream(new File("employes.txt")));
		acces = new EmployeDAO();
		message = "";
		employe = new Employe();
	}
	
	
	public String getMessage() {
		return message;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void enregistrerEmploye(Employe employe){
		this.employe = new Employe();
		if(employe!=null){
		acces.enregistrer(employe,out );
		this.message = "Employe "+employe.getNumero()+" enregistre";
		}else{
			this.message = "Employe pas enregistre";	
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void trouverEmpoye(Employe employe){
		this.employe = acces.trouver(employe, in);
		message = this.employe==null|| employe==null?"l'employe n'existe pas":"Employe trouvé";
		this.setChanged();
		this.notifyObservers();
		
	}

}
