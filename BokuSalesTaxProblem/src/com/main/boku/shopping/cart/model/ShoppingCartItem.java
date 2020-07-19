package com.main.boku.shopping.cart.model;

import java.math.BigDecimal;

public class ShoppingCartItem {
	private boolean domesticTaxPercentage;
	private boolean additionalImportedTaxPercentage;
	private boolean exemptTax;
	private String goodsName = "";
	private BigDecimal goodsPrice;
	private int quantity;
	private BigDecimal calculateTaxPercentage;
	
	
	public ShoppingCartItem() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ShoppingCartItem(String goodsName, BigDecimal goodsPrice, int quantity, boolean domesticTaxPercentage
			, boolean additionalImportedTaxPercentage, boolean exemptTax)
	{
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.quantity = quantity;
		this.domesticTaxPercentage = domesticTaxPercentage;
		this.additionalImportedTaxPercentage = additionalImportedTaxPercentage;
		this.exemptTax = exemptTax;
		this.calculateTaxPercentage = new BigDecimal(0);
	}
	
	/**
	 *
	 * @return
	 */
	public boolean isAdditionalImportedTaxPercentage() {
		return additionalImportedTaxPercentage;
	}

	/**
	 *
	 * @param additionalImportedTaxPercentage
	 */
	public void setAdditionalImportedTaxPercentage(boolean additionalImportedTaxPercentage) {
		this.additionalImportedTaxPercentage = additionalImportedTaxPercentage;
	}

	/**
	 *
	 * @return
	 */

	public boolean isDomesticTaxPercentage() {
		return domesticTaxPercentage;
	}

	/**
	 *
	 * @param domesticTaxPercentage
	 */
	public void setDomesticTaxPercentage(boolean domesticTaxPercentage) {
		this.domesticTaxPercentage = domesticTaxPercentage;
	}

	public boolean isExemptTax() {
		return exemptTax;
	}

	/**
	 *
	 * @param exemptTax
	 */
	public void setExemptTax(boolean exemptTax) {
		this.exemptTax = exemptTax;
	}

	/**
	 *
	 * @return
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 *
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 *
	 * @return
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 *
	 * @param goodsPrice
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	/**
	 *
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 *
	 * @param goodsquontity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 *
	 * @return
	 */
	public BigDecimal getCalculateTaxPercentage() {
		return calculateTaxPercentage;
	}

	/**
	 *
	 * @param calculateTaxPercentage
	 */
	public void setCalculateTaxPercentage(BigDecimal calculateTaxPercentage) {
		this.calculateTaxPercentage = calculateTaxPercentage;
	}

	@Override
	public String toString() {
		System.out.println("Input Data ");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------- ");
		return "\n\n " + "Goods Name=" + getGoodsName() + "\n " + "Goods Quontity=" + getQuantity() + "\n "
				+ "Good sPrice=" + getGoodsPrice();
	}
}
