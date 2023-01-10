package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Flipkart_stories_page;

public class Test_18_flipkart_stories extends BaseTest {
	public static String sheetName ="Data";
	@Test
	public void stories() throws InterruptedException {
		Flipkart_stories_page story=new Flipkart_stories_page(driver);
		String testname = "Flipkart_stories_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		story.stories();
	}

}
