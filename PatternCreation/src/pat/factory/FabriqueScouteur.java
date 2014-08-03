package pat.factory;

public class FabriqueScouteur extends FactoryVehicule {

	@Override
	public Vehicule getInstanceVehicule() {
		
		return getInstanceScouteur();
	}
	public scouteur getInstanceScouteur(){
		return new scouteur();
	}

}
