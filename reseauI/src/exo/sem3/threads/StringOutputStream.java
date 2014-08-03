package exo.sem3.threads;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StringOutputStream extends BufferedOutputStream {
	private StringBuilder stringBuilder ;
	public StringOutputStream(OutputStream arg0) {
		super(arg0);
		stringBuilder = new StringBuilder();
	}
	
	@Override
	public void write(byte[] buf)
	           throws IOException{
		for(byte b:buf){
			stringBuilder.append((char)b);
		}
		
	}
	
	 public String getString() {
		    return stringBuilder.toString();
		  }

}
