package exo.sem3.threads;

public class Processus extends Thread {
private Long timeout ;
public Processus(int num, Long timeout){
	super("Thread "+num);
	this.timeout = timeout;
}
public void run(){
	System.out.println(this.getName()+" : création");
	System.out.println(this.getName()+" : je suis en attente");
	
	try {
	
		sleep(timeout);
	
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println(this.getName()+" : fin de l'Attente");
}

public static void main(String [] args){
	Long timeout1 = (long) 100;
	Long timeout2 = (long) 50;
	new Processus(1,timeout1 ).start();
	new Processus(2,timeout2 ).start();
	
}
}
