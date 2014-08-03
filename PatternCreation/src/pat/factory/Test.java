package pat.factory;

import java.util.Scanner;

public class Test {
	public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	FactoryVehicule fabrique=null;
	Vehicule monVehicule;
	
	
	int choix = - 1 ;
	do{
		System.out.println("quel type de vehicule voulez vous");
		choix = sc.nextInt();
	}while(choix !=1 && choix !=2 && choix !=3);
	
	switch(choix){
	case 1:
		fabrique = new FabriqueAutomobile();
		break;
		
	case 2:
		fabrique = new FabriqueScouteur();
		break;
	case 3:
		fabrique = new FabriqueAvion();
		break;
	default:
		break;
		
	}
	monVehicule = fabrique.getInstanceVehicule();
	monVehicule.roule();
	
	}

}
