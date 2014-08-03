package pat.factory;

public class scouteur extends Vehicule {

	@Override
	public void roule() {
		rouleScouteur();
	}
	
	public void rouleScouteur(){
		System.out.println("j'ai 2 roues et je roule lentement en generale");
	}

}
