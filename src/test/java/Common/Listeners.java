//package Common;
//import Utilities.Testutils;
//import java.io.IOException;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import Utilities.Testutils;
//
//public class Listeners extends Testutils implements ITestListener{
//
//	public void onTestStart(ITestResult result) {
//		System.out.println("Test case is starting");
//	}
//
//	public void onTestSuccess(ITestResult result) {
//		
//		System.out.println("Test case passed");
//	}
//
//	public void onTestFailure(ITestResult result) {
//		
//		System.out.println("Test case failed - Screenshot captured");
//		//ScreenShots.takeScreenShot(driver,result.getName());
//		
//		}
//		//System.setProperty("org.uncommons.reportng.escape-output","false");
//	
//	public void onTestSkipped(ITestResult result) {
//		
//	}
//
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		
//	}
//
//	public void onTestFailedWithTimeout(ITestResult result) {
//		
//	}
//
//	public void onStart(ITestContext context) {
//		
//	}
//
//	public void onFinish(ITestContext context) {
//		
//	}
//
//}
