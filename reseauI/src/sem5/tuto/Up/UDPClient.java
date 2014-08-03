package sem5.tuto.Up;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) {
		DatagramSocket socket =null;
		DatagramPacket packetAppel = null;
		DatagramPacket packetResponse = null;
		String server  = "time.nist.gov";
		 try {
			socket = new DatagramSocket(0);
			socket.setSoTimeout(20000);
			InetAddress serverAdd = InetAddress.getByName(server);
			System.out.println(serverAdd.getHostAddress());
			byte [] bufAppel= new byte[1];
			packetAppel = new DatagramPacket(bufAppel, 1, serverAdd, 13);
			byte [] bufReponse= new byte[1024];
			packetResponse = new DatagramPacket(bufReponse, bufReponse.length); 
			socket.send(packetAppel);
			socket.receive(packetResponse);
			System.out.println("envoie du packet");
			
			System.out.println(new String(packetResponse.getData(), 0,packetResponse.getLength() ));
			
		} catch (SocketException e) {
					e.printStackTrace();
		} catch (UnknownHostException e) {
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
