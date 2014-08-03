package sem5.NIOSelector.exercices;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class EnvoieDatagramPacket extends RunnableDatagramAbstrait {
	
	
	public EnvoieDatagramPacket(MulticastSocket pSocket, InetAddress inetclients, int port,   String message ) {
		super(pSocket, message.getBytes().length);
		int messageSize = message.getBytes().length;
		this.datagramPacket = new DatagramPacket(buffer, messageSize, inetclients, port);
		this.datagramPacket.setData(message.getBytes(), 0, messageSize);
		
	}

	@Override
	public void run() {
	
		
		try {
			socket.send(datagramPacket);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

}
