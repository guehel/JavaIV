
public class EuropeFinancialToolsFactory extends FinancialTooleFactory {

	@Override
	public EuropeTaxProcessor createTaxProcessor() {
		
		return new EuropeTaxProcessor();
	}

}
