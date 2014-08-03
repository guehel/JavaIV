package tp2.reseau.serveur;

import java.io.IOException;

public class ServerRunnable implements Runnable {
	private Server server;
	
	public ServerRunnable(Server server ) {
		super();
		this.server = server;
	}

	public void run() {
	
			server.startServices();
			System.out.println("service demarré");
		
	}

	
	public static void main(String[] args) throws IOException {
		int port = 55555;
		Server serveur = new Server(port);
		Runnable tacheServer = new ServerRunnable(serveur);
		Thread serverThread = new Thread(tacheServer);
		serverThread.start();
		System.out.println("demarré");}
}
