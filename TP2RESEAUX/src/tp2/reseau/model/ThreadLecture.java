package tp2.reseau.model;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ThreadLecture implements Runnable {
	private InputStream serverInputStream=null;
	private final String urlRecu ="C:\\temp\\tp2.txt";
	private File fichier;
	public ThreadLecture(Socket clientSocket){
	
		try {
			this.serverInputStream = clientSocket.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		if (serverInputStream!=null){
			this.fichier = new File(urlRecu);
			sauverFichier(fichier);
		}
	}

	private void sauverFichier(File fichier2) {
		BufferedOutputStream bos=null; 
		BufferedInputStream bis=null;
	try {
		FileOutputStream fos = new FileOutputStream(fichier);
		bos = new BufferedOutputStream(fos);
		 bis = new BufferedInputStream(serverInputStream);
		byte[] buf= new byte [100]; 
		@SuppressWarnings("unused")
		int n;
		while((n=bis.read(buf))!=-1){
			for(byte b: buf)
				System.out.println((char)b);
			fos.write(buf);
		}
	
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	finally{
		try {
			if (bos!=null)	bos.close();
			if (bis!=null)	bis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
	}
	

}
