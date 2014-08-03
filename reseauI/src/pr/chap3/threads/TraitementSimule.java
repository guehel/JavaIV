package pr.chap3.threads;

public class TraitementSimule extends Thread {
public void run(){
	for(int i = 0; i < 10; i++){
		System.out.println("Bonjour "+i);
	}
}
}
