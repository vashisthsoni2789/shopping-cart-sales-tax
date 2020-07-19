package com.main.boku.shopping.cart.service.impl;

import java.util.List;

import com.main.boku.shopping.cart.exception.ShoppingCartException;
import com.main.boku.shopping.cart.factory.ShopingCartFactory;
import com.main.boku.shopping.cart.service.SalesTaxCalculator;
import com.main.boku.shopping.cart.service.SalesTaxCalculatorService;
import com.main.boku.shopping.cart.util.SalesTaxConstants;

public class SalesTaxCalculatorServiceImpl implements SalesTaxCalculatorService {
	/**
     * This is only point of contact of outside world Calculate Shopping Cart
     * Bill Users calculate records Bill (Once bill gets generate user can’t
     * add, edit, remove or calculate records.
     * @throws ShoppingCartException
     */
    public void calculateTax(List<?> shoppingCartItems)  {
    	SalesTaxCalculator selesTaxCalculator = null;

        // Creating the ShoppingCart object using static factory
    	selesTaxCalculator = ShopingCartFactory.getInstance(SalesTaxConstants.SERVICE_TAXCALCULATORSERVICEIMPL);

        // calculate data
        try {
        	selesTaxCalculator.calculateTax(shoppingCartItems);
        } catch (ShoppingCartException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    //Logs exception into logging
        }

    }

}
