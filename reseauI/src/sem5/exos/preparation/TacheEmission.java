package sem5.exos.preparation;

import java.net.Socket;

public class TacheEmission implements Runnable {
	private Socket socket;
	private byte[] contenuMessage;
	public TacheEmission(Socket socketClient, String message) {
		this.socket = socketClient;
		contenuMessage = message.getBytes();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
