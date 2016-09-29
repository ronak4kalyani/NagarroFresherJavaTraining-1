package com.nagarro.javatraining.assignment1.model;

public class Raw extends Item{

	public Raw(String name, String type, Double price, int qty) {
		super(name, type, price, qty);
	}
	
	public void calc_stl() 
	{
		stl = Constants.TAX_RATE_RAW * price ; 
		fppi = price + stl ;
	}
}
