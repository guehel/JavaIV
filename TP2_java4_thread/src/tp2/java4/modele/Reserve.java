package tp2.java4.modele;

import java.util.Observable;




public class Reserve extends Observable implements ActionStock {
	private final int STOCK_MIN;
	private final int PENALITE;
	private int stock;
	private int moyenneStock=0;
	private int lastChange=0;
	private int compteurRupture;
	private int compteurTransactions=0;
	public void ajoute(int quantite) {
		valideQuantite(quantite);
		
		this.lastChange = quantite;
		changeStock();
	}

	public Reserve(int stock, int minStock, int penalite) throws Exception {
		super();
		this.PENALITE = penalite;
		this.STOCK_MIN = minStock;
		this.stock = stock;
		compteurRupture = STOCK_MIN;
		calculerMoyenneStock();
	}

	public Reserve(int stock) throws Exception {
		this(stock,0,20);
	}

	private void valideQuantite(int quantite) throws RuntimeException {
		if(quantite<0) throw new RuntimeException("Quantite negatif");
	}
	public void consomme(int quantite) {
		valideQuantite(quantite);

		if(quantite > stock){
			quantite = stock;
			compteurRupture++;
		}

		this.lastChange = -quantite;
		changeStock();


	}
	
	private void changeStock(){
		compteurTransactions++;
		stock += this.lastChange;
		calculerMoyenneStock();
		setChanged();
		notifyObservers();
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCompteur() {
		return compteurRupture;
	}

	public void setCompteur(int compteur) {
		this.compteurRupture = compteur;
	}

	public double getPenalites(){
		return (compteurRupture*PENALITE);
	}
	

	public int getLastChange() {
		return lastChange;
	}

	@Override
	public void calculer(int quantite) {	
	}
	
	
	
	public int getMoyenneStock() {
		return moyenneStock;
	}

	private void calculerMoyenneStock(){
		if(compteurTransactions>0){
			moyenneStock = (moyenneStock*(compteurTransactions - 1) + stock)/compteurTransactions;
		}else moyenneStock = stock;
	}


}
