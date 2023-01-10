package Flipkart_testcases;

import org.testng.annotations.Test;

import Common.BaseTest;
import Pages.CartPage;
import Pages.Compare_page;
import Pages.SearchPage;
import Property.Reading_properties;

public class Test_15_compare extends BaseTest {
	public static String sheetName ="Data";
	
	@Test
	public void compare_product() throws InterruptedException {
		SearchPage Search=new SearchPage(driver);
//		String testname = "Compare_Test";
//		HashMap<String, String> testData = new HashMap<String, String>();
//		testData = reader.getRowTestData(sheetName, testname);
//		String executionRequired = testData.get("Execution Required").toLowerCase();
//		Excel_Manager.toCheckExecutionRequired(executionRequired);
		Search.Search_Text(Reading_properties.getProperty("product"));
		Search.Search_button();
		Thread.sleep(5000);
		CartPage addProduct=new CartPage(driver);
		Compare_page compare=new Compare_page(driver);
		compare.Compare_now();
	}

}
