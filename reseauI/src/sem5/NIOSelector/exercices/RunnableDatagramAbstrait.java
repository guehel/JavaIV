package sem5.NIOSelector.exercices;

import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class RunnableDatagramAbstrait  extends AbstractObsevable implements Runnable{
	protected  ExecutorService executeur = Executors.newFixedThreadPool(100);
	protected MulticastSocket socket;
	protected byte [] buffer;
	protected DatagramPacket datagramPacket; 
	
	public RunnableDatagramAbstrait(MulticastSocket pSocket, int bufferSize) {
		socket = pSocket;
		buffer = new byte [bufferSize]; 
		datagramPacket = null;
		
	}

	public void setSocket(MulticastSocket socket) {
		this.socket = socket;
	}
	
}
