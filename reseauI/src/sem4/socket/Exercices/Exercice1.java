package sem4.socket.Exercices;

import java.io.IOException;

public class Exercice1 {
	public static void main(String [] args){

		
		Thread threadClient  = new Thread(){
			String adresse = "10.209.16.102";
			int port = 9999;
			
			public void run(){
				Client client=null;
				try {
					client = new Client(adresse, port);
					client.communiquer("salut toi mon beau ");
					System.out.println("la connection a pu etre etablie");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};

		threadClient.start();
	
	
	}

}
