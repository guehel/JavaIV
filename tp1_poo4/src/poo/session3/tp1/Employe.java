package poo.session3.tp1;

import java.io.Serializable;

public class Employe implements Serializable{
	public  static final float SALAIRE_MIN =1000;
	public  static final float SALAIRE_MAX = 7000;
	private int numero;
	private float salaire=0f;
	private String nom;
	
	public Employe(int numero, float salaire, String nom) {
		super();
		this.numero = numero;
		this.salaire = salaire;
		this.nom = nom;
	}
	public Employe() {
		this.numero = 0;
		this.salaire = SALAIRE_MIN;
		this.nom = "";
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean validerNumero(int numero) {
		return this.numero>0;
	}
	
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public boolean validerSalaire(float salaire) {
		return this.salaire >=SALAIRE_MIN && this.salaire <=SALAIRE_MAX;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
		
		
		if (obj != null){
			Employe other = (Employe) obj;
			return numero == other.getNumero();
		}
			return false;
		
	}
	
	

}
