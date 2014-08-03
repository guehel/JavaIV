package sem4.socket.Exercices;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServiceClient extends Thread {
	private Socket client;

	public ServiceClient(Socket client) {
		super();
		this.client = client;

	}
	
	public void run(){
		
		readStream1();

	}
	
	
	private void readStream1(){
		System.out.println("test");
		String message ="";
		try {
		DataInputStream in = new DataInputStream(client.getInputStream());
		int biteRead = in.read();
		while((biteRead)!=-1){
			message += ((char)biteRead);
			biteRead = in.read();
		}
		client.close();
		System.out.println(message);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
