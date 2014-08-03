import java.util.Observable;


public class Modele extends Observable{
	private String texte;

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
		this.setChanged();
		this.notifyObservers();
	}
	

}
