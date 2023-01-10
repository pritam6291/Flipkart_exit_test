package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Explore_plus_Page;
import Pages.Title_Verification;

public class test_01_verify_title extends BaseTest{
	public static String sheetName = "Data";
	@Test
	public void TitleVerify() {
		
		String testname = "Verify_Title_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);

		Title_Verification titleVerify = new Title_Verification();
		
		titleVerify.VerifyIt();

	}

}
