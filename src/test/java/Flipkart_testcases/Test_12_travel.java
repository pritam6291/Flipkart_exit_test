package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.TravelPage;
import Property.Reading_properties;

public class Test_12_travel extends BaseTest {
	public static String sheetName = "Data";
	


	@Test
	public void Test_searchFlight() throws InterruptedException {

		
		TravelPage travel = new TravelPage(driver);
		String testname = "Travel_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		travel.Travel_now();
		travel.From_city(Reading_properties.getProperty("City1"));
		travel.To_city(Reading_properties.getProperty("City2"));
		//travel.Return_Date();
		//travel.Search_Flight();
		

	}

}
