
public class FinancialToolsMethodeFactory {
 public TaxProcessor getTaxProcessorInstance(String code){
	 TaxProcessor  processor = null;
	 switch (code){
	 case "EU": processor =  getEuropeTaxProcessor();
		 break;
	 case "CA":processor = getCanadaTaxProcessor();
		 break;
		 default:
			 break;
		 
	 }
	 return processor;
 }
 private CanadaTaxProcessor getCanadaTaxProcessor(){
	 return new CanadaTaxProcessor();
 }
 private EuropeTaxProcessor getEuropeTaxProcessor(){
	 return new EuropeTaxProcessor();
 }
}
