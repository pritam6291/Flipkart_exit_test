package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Mouse_hover_Page;

public class Test_09_mouse_hover extends BaseTest{
	public static String sheetName = "Data";
	
	@Test
	public void Hover() throws InterruptedException {
		Mouse_hover_Page hover=new Mouse_hover_Page(driver);
		String testname = "MouseHover_test";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		Excel_Manager.toCheckExecutionRequired(executionRequired);
		hover.hoverIt();
		hover.ClickMen();
		
	}

}
