package com.main.boku.shopping.cart.service;

import java.util.List;

import com.main.boku.shopping.cart.exception.ShoppingCartException;
import com.main.boku.shopping.cart.model.ShoppingCartItem;

public interface SalesTaxCalculator {
	 /**
     * following class is single point of entry of outside world
     * @param shoppingCartItems
     * @throws ShoppingCartException
     */
    public void calculateTax(List<?> salesTaxItemsList) throws ShoppingCartException;
    /**
     * Displaying result as per user requirement
     * @param shoppingCartItems
     */
    public  void displayBill(List<?> salesTaxItemsList);
    /**
     * calculate tax
     * @param shoppingCartItems
     * @return
     * @throws ShoppingCartException
     */
    public  List<ShoppingCartItem> calculateTaxPercentage(List<?> salesTaxItemsList) throws ShoppingCartException ;
}
