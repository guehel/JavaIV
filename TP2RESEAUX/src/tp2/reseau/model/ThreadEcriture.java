package tp2.reseau.model;


import java.io.OutputStream;
import java.io.PrintWriter;

public class ThreadEcriture implements Runnable {
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
