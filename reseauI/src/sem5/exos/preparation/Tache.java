package sem5.exos.preparation;

import java.net.Socket;
import java.util.ArrayList;

public abstract class Tache  implements Observable  {
	protected ArrayList<Observateur> observateurs;
	public void notifer(Socket socket) {
	
		for(Observateur observateur: observateurs )
			observateur.metAJour(socket);
		
	}
}
