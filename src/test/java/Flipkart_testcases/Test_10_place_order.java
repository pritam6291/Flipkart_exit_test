package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.CartPage;
import Pages.Place_order_page;
import Pages.SearchPage;
import Property.Reading_properties;

public class Test_10_place_order extends BaseTest{
	public static String sheetName = "Data";
	
	@Test
	public void order_place() throws InterruptedException {
		SearchPage Search=new SearchPage(driver);
		String testname = "Place_order_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		Search.Search_Text(Reading_properties.getProperty("product"));
		Search.Search_button();
		CartPage addProduct=new CartPage(driver);
		addProduct.Product_Click();
		addProduct.AddTocart();
		Place_order_page Order_obj=new Place_order_page(driver);
		Order_obj.Order();
		
	}
}
