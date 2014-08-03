package exo.sem3.threads;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Processus2 extends Thread {
private Long timeout ;
private BufferedWriter out ;
/**
 * @param num numero du thread
 * @param timeout delai d'Attente
 * @param out flux de sortie
 */
public Processus2(int num, Long timeout, BufferedWriter out){
	super("Thread "+num);
	this.timeout = timeout;
	this.out = out;
}

/**
 * @param message message texte a sauvagarder dans le flux de sortie
 */
private synchronized void ecrire(String message){
	try {
		out.write(message);
	} catch (IOException e) {
			e.printStackTrace();
	}
}

public void run(){

	
		ecrire(this.getName()+" : création\n");
		ecrire(this.getName()+" : je suis en attente\n");
		try {
			
			sleep(timeout);
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ecrire(this.getName()+" : fin de l'Attente\n");
	
	
}

public static void main(String [] args){
	BufferedWriter out = SingleTonStream.getStream("test.txt");
	Long timeout1 = (long) 100;
	Long timeout2 = (long) 50;
	Processus2 p1 = new Processus2(1,timeout1, out );

	Processus2 p2  = new Processus2(2,timeout2, out );
	p1.start();
	p2.start();
	while(!(p1.getState()==State.TERMINATED && p2.getState()==State.TERMINATED)){}
	try{
	
		out.close();
	}catch(IOException e){}
	
}
}
