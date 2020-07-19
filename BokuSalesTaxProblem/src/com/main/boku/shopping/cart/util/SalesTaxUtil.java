package com.main.boku.shopping.cart.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import com.main.boku.shopping.cart.exception.ShoppingCartException;
import com.main.boku.shopping.cart.model.ShoppingCartItem;

public class SalesTaxUtil {
	/**
	 * Following method is used to read properties file read properties file
	 * 
	 * @param keyValue
	 * @return
	 * @throws ShoppingCartException
	 */
	public static String readProperties(String keyValue) throws ShoppingCartException {
		Properties prop = new Properties();
		FileInputStream fis = null;
		String propertiesKey = null;
		try {
			fis = new FileInputStream(SalesTaxConstants.PROPERTIES_URL);
			prop.load(fis);
			// get value from key
			propertiesKey = prop.getProperty(keyValue);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Will handle Try.catch writing my own exception handler
				e.printStackTrace();
				throw new ShoppingCartException("Issue in reading File");
			}
		}
		return propertiesKey;
	}

	/**
	 * Following method is using to set result into SalesTax object
	 *
	 * @param inputDataDTO
	 * @param taxPercent
	 * @return
	 */
	public static List<ShoppingCartItem> convertDto(ShoppingCartItem inputDataDTO, BigDecimal taxPercent,
			List<ShoppingCartItem> newshoppingCartItems) {

		ShoppingCartItem salesTax = new ShoppingCartItem();

		salesTax.setAdditionalImportedTaxPercentage(inputDataDTO.isAdditionalImportedTaxPercentage());
		salesTax.setCalculateTaxPercentage(taxPercent);
		salesTax.setDomesticTaxPercentage(inputDataDTO.isDomesticTaxPercentage());
		salesTax.setExemptTax(inputDataDTO.isExemptTax());
		salesTax.setGoodsName(inputDataDTO.getGoodsName());
		salesTax.setGoodsPrice(inputDataDTO.getGoodsPrice());
		salesTax.setQuantity(inputDataDTO.getQuantity());
		// Added into List
		newshoppingCartItems.add(salesTax);

		return newshoppingCartItems;
	}
}
