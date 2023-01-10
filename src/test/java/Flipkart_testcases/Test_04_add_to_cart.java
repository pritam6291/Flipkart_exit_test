package Flipkart_testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Common.BaseTest;
import Pages.CartPage;
import Pages.SearchPage;
import Property.Reading_properties;


public class Test_04_add_to_cart extends BaseTest{
	public static String sheetName ="Data";
	@Test
	public void addToCart() throws InterruptedException {
		SearchPage Search=new SearchPage(driver);
//		String testname = "addToCart_Test";
//		HashMap<String, String> testData = new HashMap<String, String>();
//		testData = reader.getRowTestData(sheetName, testname);
//		String executionRequired = testData.get("Execution Required").toLowerCase();
//		Excel_Manager.toCheckExecutionRequired(executionRequired);
		Logger log = Logger.getLogger(Test_04_add_to_cart.class);
		
		Search.Search_Text(Reading_properties.getProperty("product"));
		Search.Search_button();
		CartPage addProduct=new CartPage(driver);
		addProduct.Product_Click();
		addProduct.AddTocart();
		
	}

}
