package com.nagarro.javatraining.assignment1.model;

public class Imported extends Item {

	public Imported(String name, String type, Double price, int qty) {
		super(name, type, price, qty);
	}
	public void calc_stl() 
	{
		stl = Constants.IMPORT_DUTY_IMPORTED* price ;
		fppi = price + stl ;
		if (fppi<=100)
		{
			stl += 5 ;
			fppi+=5 ;
		}
		else if (fppi<=200)
		{
			stl += 10 ;
			fppi+=10 ;
		}
		else
		{
			fppi = 1.05 * fppi ;
			stl = fppi - price ;
		}
	}

}
