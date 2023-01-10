package Flipkart_testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Common.BaseTest;
import Excel_configuration.Excel_Manager;
import Pages.Explore_plus_Page;
import Pages.LoginPage;
import Property.Reading_properties;

public class Test_02_login extends BaseTest{
	public static String sheetName = "Data";
	
	
	
	@Test
	public  void login() {
	LoginPage logIn=new LoginPage(driver);
	Explore_plus_Page explore=new Explore_plus_Page(driver);
	explore.cancel();
	String testname = "Login_test";
	HashMap<String, String> testData = new HashMap<String, String>();
	testData = reader.getRowTestData(sheetName, testname);
	String executionRequired = testData.get("Execution Required").toLowerCase();
	Excel_Manager.toCheckExecutionRequired(executionRequired);
	logIn.login_btn();
	logIn.Phn(Reading_properties.getProperty("phone_no"));
	logIn.OTP_btn();
	
	

}
}
