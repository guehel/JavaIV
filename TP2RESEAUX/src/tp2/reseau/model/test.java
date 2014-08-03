package tp2.reseau.model;

import java.io.File;
import java.net.UnknownHostException;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String IPMachineCliente ="192.168.2.18";
		String urlFichier = "C:\\temp\\data1.txt";
		try {
				MachineLocale m = new MachineLocale();

			m.envoyerFichier( new File(urlFichier));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
