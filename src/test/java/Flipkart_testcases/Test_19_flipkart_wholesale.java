package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Flipkart_Wholesale_page;

public class Test_19_flipkart_wholesale extends BaseTest{
	public static String sheetName ="Data";
	@Test
	public void wholesale_test() throws InterruptedException {
		Flipkart_Wholesale_page wholesale=new Flipkart_Wholesale_page(driver);
		String testname = "Flipkart_wholesale";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		wholesale.wholesale();
	}

}
