package pat.factory;

public class FabriqueVehicule {
	
	public Vehicule getAutoinstance(){
		return new Automobile();
	}
	public Vehicule getAutoiScouteure(){
		return new scouteur();
	}

}
