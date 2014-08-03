package tp2.reseau.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReceptionFichier extends ServiceAbstrait {
	
	private ServerSocket service;
	private boolean stopService;

	public ReceptionFichier(ServerSocket service, Observateur observateur) {
		super(observateur);
		this.service = service;
	}

	@Override
	public void demarrer() {
		ExecutorService executor = Executors.newFixedThreadPool(50);
		String message = null;
		while(!stopService){
			try {
				Socket client = service.accept();
				executor.execute(new ThreadLecture(client));
				message =" fichier recu";
				
				
			} catch (IOException e) {
				message ="La tentative de reception a echoué";
			}
			finally{
				System.out.println(message);
				notify(message);
			}
					
		}
		try {
			service.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean reussie() {
		// TODO Auto-generated method stub
		return false;
	}

}
