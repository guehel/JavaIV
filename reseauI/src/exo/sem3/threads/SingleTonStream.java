package exo.sem3.threads;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class SingleTonStream {

	private static BufferedWriter out = null;
	
	public static BufferedWriter getStream(String url){
		
		File fichier = new File(url);
		if(out==null){
			try {
				out = new BufferedWriter(new FileWriter(fichier));
				return out;
			} catch ( IOException e) {
			
				e.printStackTrace();
			}
		}
			return out;
	}
}
