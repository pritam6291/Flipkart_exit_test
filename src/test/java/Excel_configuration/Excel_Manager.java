package Excel_configuration;

import org.apache.log4j.Logger;
import org.testng.SkipException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.BaseTest;
import Property.Reading_properties;

public class Excel_Manager {
	//public static ExtentTest test;
	public static final Logger log = Logger.getLogger(Excel_Manager.class);
	public static Excel_util reader = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	static  {
		try {

			reader = new Excel_util(Reading_properties.getProperty("Excel_Path"));
		} catch (Exception e) {

			log.error(e.getMessage());
		}
	}
	
	
	public static void toCheckExecutionRequired(String executionRequired) {
		
		// if execution required fieinfold is no
		if (executionRequired.equals("no")) {

			BaseTest.test.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			log.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}

		// if execution required field is empty
		if (executionRequired.equals("")) {

			BaseTest.test.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			log.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}
}
