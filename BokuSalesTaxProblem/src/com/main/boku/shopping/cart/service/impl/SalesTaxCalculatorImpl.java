package com.main.boku.shopping.cart.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.main.boku.shopping.cart.exception.ShoppingCartException;
import com.main.boku.shopping.cart.model.ShoppingCartItem;
import com.main.boku.shopping.cart.util.SalesTaxConstants;
import com.main.boku.shopping.cart.util.SalesTaxUtil;

public class SalesTaxCalculatorImpl extends SalesTaxCalculatorBaseImpl {
	/**
	 * @author Vashisth Soni 
	 * Following method is used to calculate tax 
	 * 		1) Basic sales tax is applicable at a rate of 10% on all goods, 
	 * 		2) Except books, food, and medical products that are exempt. 
	 * 		3) Import duty is an additional sales tax applicable on all imported goods at a rate of
	 *         5%, with no exemptions.
	 *
	 * @param shoppingCartItems
	 * @return
	 * @throws ShoppingCartException
	 */
	public List<ShoppingCartItem> calculateTaxPercentage(List<?> shoppingCartItems) throws ShoppingCartException {

		BigDecimal taxPercent = null;
		BigDecimal hundread = new BigDecimal(SalesTaxConstants.HUNDREAD);
		BigDecimal taxPercentage = null;

		List<ShoppingCartItem> newshoppingCartItems = new ArrayList<ShoppingCartItem>();

		for (Object o : shoppingCartItems) {
			ShoppingCartItem salesTax = (ShoppingCartItem) o;

			if (salesTax.isExemptTax()) {
				taxPercentage = new BigDecimal(SalesTaxUtil.readProperties(SalesTaxConstants.EXEMPT));
			} else if (salesTax.isDomesticTaxPercentage() && salesTax.isAdditionalImportedTaxPercentage()) {
				taxPercentage = new BigDecimal(
						SalesTaxUtil.readProperties(SalesTaxConstants.BASIC_SALES_TAX_AND_IMPORT_DUTY));
			} else if (salesTax.isDomesticTaxPercentage()) {
				taxPercentage = new BigDecimal(SalesTaxUtil.readProperties(SalesTaxConstants.BASIC_SALES_TAX));
			} else if (salesTax.isAdditionalImportedTaxPercentage()) {
				taxPercentage = new BigDecimal(SalesTaxUtil.readProperties(SalesTaxConstants.IMPORT_DUTY));
			}

			// Calculate Tax
			taxPercent = salesTax.getGoodsPrice().multiply(taxPercentage).divide(hundread).setScale(2,
					RoundingMode.HALF_UP);
			// created new dto list
			newshoppingCartItems = SalesTaxUtil.convertDto(salesTax, taxPercent, newshoppingCartItems);
			// put values into Map
		} // While

		return newshoppingCartItems;
	}

	/**
	 * Following method is used to display Bill
	 *
	 * @param shoppingCartItems
	 */
	public void displayBill(List<?> shoppingCartItems) {
		if (shoppingCartItems != null) {

			// System.out.println(" \t \t \t :SHOPPING BILL: ");
			// System.out.println("\n \n ");
			System.out.println("=============================================================================");
			System.out.println("Quantity " + "\t" + "\t" + "\t" + " Name " + "\t" + "\t" + "\t" + " Price ");
			System.out.println("=============================================================================");

			shoppingCartItems.forEach(k -> {
				ShoppingCartItem inputDataDTO = (ShoppingCartItem) k;

				System.out.println(inputDataDTO.getQuantity() + "\t" + "\t" + inputDataDTO.getGoodsName() + "\t" + "\t"
						+ ":" + addTaxandPrice(inputDataDTO.getCalculateTaxPercentage(), inputDataDTO.getGoodsPrice()));
			});

			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Sales Tax : " + totalTax(shoppingCartItems));
			System.out.println("Total : " + totalPrice(shoppingCartItems));

		} // end of if
		System.out.println("=============================================================================");
	}

}
