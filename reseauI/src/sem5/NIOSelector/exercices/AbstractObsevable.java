package sem5.NIOSelector.exercices;



public abstract class AbstractObsevable implements Observable{
	private Observer observateur;
	public void addObserver(Observer observateur) {
		this.observateur = observateur;
	}
	public void notify(String message) {
		observateur.update(message);
	}
	
	public void notify(byte [] message) {
		observateur.update(message);
	}

}
