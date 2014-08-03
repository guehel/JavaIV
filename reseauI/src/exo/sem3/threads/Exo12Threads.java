package exo.sem3.threads;

public class Exo12Threads {
	
	public static void main(String [] args){
		Thread thread1 = new Thread("Thread #1: "){
			long timeout = 100;
			public void run(){
				System.out.println(this.getName()+"création");
				try {
					System.out.println(this.getName()+"je suis en attente");
					sleep(timeout);
					System.out.println(this.getName()+"fin de l'Attente");
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
	
		Thread thread2 = new Thread("Thread #2: "){
			long timeout = 50;
			public void run(){
				System.out.println(this.getName()+"création");
				try {
					System.out.println(this.getName()+"je suis en attente");
					sleep(timeout);
					System.out.println(this.getName()+"fin de l'Attente");
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
	}
	

}
