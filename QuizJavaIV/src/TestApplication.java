import java.util.Scanner;


public class TestApplication {

	public static void main(String[] args) {
		String Code;
		 Scanner scan = new Scanner (System.in) ;
	     System.out.print ("Veuillez Entrer le code (EU, CA): ") ;
	     Code=scan.nextLine();	
	     
	     
	     FinancialToolsMethodeFactory  factory = new FinancialToolsMethodeFactory () ;
	    TaxProcessor taxProcessor = factory.getTaxProcessorInstance(Code);
	   
	    
	    	System.out.println("Les Taxes sont: " + taxProcessor.calculateTaxes());
	 
	}


	}


