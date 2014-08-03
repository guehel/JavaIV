package tp2.java4.modele;






public  class Processus extends Thread   {
	private int quantite;
	private int delai;
	private ActionStock reserve;
	private boolean continuer=true;
	public Processus(int quantite, int delai, ActionStock reserve) {
		super();
		valideQuantite(quantite);
		this.quantite = quantite;
		this.delai = delai;
		this.reserve = reserve;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		valideQuantite(quantite);
		this.quantite = quantite;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}
	public Reserve getReserve() {
		return (Reserve) reserve;
	}
	public void setReserve(Action reserve) {
		this.reserve = reserve;
	}
	
	private void valideQuantite(int quantite) throws RuntimeException {
		if(quantite<0) throw new RuntimeException("Quantite negatif");
	}
	public void arreter(){
		this.continuer = false;
	}
	public void run(){
		while(continuer){
			reserve.calculer(quantite);
			try {
				sleep(delai);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
