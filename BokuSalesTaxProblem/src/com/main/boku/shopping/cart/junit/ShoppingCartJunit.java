package com.main.boku.shopping.cart.junit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.main.boku.shopping.cart.model.ShoppingCartItem;
import com.main.boku.shopping.cart.service.SalesTaxCalculatorService;
import com.main.boku.shopping.cart.service.impl.SalesTaxCalculatorServiceImpl;

public class ShoppingCartJunit {

	@Test
	public void testScenarioInput_001() {

		ShoppingCartItem salesTax = null;
		List<ShoppingCartItem> shoppingCartList = new ArrayList<ShoppingCartItem>();
		// System.out.println("Input 1:");

		// TODO Input 1: 1 book at 12.49
		salesTax = new ShoppingCartItem("Book", new BigDecimal(12.49), 1, false, false, true);
		shoppingCartList.add(salesTax);

		// 1 music CD at 14.99
		salesTax = new ShoppingCartItem("Music CD", new BigDecimal(14.99), 1, true, false, false);
		shoppingCartList.add(salesTax);

		// 1 chocolate bar at 0.85
		salesTax = new ShoppingCartItem("Chocolate bar", new BigDecimal(0.85), 1, false, false, true);
		shoppingCartList.add(salesTax);

		try {
			// Creating the ShoppingCart
			SalesTaxCalculatorService shopping = new SalesTaxCalculatorServiceImpl();

			// calculate data
			shopping.calculateTax(shoppingCartList);

		} catch (Throwable e) {
			// This operation is not supported hence getting an error
			System.out.println(e.getLocalizedMessage());
		}

	}

	/**
	 * Method purpose : Input 2: 1 imported box of chocolates at 10.00 1 imported
	 * bottle of perfume at 47.50 Insert calculate tax
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testScenarioInput_002() {

		ShoppingCartItem salesTax = null;
		List<ShoppingCartItem> shoppingCartList = new ArrayList<ShoppingCartItem>();
		// System.out.println("Input 2:");
		// TODO Input 2:
		// 1 imported box of chocolates at 10.00

		salesTax = new ShoppingCartItem("Imported box of chocolates", new BigDecimal(10.00), 1, false, true, false);
		// Add to list
		shoppingCartList.add(salesTax);

		// 1 imported bottle of perfume at 47.50
		salesTax = new ShoppingCartItem("Imported bottle of perfume", new BigDecimal(47.50), 1, true, true, false);
		shoppingCartList.add(salesTax);
		
		try {
			// Creating the ShoppingCart
			SalesTaxCalculatorService shopping = new SalesTaxCalculatorServiceImpl();

			// calculate data
			shopping.calculateTax(shoppingCartList);

		} catch (Throwable e) {
			// This operation is not supported hence getting an error
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Method purpose : Input 3 1 imported bottle of perfume at 27.99 1 bottle of
	 * perfume at 18.99 1 packet of headache pills at 9.75 1 box of imported
	 * chocolates at 11.25 Insert calculate tax
	 *
	 * @param
	 * @return void
	 */
	@Test
	public void testScenarioInput_003() {

		ShoppingCartItem salesTax = null;
		ArrayList<ShoppingCartItem> shoppingCartList = new ArrayList<ShoppingCartItem>();
		// System.out.println("Input 3:");
		// TODO Input 3 :
		// 1 imported bottle of perfume at 27.99
		salesTax = new ShoppingCartItem("Imported bottle of perfume", new BigDecimal(27.99), 1, true, true, false);
		shoppingCartList.add(salesTax);

		// 1 bottle of perfume at 18.99
		salesTax = new ShoppingCartItem("Bottle of perfume", new BigDecimal(18.99), 1, true, false, false);
		shoppingCartList.add(salesTax);

		// 1 packet of headache pills at 9.75
		salesTax = new ShoppingCartItem("Packet of headache pills", new BigDecimal(9.75), 1, false, false, true);
		shoppingCartList.add(salesTax);

		// 1 box of imported chocolates at 11.25
		salesTax = new ShoppingCartItem("Imported box of chocolates", new BigDecimal(11.25), 1, false, true, false);
		shoppingCartList.add(salesTax);
		
		try {
			// Creating the ShoppingCart
			SalesTaxCalculatorService shopping = new SalesTaxCalculatorServiceImpl();

			// calculate data
			shopping.calculateTax(shoppingCartList);

		} catch (Throwable e) {
			// This operation is not supported hence getting an error
			System.out.println(e.getLocalizedMessage());
		}
	}

}
