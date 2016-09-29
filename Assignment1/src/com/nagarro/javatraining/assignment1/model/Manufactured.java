package com.nagarro.javatraining.assignment1.model;

public class Manufactured extends Item {

	public Manufactured(String name, String type, Double price, int qty) {
		super(name, type, price, qty);
	}
	public void calc_stl() 
	{
		stl = Constants.TAX_RATE_MANUFACTURED* price + (1+Constants.TAX_RATE_MANUFACTURED) * price * Constants.SURCHRGE_RATE_MANUFACTURED; 
		fppi = price + stl ;
	}

}
