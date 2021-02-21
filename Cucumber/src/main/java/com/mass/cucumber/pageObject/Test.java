package com.mass.cucumber.pageObject;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import org.junit.Assert;

public class Test {

	public static void main(String[] args) throws ParseException {

		
		String p = "$122,365.24";
		double p1 = 0;
		if (p.contains("$")) {
			String actualData = p.substring(1);
			System.out.println(actualData);
			String doubleData= actualData.replace(",", "");
			 p1 = Double.parseDouble(doubleData);
			 System.out.println(p1);
			 if(p1>0) {
				 System.out.println("yes");
			 }
		}
		double d1=122365.24;
		double d2=599.00;
		double d3=850139.99;
		

		double d4=23329.50;
		double d5=566.27;
		System.out.println(d1+d2+d3+d4+d5);
		
		//Assert.assertEquals("Value Not Matches ",3,2);
		
		
		String currencyAmount = "122365.24";
		double actualValue1=122365.24;
		// Create a new Locale
		Locale usa = new Locale("en", "US");
		// Create a Currency instance for the Locale
		Currency dollars = Currency.getInstance(usa);
		// Create a formatter given the Locale
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		System.out.println(dollarFormat.format(actualValue1));
	//	Assert.assertEquals("$122,365.24", dollarFormat.format(currencyAmount));
	
	//	NumberFormat format = NumberFormat.getCurrencyInstance();
	//	Number number = format.parse("$123,456.78");
	//	System.out.println(number.toString());
	
	}
	
	
	

	
	
	

}
