package sem4.socket.Exercices;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class Client {

	private Socket server;
	public Client(String host, int port) throws IOException{
		server = new Socket(host, port);

	}

	public void communiquer2(String message){
		//		envoyerMessage(message);
		readStream1();
		try {
			PrintWriter out =  new PrintWriter(server.getOutputStream(), true);
			out.println(message);
			String messages ="";
			InputStream lect = server.getInputStream();
			DataInputStream in = new DataInputStream(lect);
			int biteRead = in.read();
			while((biteRead)!=-1){
				messages += ((char)biteRead);
				biteRead = in.read();
			}

			System.out.println(messages);

			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//		readStream3(message);
	}

	public void communiquer(String message){
		envoyerMessage(message);
		readStream2();
		System.out.println("test co");
//		try {
//			server.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		//		readStream3(message);
	}
	
	public void communiquer3(String message){
		OutputStream serverOutputStream;
		InputStream serverInputStream;
		try {
			serverOutputStream = server.getOutputStream();
			serverInputStream = server.getInputStream();
			Thread threadEcriture = new ThreadEcriture(serverOutputStream , message);
			Thread threadLecture = new ThreadLecture(serverInputStream);
			threadEcriture.start();
//			threadLecture.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void envoyerMessage(String message) {
		try {
			PrintWriter out =  new PrintWriter(server.getOutputStream(), true);
			out.println(message);
			out.flush();
			//			 out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void readStream1(){
		
		String message ="";
		try {
			InputStream lect = server.getInputStream();
			
			DataInputStream in = new DataInputStream(lect);
			System.out.println("test");
			
			int biteRead = in.read();
			
			while((biteRead)!=-1){
			
				message += ((char)biteRead);
				biteRead = in.read();
			
			}
		

			System.out.println(message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void readStream2(){
		//		System.out.println("test");
		//		String message ="";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String ligne ;
			while (!reader.ready()){
				
			}
			while((ligne=reader.readLine())!=null){
				System.out.println(ligne);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readStream3(String message) {

		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader( server.getInputStream()));
			writer.write(message);
			writer.flush();
			String ligne;
			while((ligne = reader.readLine()) != null) { 
				System.out.println("Recu : " + ligne); 
			} 
			writer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
