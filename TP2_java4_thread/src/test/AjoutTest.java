package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.java4.modele.Action;
import tp2.java4.modele.ActionStock;
import tp2.java4.modele.Ajout;
import tp2.java4.modele.Consommation;
import tp2.java4.modele.Reserve;

public class AjoutTest {

	@Test
	public void test() {
	 try {
		Reserve reserve = new Reserve(500);
		ActionStock action = new Ajout(reserve);
		action.calculer(200);
		System.out.println(reserve.getStock());
		assertTrue(reserve.getStock()==700);
		 action = new Consommation(reserve);
		action.calculer(200);
		System.out.println(reserve.getStock());
		assertTrue(reserve.getStock()==500);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
