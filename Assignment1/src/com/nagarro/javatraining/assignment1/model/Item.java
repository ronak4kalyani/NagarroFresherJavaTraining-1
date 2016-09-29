package com.nagarro.javatraining.assignment1.model;

public abstract class Item {
	protected String name ;
	protected double price ;
	protected int qty ;
	protected String type ;
	protected double stl ;
	protected double fppi ;
	protected double total_Price ;
	
	public Item(String name, String type, Double price, int qty) {
		this.name = name ;
		this.type = type ;
		this.price = price ;
		this.qty = qty ;
	}
    public abstract void calc_stl() ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public double getStl() {
		return stl;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getFppi() {
		return fppi;
	}
	public int getQty() {
		return qty;
	}
	public String getType() {
		return type;
	}
	public double getTotal_Price() {
		return total_Price;
	}
	public void setTotal_Price(double total_Price) {
		this.total_Price = total_Price;
	}
	
	
	
}
