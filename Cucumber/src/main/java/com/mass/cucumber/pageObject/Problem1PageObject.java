package com.mass.cucumber.pageObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mass.cucumber.impl.UtilHelper;
import com.mass.cucumber.steps.Problem1Test;
import com.sun.tools.javac.util.Log;

/**
 * 
 * @author Rahul Kumar
 */
public class Problem1PageObject {
	private final Logger log = UtilHelper.getLogger(Problem1Test.class);

	private WebDriver driver;
	UtilHelper    util= new UtilHelper(driver);

	
	@FindBy(id="lbl_val_1")
	public WebElement value1Lable;
	
	@FindBy(id="lbl_val_2")
	public WebElement value2Lable;
	
	@FindBy(id="lbl_val_3")
	public WebElement value3Lable;
	
	@FindBy(id="lbl_val_4")
	public WebElement value4Lable;
	
	@FindBy(id="lbl_val_5")
	public WebElement value5Lable;
	
	@FindBy(id="txt_val_1")
	public WebElement value1Text;
	
	@FindBy(id="txt_val_2")
	public WebElement value2Text;
	
	@FindBy(id="txt_val_3")
	public WebElement value3Text;
	
	@FindBy(id="txt_val_4")
	public WebElement value4Text;
	
	@FindBy(id="txt_val_5")
	public WebElement value5Text;
	
	@FindBy(id="lbl_ttl_val")
	public WebElement totalBalanceLable;
	
	@FindBy(id="txt_ttl_val")
	public WebElement totalBalanceText;
	
    /**
     *  constructor used for Initilization purposes 
     * @param driver
     */
	public Problem1PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will return value based on attribute value	
	 * @param value
	 * @param element
	 * @return
	 */
	
	public String varifyValue(String value, WebElement element) {
		String attribute = element.getAttribute("value");
		log.info("Entered value:" + attribute);
		return attribute;
	}
	
	/**
	 * This method will help to get double data with space and $ symbol
	 * @param ele
	 * @return
	 */
	public double getValuesData(WebElement ele) {
		String p = ele.getText();
		double p1 = 0;
		if (p.contains("$")) {
			String actualData = p.substring(1);
			log.info(actualData);
			String doubleData = actualData.replace(",", "");
			p1 = Double.parseDouble(doubleData);
		}
		return p1;
	}
    
	/**
	 * This method is use for Number Formatting
	 * @param element
	 * @return
	 */
	public String verifyNumberFormat(WebElement element) {
		double value = getValuesData(element);
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		String actualValue = dollarFormat.format(value);
		return actualValue;

	}
}
