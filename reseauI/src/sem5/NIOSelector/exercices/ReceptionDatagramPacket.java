package sem5.NIOSelector.exercices;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class ReceptionDatagramPacket extends RunnableDatagramAbstrait {

	
	public ReceptionDatagramPacket(MulticastSocket pSocket, int bufferSize, Observer observateur) {
		super(pSocket, bufferSize);
		
		this.datagramPacket = new DatagramPacket(buffer, bufferSize);
		this.addObserver(observateur);
	}
	

	@Override
	public void run() {
	while(true){
		try {
			System.out.println("new reception");
			socket.receive(datagramPacket);
			notify(datagramPacket.getData());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}


	

}
