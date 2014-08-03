package exo.sem3.threads;

import java.net.MalformedURLException;
import java.net.URL;

public class Exercice4 {

	public static void main(String[] args) {
	try {
		URL url = new URL( "http://www.google.ca");
		LecteurWeb lect = new  LecteurWeb(url);
//		String contenu = lect.lireFlux();
		String contenu = lect.lireAdresse();
		System.out.println(contenu);
		
		url = new URL("http://cdn.rsvlts.com/wp-content/uploads/2014/01/Emily-Ratajkowski-GQ-GIF-01.gif");
		lect.setUrl(url);
		lect.lireImage("image.jpg");
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}

	}

}
