package poo.session3.tp1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class daoEmploye {
	private File fichier ;
	public daoEmploye(String url){
		fichier = new File(url);
	}
	public Object getObject(){
		Object o = null;
		ObjectInputStream in = null ;
		try {
			//ouvre le flux si le fichier n'Est pas vide
			if(fichier.exists()&& (fichier.length()!=0)){
					in = new ObjectInputStream(new FileInputStream(fichier));
					o = in.readObject();
							
			}
			//autrement creer un nouveau vichier
			else{
				fichier.createNewFile();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//ferme le flux en toute circonstance
		finally{
			if (in!=null){
			try{in.close();}catch(IOException ex){}
			}
		}
		return o;
	}
	public void saveObject(Object obj){
		
		ObjectOutputStream out = null ;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fichier));
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out!=null){
			try{out.close();}catch(IOException ex){}
			}
		}
		
	}
	

}
