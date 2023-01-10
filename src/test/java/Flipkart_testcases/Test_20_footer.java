package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Explore_plus_Page;
import Pages.FooterPage;

public class Test_20_footer extends BaseTest{
	public static String sheetName ="Data";
	
	
    
	
	@Test
	public void FacebookFooterTest() throws InterruptedException {
	
	
	FooterPage Footerobj=new FooterPage(driver);
	String testname = "Footer_test";
	HashMap<String, String> testData = new HashMap<String, String>();
	testData = reader.getRowTestData(sheetName, testname);
	String executionRequired = testData.get("Execution Required").toLowerCase();
	Excel_Manager.toCheckExecutionRequired(executionRequired);
	Footerobj.FooterPage();
	
}

}
