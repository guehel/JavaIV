
public class CanadaFinancialToolsFactory extends FinancialTooleFactory {

	@Override
	public CanadaTaxProcessor createTaxProcessor() {
		
		return new CanadaTaxProcessor();
	}

}
