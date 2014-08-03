package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.java4.modele.Action;
import tp2.java4.modele.ActionStock;
import tp2.java4.modele.Ajout;
import tp2.java4.modele.Consommation;
import tp2.java4.modele.Processus;
import tp2.java4.modele.Reserve;

public class ProcessusTest {

	@Test
	public void test() {
		try {
			ActionStock action;
			Reserve reserve =   new Reserve(1000);
			action = new Ajout(reserve);
			Processus p1 = new Processus(200, 300, action);
			p1.start();
			Thread.currentThread().sleep(3000);
			p1.arreter();
			System.out.println(reserve.getStock());
			action = new Consommation(reserve);
			p1 = new Processus(200, 300, action);
			p1.start();
			Thread.currentThread().sleep(3000);
			p1.arreter();
			System.out.println(reserve.getStock());
		} catch (Exception e) {
			fail();
		}
	
	}

}
