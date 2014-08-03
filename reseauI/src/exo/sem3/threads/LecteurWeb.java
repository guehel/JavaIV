package exo.sem3.threads;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LecteurWeb {
	private URL url  ;

	public LecteurWeb(URL url ){
		this.url = url;
	}
	
	public LecteurWeb(){
		this.url = null;
	}


	public  InputStream getStream() {

		try {
			return this.url.openStream();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String saveInString(byte[] buf, String text){

		for(byte b:buf){
			char l = (char)b;
			text = text+l;
			if(l=='>'){
				text = text+"\n";
			}

		}
		return text;
	}

	public String lireFlux(){
		String text = null;
		InputStream in =null;

		in = getStream();
		text = new String();
		byte[] buf= new byte[8];
		BufferedInputStream bis = new BufferedInputStream(in);
		int n = -1;
		try {
			while((n =bis.read(buf) )!=-1){
				text = saveInString( buf, text);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return  text;
	}
	
	public String lireAdresse(){
		StringOutputStream out = (StringOutputStream) OutputStremFactory.getStringOutputStream();
		redirigeFlux(out);
		if(out!=null){
			String retour = out.getString();
		try{
			out.close();
		}
		catch(IOException e){}
		return retour;
		}
		return null;
	}
	
	
	public void setUrl(URL url){
		this.url = url;
	}
	
	public void lireImage( String urllocal){
		
			
			 FileOutputStream out =  OutputStremFactory.getFileStream(urllocal);
			 if(out!=null){
			 redirigeFlux(out);
			 try{
					out.close();
					System.out.println("fichier ferme");
				}
				catch(IOException e){}
			 }
		
		
	}
	
	
	
	public void redirigeFlux(OutputStream out){


		InputStream in =null;
		in = getStream();
		byte[] buf= new byte[8];
		BufferedInputStream bis = new BufferedInputStream(in);
		int n = -1;
		try {
			while((n =bis.read(buf) )!=-1){
				out.write(buf);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		
	}
}
