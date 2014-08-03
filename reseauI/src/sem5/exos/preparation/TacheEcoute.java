package sem5.exos.preparation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TacheEcoute implements Runnable, Observable {
	private ServerSocket serverSocket;
	public TacheEcoute(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		Socket socket = null;
		while(true){
			try {
				 socket = serverSocket.accept();
				this.notifer(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void notifer(Socket socket) {
		// TODO Auto-generated method stub
		
	}

	

	

}
