package com.main.boku.shopping.cart.service;

import java.util.List;

public interface SalesTaxCalculatorService {
	/**
     * Calculate Shopping Cart Bill Users calculate records Bill (Once bill gets
     * generate user can’t add, edit, remove or calculate records.
     */
    public void calculateTax(List<?> shoppingCartItems) ;
}
