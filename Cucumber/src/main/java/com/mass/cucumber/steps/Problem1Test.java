package com.mass.cucumber.steps;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mass.cucumber.impl.BrowserType;
import com.mass.cucumber.impl.UtilHelper;
import com.mass.cucumber.pageObject.ApplicationText;
import com.mass.cucumber.pageObject.Problem1PageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * 
 * @author Rahul Kumar
 *
 */

public class Problem1Test {
	public WebDriver driver;

	private final Logger log = UtilHelper.getLogger(Problem1Test.class);
	Problem1PageObject valueObject = new Problem1PageObject(driver);
	UtilHelper util = new UtilHelper(driver);

	@Given("User navigate to url {string}")
	public void user_navigate_to_url(String url) throws Exception {
		WebDriver driver = UtilHelper.getBrowserObject(BrowserType.Chrome);
		driver.get(url);
		log.info("navigating to ..." + url);
	}

	@Given("^User is on problem#1 Page$")
	public void user_is_on_Registration_Page() throws IOException {
		String expPageTitle = util.readPropertiesFile("problemPageTitle");
		String actPageTitle = driver.getTitle();
		if (actPageTitle == expPageTitle) {
			log.info("Title Match And Bidder is on :" + expPageTitle + " Page ");
		} else
			log.info("Bidder is on :" + actPageTitle + " Page ");

	}

	@Then("User verify the right count of values appear on the screen")
	public void user_verify_the_right_count_of_values_appear_on_the_screen() {
		String value1 = util.getText(valueObject.value1Text);
		Assert.assertEquals(value1, ApplicationText.Value1);

		String value2 = util.getText(valueObject.value2Text);
		Assert.assertEquals(value2, ApplicationText.Value2);

		String value3 = util.getText(valueObject.value3Text);
		Assert.assertEquals(value3, ApplicationText.Value3);

		String value4 = util.getText(valueObject.value4Text);
		Assert.assertEquals(value4, ApplicationText.Value4);

		String value5 = util.getText(valueObject.value5Text);
		Assert.assertEquals(value5, ApplicationText.Value5);
	}

	@Then("User verify the values on the screen are greater than {int}")
	public void user_verify_the_values_on_the_screen_are_greater_than(int integer) {
		double value1 = valueObject.getValuesData(valueObject.value1Text);
		Assert.assertTrue(value1 > integer);

		double value2 = valueObject.getValuesData(valueObject.value2Text);
		Assert.assertTrue(value2 > integer);

		double value3 = valueObject.getValuesData(valueObject.value3Text);
		Assert.assertTrue(value3 > integer);

		double value4 = valueObject.getValuesData(valueObject.value4Text);
		Assert.assertTrue(value4 > integer);

		double value5 = valueObject.getValuesData(valueObject.value5Text);
		Assert.assertTrue(value5 > integer);

	}

	@Then("User verify the total balance is correct based on the values listed on the screen")
	public void user_verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() {
		double expectedSum = 0;
		double value1 = valueObject.getValuesData(valueObject.value1Text);
		double value2 = valueObject.getValuesData(valueObject.value2Text);
		double value3 = valueObject.getValuesData(valueObject.value3Text);
		double value4 = valueObject.getValuesData(valueObject.value4Text);
		double value5 = valueObject.getValuesData(valueObject.value5Text);
		expectedSum = value1 + value2 + value3 + value4 + value5;
		Assert.assertEquals(ApplicationText.TotalBalance, expectedSum,
				"Total Balance is Not Correct as Per the Listed Value");
	}

	@Then("User verify the values are formatted as currencies")
	public void user_verify_the_values_are_formatted_as_currencies() {
		String formattedValue1 = valueObject.verifyNumberFormat(valueObject.value1Text);
		String formattedValue2 = valueObject.verifyNumberFormat(valueObject.value2Text);
		String formattedValue3 = valueObject.verifyNumberFormat(valueObject.value3Text);
		String formattedValue4 = valueObject.verifyNumberFormat(valueObject.value4Text);
		String formattedValue5 = valueObject.verifyNumberFormat(valueObject.value5Text);

		String actualValue1 = util.getText(valueObject.value1Text);
		String actualValue2 = util.getText(valueObject.value2Text);
		String actualValue3 = util.getText(valueObject.value3Text);
		String actualValue4 = util.getText(valueObject.value4Text);
		String actualValue5 = util.getText(valueObject.value5Text);

		Assert.assertEquals(actualValue1, formattedValue1, "value1 is not formatted as a currencies");
		Assert.assertEquals(actualValue2, formattedValue2, "value2 is not formatted as a currencies");
		Assert.assertEquals(actualValue3, formattedValue3, "value3 is not formatted as a currencies");
		Assert.assertEquals(actualValue4, formattedValue4, "value4 is not formatted as a currencies");
		Assert.assertEquals(actualValue5, formattedValue5, "value5 is not formatted as a currencies");

	}

	@Then("User verify the total balance matches the sum of the values")
	public void user_verify_the_total_balance_matches_the_sum_of_the_values() {
		double Expectedsum = 0;
		double value1 = valueObject.getValuesData(valueObject.value1Text);
		double value2 = valueObject.getValuesData(valueObject.value2Text);
		double value3 = valueObject.getValuesData(valueObject.value3Text);
		double value4 = valueObject.getValuesData(valueObject.value4Text);
		double value5 = valueObject.getValuesData(valueObject.value5Text);
		Expectedsum = value1 + value2 + value3 + value4 + value5;
		Assert.assertEquals(ApplicationText.TotalBalance, Expectedsum,
				"Total Balance Not Matched as Per the Sum of Values");
	}

}
