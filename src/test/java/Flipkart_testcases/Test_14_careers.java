package Flipkart_testcases;

import org.testng.annotations.Test;

import Common.BaseTest;
import Pages.Careers_Page;

public class Test_14_careers extends BaseTest {
	public static String sheetName ="Data";

	@Test
	public void Careers_Test() throws InterruptedException {
		Careers_Page careers = new Careers_Page(driver);
//		String testname = "Careers_Test";
//		HashMap<String, String> testData = new HashMap<String, String>();
//		testData = reader.getRowTestData(sheetName, testname);
//		String executionRequired = testData.get("Execution Required").toLowerCase();
//		Excel_Manager.toCheckExecutionRequired(executionRequired);
		careers.Careers_footer();
		careers.hoverIt();
		careers.Job_places();
		careers.filters();
		careers.choose_job();

	}

}
