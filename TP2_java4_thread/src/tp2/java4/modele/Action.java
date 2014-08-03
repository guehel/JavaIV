package tp2.java4.modele;

public abstract class Action implements ActionStock {
	protected Reserve reserve;
	public Action(Reserve reserve) {
		super();
		this.reserve = reserve;
	}
	
	public int getStock(){
		return reserve.getStock();
	}
	public int getCompteur(){
		return reserve.getCompteur();
	}
	
	public double getPenalites(){
		return reserve.getPenalites();
	}

}
