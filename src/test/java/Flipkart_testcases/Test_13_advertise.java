package Flipkart_testcases;

import org.testng.annotations.Test;

import Common.BaseTest;
import Pages.Advertise_page;

public class Test_13_advertise extends BaseTest{
	public static String sheetName ="Data";
	@Test
	public void ad_test() throws InterruptedException {
	Advertise_page ad=new Advertise_page(driver);
//	String testname = "advertise_test";
//	HashMap<String, String> testData = new HashMap<String, String>();
//	testData = reader.getRowTestData(sheetName, testname);
//	String executionRequired = testData.get("Execution Required").toLowerCase();
//	Excel_Manager.toCheckExecutionRequired(executionRequired);
	ad.Advertisement_Function();
	
	}

}
