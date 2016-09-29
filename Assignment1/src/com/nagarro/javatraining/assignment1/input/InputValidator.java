package com.nagarro.javatraining.assignment1.input;
import com.nagarro.javatraining.assignment1.model.Constants;
public class InputValidator {

	public static boolean checkDouble(String str) {
		try {
			Double.parseDouble(str) ;
		}
		catch (NumberFormatException e) {
			System.err.print("Enter the Item price Again in double format : ");
			return false ;
		}
		return true ;
	}

	public static boolean checkItemType(String str) {
		if (str.equalsIgnoreCase(Constants.RAW)|str.equalsIgnoreCase(Constants.MANUFACTURED)|str.equalsIgnoreCase(Constants.IMPORTED))
			return true ;
		System.err.print("You entered the item type in wrong format . kindly enter again .\nEnter one of the following (raw,manufactured,imported) :");
		return false ;
	}

	public static boolean checkInt(String str) {
		try {
			 Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.err.print("Enter the Qty Again in Integer format : ");
			return false ;
		}
		return true ;
	}

}
