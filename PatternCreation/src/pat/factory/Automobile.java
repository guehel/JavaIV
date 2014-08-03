package pat.factory;

public class Automobile extends Vehicule {

	@Override
	public void roule() {
		rouleAuto();

	}
	
	public void rouleAuto(){
		System.out.println("J'ai 4 roues et je roule relativement vide");
	}

}
