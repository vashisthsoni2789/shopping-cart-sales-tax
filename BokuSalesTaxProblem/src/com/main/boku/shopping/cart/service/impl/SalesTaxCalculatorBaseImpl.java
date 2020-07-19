package com.main.boku.shopping.cart.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.main.boku.shopping.cart.exception.ShoppingCartException;
import com.main.boku.shopping.cart.model.ShoppingCartItem;
import com.main.boku.shopping.cart.service.SalesTaxCalculator;

public abstract class SalesTaxCalculatorBaseImpl implements SalesTaxCalculator {
	// ROUND_FACTOR
	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
	private static volatile int billNo = 0;

	/**
	 * Calculate Shopping Cart Bill Users calculate records Bill (Once bill gets
	 * generate user can’t add, edit, remove or calculate records)
	 * 
	 * @throws ShoppingCartException
	 */
	public void calculateTax(List<?> shoppingCartItems) throws ShoppingCartException {

		// Calculate records
		List<?> newshoppingCartItems = this.calculateTaxPercentage(shoppingCartItems);
		System.out.println("\n");
		System.out.println(" \t \t \t :SHOPPING BILL: \t \t \t " + " BILL NO: " + ++billNo);
		this.displayBill(newshoppingCartItems);

	}

	/**
	 * Following method is used to display Bill May be in future requirement gets
	 * change and want to display result in different format thats why I have made
	 * it abstract
	 *
	 * @param shoppingCartItems
	 */
	public abstract void displayBill(List<?> shoppingCartItems);

	/**
	 * Following method is used to calculate tax 1) Basic sales tax is applicable at
	 * a rate of 10% on all goods, 2) Except books, food, and medical products that
	 * are exempt. 3) Import duty is an additional sales tax applicable on all
	 * imported goods at a rate of 5%, with no exemptions.
	 *
	 * When I purchase items I receive a receipt which lists the name of all the
	 * items and their price (including tax),
	 *
	 * finishing with the total cost of the items, and the total amounts of sales
	 * taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a
	 * shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
	 * sales tax.
	 *
	 * @param shoppingCartItems
	 * @return
	 * @throws ShoppingCartException
	 */
	public abstract List<ShoppingCartItem> calculateTaxPercentage(List<?> shoppingCartItems)
			throws ShoppingCartException;

	/**
	 * Following method is used for add tax with price
	 *
	 * @param calculateTaxPercentage
	 * @param goodsPrice
	 * @return
	 */
	protected BigDecimal addTaxandPrice(BigDecimal calculateTaxPercentage, BigDecimal goodsPrice) {
		BigDecimal addtax = calculateTaxPercentage.add(goodsPrice);
		addtax = roundOff(addtax);
		return addtax;
	}

	/**
	 * Following method is used to calculate total price
	 *
	 * @param shoppingCartItems
	 * @return
	 */
	protected BigDecimal totalPrice(List<?> shoppingCartItems) {

		BigDecimal total = new BigDecimal(0);

		if (shoppingCartItems != null) {

			for(Object o: shoppingCartItems) {
				ShoppingCartItem salesTax = (ShoppingCartItem) o;
				total = total.add(salesTax.getGoodsPrice().add(salesTax.getCalculateTaxPercentage()));

			} // end of while

		}
		total = this.roundOff(total);

		return total;
	}

	/**
	 * Following method is used to calculate total tax
	 *
	 * @param shoppingCartItems
	 * @return
	 */
	protected BigDecimal totalTax(List<?> shoppingCartItems) {

		BigDecimal total = new BigDecimal(0);

		for(Object o: shoppingCartItems) {
			ShoppingCartItem salesTax = (ShoppingCartItem) o;
			total = total.add(salesTax.getCalculateTaxPercentage());
		} // end of for

			total = roundOff(total);
		return total;
	}

	/**
	 * JDK 1.4 Following method is used for round off up to .05 Round of 0.05
	 *
	 * @param value
	 * @return
	 */

	protected BigDecimal roundOff(BigDecimal value) {
		value = value.divide(ROUND_FACTOR);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value = value.multiply(ROUND_FACTOR);
		return value;
	}

}
