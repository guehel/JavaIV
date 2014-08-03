package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.java4.modele.*;

public class SimStockTest {

	@Test
	public void test() {
		try {
			Reserve reserve  = new Reserve(500);
			SimStock simulateur = new SimStock(reserve);
			ActionStock ajout1 = new Ajout(reserve);
			ActionStock ajout2 = new Ajout(reserve);
			ActionStock consommation = new Consommation(reserve);
			Processus processus1 = new Processus(100, 100, ajout1);
			Processus processus2 = new Processus(200, 150, ajout2);
			Processus processus3 = new Processus(600, 200, consommation);
			simulateur.addProcessus(processus1);
			simulateur.addProcessus(processus2);
			simulateur.addProcessus(processus3);
			simulateur.startProcessus();
			Thread.currentThread().sleep(20000);
			simulateur.stopProcessus();
		} catch (Exception e) {
			fail();
		}
	}

}
