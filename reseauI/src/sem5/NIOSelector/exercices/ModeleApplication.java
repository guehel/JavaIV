package sem5.NIOSelector.exercices;


import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ModeleApplication extends AbstractObsevable implements Observer{
	
	private ExecutorService executor;
	private MulticastSocket socket=null;
	private String adresseDiffusion = null;
	private int port;	
	public ModeleApplication(int port) throws IOException{
		socket = new MulticastSocket(port);
		this.port = port;
		executor = Executors.newFixedThreadPool(2);
	}
	public void rejoindreGroupe(String ipGroupe){
			
		try {
			InetAddress newInetAddresse = InetAddress.getByName(ipGroupe);
			
			if(adresseDiffusion==null ){
				adresseDiffusion = ipGroupe;
			socket.joinGroup(newInetAddresse);
			}else if(!adresseDiffusion.equals(ipGroupe)){
				socket.leaveGroup(InetAddress.getByName(adresseDiffusion));
				adresseDiffusion = ipGroupe;
				socket.joinGroup(newInetAddresse);
			}
//			ecouter();
			notify("Bienvenu/e dans le groupe "+ipGroupe+"\n");
			}catch(IOException e){}
			
	}
	
	public void ecouter(){
		
		Runnable ecoute = FactoryRunnables.getReception(socket, this);
		if(ecoute!=null) executor.execute(ecoute);
		else notify("La reception est impossible"); 
	}
	
	public void diffuser(String message){
		Runnable envoie = FactoryRunnables.getDiffusion(socket, this.adresseDiffusion, message, port);
		executor.execute(envoie);
	}
	
	@Override
	public void update(String message) {
		System.out.println(message);
		
	}
	
	public static void main(String [] args){
		String ipGroupe  = "224.2.2.1";
		ModeleApplication modele;
		try {
			modele = new ModeleApplication(5555);
			modele.rejoindreGroupe(ipGroupe);
			modele.diffuser(ipGroupe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	@Override
	public void update(byte[] message) {
		String messageRecu = new String (message, 0, message.length);
		notify(messageRecu);
		
	}
	
}
