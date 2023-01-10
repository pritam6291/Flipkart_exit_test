package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Seller_page;

public class Test_11_Seller extends BaseTest {
	public static String sheetName = "Data";
	@Test
	public void SellerTest() throws InterruptedException {
		Seller_page become_seller = new Seller_page(driver);
		String testname = "Seller_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		become_seller.Seller_method();

	}

}
