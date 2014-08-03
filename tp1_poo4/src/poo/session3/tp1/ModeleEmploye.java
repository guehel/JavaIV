package poo.session3.tp1;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;

public class ModeleEmploye extends Observable{
	private Map<Integer, Employe> listeEmploye ;
	private Employe employe;
	private daoEmploye memoire;
	private String message;
	@SuppressWarnings("unchecked")
	public ModeleEmploye(){
		memoire = new daoEmploye("employe.txt");
		this.listeEmploye = ( Map<Integer, Employe> )memoire.getObject();
		if(this.listeEmploye==null){
			this.listeEmploye = new LinkedHashMap<>();
		}
	}
	public void ajouter(Employe employe) {
		Employe emp=null;
		if(employe!=null){
			emp=listeEmploye.put(employe.getNumero(), employe);
		}
		//si le numero d'employe existe deja
		if( emp==null){
			this.employe = new Employe();
			this.message = "Employe\nnumero: "+employe.getNumero()
					+ "\nnom: "+employe.getNom()
					+"\nEnregistree";
		}else {
			this.employe = employe;
			
			this.message = "Employe\nnumero: "+employe.getNumero()
					+ "\nnom: "+emp.getNom()+"\nExiste deja";
			emp=listeEmploye.put(emp.getNumero(), emp);
		}
		notifier();
		
	}
	
	private void notifier() {
		this.setChanged();
		this.notifyObservers();
		
	}
	public void rechercher(Employe employe){
		this.employe = listeEmploye.get(new Integer(employe.getNumero()));
		if(this.employe==null){
			this.employe =employe;
			this.message = "Employe\nnumero: "+employe.getNumero()
					+" n'existe pas";
		}else {
			this.message = "Employe trouvé\nnumero: "+this.employe.getNumero()
					+ "\nnom: "+this.employe.getNom()+"\nSalaire:"+this.employe.getSalaire();
		}
		notifier();
	}
	
	
	public String [] getKey(){
		Object [] cles = listeEmploye.keySet().toArray();
		String [] listeCles = new String [cles.length];
	
		for(int i=0; i<cles.length; i++){
			listeCles[i]= ((Integer)cles[i]).toString();
		}
		Arrays.sort(listeCles);
		return listeCles;
	}
	public void finalize(){
		memoire.saveObject(listeEmploye);
	}
	public Employe getEmploye() {
		// TODO Auto-generated method stub
		return employe;
	}
	public String getMessage() {
		return message;
	}
	public void start() {
		this.employe = new Employe();
		message="";
		notifier();
		
	}
	
	

}
