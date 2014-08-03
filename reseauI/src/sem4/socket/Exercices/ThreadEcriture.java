package sem4.socket.Exercices;


import java.io.OutputStream;
import java.io.PrintWriter;

public class ThreadEcriture extends Thread {
	private OutputStream serverInputStream;
	private String message ="";
	public ThreadEcriture(OutputStream serverInputStream, String message){
		this.message = message;
		this.serverInputStream = serverInputStream;
	}
	public void run(){
		envoyerMessage(message);
	}

	private void envoyerMessage(String message) {
		PrintWriter out =  new PrintWriter(serverInputStream, true);
		out.println(message);
//		out.flush();
		//			 out.close();

	}

}
