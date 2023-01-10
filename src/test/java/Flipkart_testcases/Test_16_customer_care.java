package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Customer_care_Page;

public class Test_16_customer_care extends BaseTest{
	public static String sheetName ="Data";
	@Test
	public void Customer_care_test() throws InterruptedException {
		Customer_care_Page customer=new Customer_care_Page(driver);
		String testname = "Customer_care_Test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		customer.Contact();
		customer.cust_care();
	}


}
