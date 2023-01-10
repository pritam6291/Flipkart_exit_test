package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.MobilesPage;

public class Test_08_mobiles extends BaseTest {
	public static String sheetName = "Data";
	
	@Test
	public void Mobile_TestCase() throws InterruptedException {
	MobilesPage Mobile=new MobilesPage(driver);
	String testname = "Mobiles_test";
	HashMap<String, String> testData = new HashMap<String, String>();
	testData = reader.getRowTestData(sheetName, testname);
	String executionRequired = testData.get("Execution Required").toLowerCase();
	Excel_Manager.toCheckExecutionRequired(executionRequired);
	Mobile.Select_Filters();
	

}

}
