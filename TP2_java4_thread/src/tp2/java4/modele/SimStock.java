package tp2.java4.modele;
import java.util.ArrayList;
import java.util.Observable;

import tp2.java4.persistance.Enregistreur;





public class SimStock extends Observable {
	private Reserve reserve;
	private Enregistreur enregistreur;
	private static final double TAUX_PENALITE = 20;
	private ArrayList<Processus> listeThreads;
	
	public SimStock(Reserve reserve){
		this.reserve = reserve;
		listeThreads = new ArrayList<Processus>(3);
		this.enregistreur = new Enregistreur();
		this.reserve.addObserver(enregistreur);
	}
	
	
	
	public void addProcessus(Processus processus){
		this.listeThreads.add(processus);
	}
	
	public void startProcessus() {
		for(Processus p: listeThreads) p.start();
		
	}
	
	public void stopProcessus() {
		for(Processus p: listeThreads) p.arreter();
		
	}

	
}
