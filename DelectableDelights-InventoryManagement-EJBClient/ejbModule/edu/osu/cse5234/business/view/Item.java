package edu.osu.cse5234.business.view;

public class Item implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6205737053442725966L;
	private String name;
	private String price;
	private String quantity;
	private static int stock=-1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
