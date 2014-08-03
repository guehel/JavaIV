package tp2.reseau.serveur;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import tp2.reseau.model.ThreadLecture;

public class Server {
	private ServerSocket service;
	private boolean stopService;
	public Server(int port)throws IOException{
		if(port<0)throw new RuntimeException("le numero de port est negatif");
		service  = new ServerSocket(port);
		stopService = false;
		startServices();
	}
	public void startServices() {
		while(!stopService){
			try {
		
				Socket client = service.accept();
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				out.println("recu merci");
				out.flush();
				Thread reponse = new Thread(new ThreadLecture(client));
				reponse.setPriority(Thread.MAX_PRIORITY);
				reponse.start();
			} catch (IOException e) {}
					
		}
		try {
			service.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	public void StopServices(){
		stopService = true;
	}
	

}