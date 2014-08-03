package pat.factory;

public class FabriqueAvion extends FactoryVehicule {

	@Override
	public Vehicule getInstanceVehicule() {
		// TODO Auto-generated method stub
		return  getInstanceAvion();
	}
	
	private Avion getInstanceAvion(){
		return new Avion();
	}

}
