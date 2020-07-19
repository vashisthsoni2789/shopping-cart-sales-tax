package com.main.boku.shopping.cart.util;

public interface SalesTaxConstants {

	// Properties file location
	public String PROPERTIES_URL = "src/salestax.properties";
	// Properties File
	public String EXEMPT = "EXEMPT";// exempt
	public String IMPORT_DUTY = "IMPORTDUTY";// additionalImportedTaxPercentage
	public String BASIC_SALES_TAX = "BASICSALESTAX";// domesticTaxPercentage
	public String BASIC_SALES_TAX_AND_IMPORT_DUTY = "SALESTAXANDIMPORTDUTY";// additionalImportedTaxPercentage+domesticTaxPercentage
	// Service locator
	public String SERVICE_TAXCALCULATORSERVICEIMPL = "TaxCalculatorServiceImpl";

	public String HUNDREAD = "100";

}
