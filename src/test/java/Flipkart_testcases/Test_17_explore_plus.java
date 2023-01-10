package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Explore_plus_Page;

public class Test_17_explore_plus extends BaseTest{
	public static String sheetName ="Data";
	
	@Test
	public void Explore() throws InterruptedException {
		Explore_plus_Page explore=new Explore_plus_Page(driver);
		
		String testname = "Explore_plus_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		explore.reward_store();
	}


}
