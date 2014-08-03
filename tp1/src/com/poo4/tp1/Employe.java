package com.poo4.tp1;

import java.io.Serializable;

public class Employe implements Serializable {
	private static final double SALAIRE_MAX = 7000;
	private static final double SALAIRE_MIN = 0;
	private int numero;
	private double salaire;
	private String nom;
	public Employe(int numero, double salaire, String nom) {

		this();
		if(valideNumero(numero))
			this.numero = numero;
		if(valideSalaire(salaire))
			this.salaire = salaire;
		if(valideNom(nom))
			this.nom = nom;
	}
	public Employe() {
		this.numero=0;
		this.salaire= SALAIRE_MIN;
		this.nom="";
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if(valideNumero(numero))
			this.numero = numero;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		if(valideSalaire(salaire))
		this.salaire = salaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if(valideNom(nom))
		this.nom = nom;
	}

	private boolean valideNumero(int num){
		return num >0;
	}

	private boolean valideSalaire(double salaire){
		return salaire >= SALAIRE_MIN && salaire <= SALAIRE_MAX;	
	}

	private boolean valideNom(String nom){
		return nom !=null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
	
		Employe other = (Employe) obj;
		if (numero != other.getNumero())
			return false;
		return true;
	}


}
