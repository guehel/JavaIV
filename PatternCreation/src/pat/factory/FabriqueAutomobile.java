package pat.factory;

public class FabriqueAutomobile extends FactoryVehicule {

	@Override
	public Vehicule getInstanceVehicule() {
		
		return getInstanceAutomobile();
	}
	
	private Automobile getInstanceAutomobile(){
		return new Automobile();
	}

}
