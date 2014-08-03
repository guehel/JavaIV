package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.java4.modele.Reserve;

public class ReserveTest {

	@Test
	public void test() {
	Reserve reserve = null;
	try {
		reserve = new Reserve(500);
		reserve.ajoute(200);
		assertTrue(reserve.getStock()==700);
		reserve.consomme(700);
		assertTrue(reserve.getStock()==0);
		for(int i = 0; i<5 ; i++)
		reserve.consomme(700);
		assertTrue(reserve.getStock()==0);
		System.out.println(reserve.getCompteur());
		assertTrue(reserve.getCompteur()==5);
		reserve.consomme(-2);
		fail();
		
	} 
	catch (RuntimeException e1){
		
	}
	catch (Exception e) {
		fail();
	}
	}

}
