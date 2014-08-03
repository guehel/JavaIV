package sem5.exos.preparation;

import java.net.ServerSocket;
import java.net.Socket;

public class FactoryRunnable {

	public static Runnable getTache(ServerSocket serverSocket) {
		Runnable tacheEcoute = new TacheEcoute(serverSocket);
		return tacheEcoute;
	}

	public static Runnable getTache(Socket socket, String message) {
		Runnable tacheEcoute = new TacheEmission(socket, message);
		return tacheEcoute;
	}

}
