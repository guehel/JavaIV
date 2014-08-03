package sem5.NIOSelector.exercices;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;


public class FactoryRunnables {	
	 
	public static Runnable getReception(MulticastSocket socket, Observer observer){
		int bufferSize = 50;
		Runnable ecoute = new ReceptionDatagramPacket(socket, bufferSize, observer);
		return ecoute;
	}

	public static Runnable getDiffusion(MulticastSocket socket, String ipDiffusion,  String message , int port) {
		 InetAddress inteDiffusion = null;
		 try {
			inteDiffusion = InetAddress.getByName(ipDiffusion);
			return new EnvoieDatagramPacket(socket, inteDiffusion, port, message);
		} catch (UnknownHostException e) {
				e.printStackTrace();
		}
		return null;
	}

}
