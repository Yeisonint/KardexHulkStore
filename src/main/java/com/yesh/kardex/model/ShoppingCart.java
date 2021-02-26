package com.yesh.kardex.model;


public class ShoppingCart {
	int item;
	int idProduct;
	String names;
	String description;
	long purchase_Price;
	int amount;
	long total;
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(int item, int idProduct, String names, String description, long purchase_Price, int amount,
			long total) {
		super();
		this.item = item;
		this.idProduct = idProduct;
		this.names = names;
		this.description = description;
		this.purchase_Price = purchase_Price;
		this.amount = amount;
		this.total = total;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPurchase_Price() {
		return purchase_Price;
	}
	public void setPurchase_Price(long purchase_Price) {
		this.purchase_Price = purchase_Price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
}
