package sem5.exos.preparation;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Serveur extends MachineAbstrait{
	private ServerSocket serverSocket;
	private ArrayList<Socket> clientsSockets;
	private int numPort;
	private void redistribuer(String message){
		Runnable runnable = null;
		for(Socket socket : clientsSockets){
			runnable = FactoryRunnable.getTache(socket, message);
			this.executor.execute(runnable);
			
		}
	}
	
	@Override
	public void ecoute() {
		Runnable runnable = FactoryRunnable.getTache(serverSocket);
		this.executor.execute(runnable);

	}
	@Override
	public void emettre(String message) {
		// TODO Auto-generated method stub

	}
}
