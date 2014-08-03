package exo.sem3.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStremFactory {
	
	public static OutputStream getStringOutputStream(){
		return new StringOutputStream(new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
							
			}
		});
	}
	
	public static FileOutputStream getFileStream(String url){
		try {
			return new FileOutputStream(new File(url));
		} catch (FileNotFoundException e) {
			return null;
		}
	}

}
