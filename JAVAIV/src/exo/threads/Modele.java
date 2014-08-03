package exo.threads;

import java.util.Observable;

public class Modele extends Observable{
	private int nombre = 0;
	private int duree;
	private boolean arrete;
	public Modele(int dureEnCentieme){
		duree = 10*dureEnCentieme;
		arrete = false;
	} 
	
	public void demarrer(){
		new Thread(){ public void run(){
				while(!arrete){
					try {
						Thread.currentThread().sleep(999);
						nombre++;
						System.out.println(nombre);
						notifier();
					} catch (InterruptedException e) {
						
					}
				}
		}}.start();
		
	
	}
	private void notifier() {
		this.setChanged();
		notifyObservers();
		
	}
	
	public void onOff(){
		arrete = !arrete;
		demarrer();
	}

	public void reset(){
		nombre = 0;
		arrete = true;
		demarrer();
		
	}

	public int getNombre() {
		return nombre;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setArrete(boolean arrete) {
		this.arrete = arrete;
	}


	public static void main(String [] args){
		Modele model = new Modele(500);
		model.demarrer();
	}

}
