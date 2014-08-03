package sem4.socket.Exercices;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThreadLecture extends Thread {
	
	
	private InputStream serverInputStream;
	public ThreadLecture(InputStream serverInputStream){
		this.serverInputStream = serverInputStream;
	}
	public void run(){
		readStream1(serverInputStream);
	}
	
	
	
	private void readStream1(InputStream serverInputStream){
		
		String message ="";
		try {
				
			DataInputStream in = new DataInputStream(serverInputStream);
			System.out.println("test");
			int biteRead ;
			
			while((biteRead =in.read())!=-1){
			
				message += ((char)biteRead);
						
			}
		
			System.out.println(message);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
