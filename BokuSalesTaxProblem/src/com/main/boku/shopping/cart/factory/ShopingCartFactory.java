package com.main.boku.shopping.cart.factory;

import com.main.boku.shopping.cart.service.SalesTaxCalculator;
import com.main.boku.shopping.cart.service.impl.SalesTaxCalculatorImpl;
import com.main.boku.shopping.cart.util.SalesTaxConstants;

/**
 * This is Static Factory for Object creation. Currently its creating only
 * ServiceTaxCalculatorImpl object but if in future required to decorate any
 * object then factory would help it modify it easily.
 *
 * @author Vashisth Soni
 *
 */
public class ShopingCartFactory {

	private static SalesTaxCalculator uniqueInstance = null;

	// made class immutable
	private ShopingCartFactory() {
	}

	/**
	 * following method will return instance of BO Currently single thread is
	 * accessing instance so no need synchronization
	 * 
	 * @param type
	 * @return
	 */
	public static SalesTaxCalculator getInstance(String type) {

		// null check
		if (type == null) {
			return uniqueInstance;
		}

		switch (type) {
		case SalesTaxConstants.SERVICE_TAXCALCULATORSERVICEIMPL:
			if (isUniqueInstance(uniqueInstance))
				uniqueInstance = new SalesTaxCalculatorImpl();
			break;
		// for future enhancement added only for example purpose not in use
		case "ABC":
			if (isUniqueInstance(uniqueInstance))
				// TODO uniqueInstance = null;
				break;
			// Default value
		default:
			if (isUniqueInstance(uniqueInstance))
				uniqueInstance = new SalesTaxCalculatorImpl();
			break;
		}

		return uniqueInstance;
	}

	/**
	 * Method is use instance null or not for readability purpose
	 * 
	 * @param Instance
	 * @return
	 */
	private static boolean isUniqueInstance(SalesTaxCalculator Instance) {

		if (Instance == null)
			return true;
		else
			return false;

	}

}
