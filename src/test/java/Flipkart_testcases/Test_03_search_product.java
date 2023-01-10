package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.SearchPage;
import Property.Reading_properties;

public class Test_03_search_product extends BaseTest{
	public static String sheetName = "Data";
	@Test
	public void search() throws InterruptedException{
		SearchPage Search=new SearchPage(driver);
		String testname = "Search_Product_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		Search.Search_Text(Reading_properties.getProperty("product"));
		Search.Search_button();
		Thread.sleep(1000);
		Search.Verify_Title();	
	}
}
