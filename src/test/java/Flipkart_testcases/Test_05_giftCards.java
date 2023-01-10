package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Explore_plus_Page;
import Pages.Gift_Cards_page;

public class Test_05_giftCards extends BaseTest{
	public static String sheetName ="Data";
	
	@Test
	public void GiftCardTest() throws InterruptedException {
		Gift_Cards_page gift=new Gift_Cards_page(driver);
		
		String testname = "Gift_Cards_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		gift.GiftCardFunction();
		gift.Buy_Card();
		gift.fill_details();
	}

}
