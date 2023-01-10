package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.GroceryPage;
import Property.Reading_properties;

public class Test_07_grocery extends BaseTest {
	public static String sheetName = "Data";

	@Test
	public void grocery_test() throws InterruptedException {
		GroceryPage grocery_obj = new GroceryPage(driver);
		String testname = "Grocery_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		grocery_obj.Grocery_click();
		grocery_obj.enter_pin(Reading_properties.getProperty("pin"));
		grocery_obj.Pin();
		grocery_obj.Add_Item();
		grocery_obj.Check_cart();

	}

}
