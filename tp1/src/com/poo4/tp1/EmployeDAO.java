package com.poo4.tp1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;

public class EmployeDAO extends Observable{

public EmployeDAO(){
	
}
public void enregistrer(Employe employe, ObjectOutputStream out){
	
	if(employe!=null){

	try{
		
		out.writeObject(employe);
		out.flush();
	}
	catch(FileNotFoundException e){} 
	catch (IOException e) {
	e.printStackTrace();
	}finally{	
		if(out!=null){
			try {
				out.close();
			} catch (IOException e) {}
		}
	}
	}
}
public Employe trouver(Employe employe, ObjectInputStream in){
	Employe emp= null;
	if(employe!=null){
	
	
	try{
		
		do{
			emp = (Employe) in.readObject();
		
			if(employe.equals(emp))
				break;
			
		}while (emp!=null );
	}
	catch(EOFException e){
		e.printStackTrace();
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}finally{	
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {}
		}
	}
	}
	return emp;
	
}
}
