package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import Excel_configuration.Excel_Manager;
import ExtentReportManager.ExtentReportGenerator;

import Property.Reading_properties;
//import ExtentReportManager.ExtentReportGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Excel_Manager {
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	Logger log = Logger.getLogger(BaseTest.class.getName());

	
	@BeforeSuite
	public void launchBrowser() throws IOException, InterruptedException {
		String browserName = Reading_properties.getProperty("browser");
		
		if (Reading_properties.getProperty("mode").equalsIgnoreCase("non-headless")) {

			if (browserName.equals("chrome")) {
				extent = ExtentReportGenerator.getInstance("ExtentReport/ExtentReports.html");
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			}

			else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}

			else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


			}

			else {

				System.out.println("No browser value is given");

			}
		}

		
		if (Reading_properties.getProperty("mode").equalsIgnoreCase("headless")) {

			if (browserName.equals("chrome")) {
				extent = ExtentReportGenerator.getInstance("ExtentReport/ExtentReports.html");
				WebDriverManager.chromedriver().setup();
			
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1920,1080");
				driver = new ChromeDriver(options);
				 

				

			}

			else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions options=new EdgeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1920,1080");
				driver=new EdgeDriver(options);
				
			}

			else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
					FirefoxOptions options=new FirefoxOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1920,1080");
					driver=new FirefoxDriver(options);
				

			}

			else {

				System.out.println("No browser value is given");

			}
		}

	}

	private void open() {
		// TODO Auto-generated method stub

	}

	@BeforeMethod

	public void launchurl(Method method) throws IOException {
		

		test = extent.startTest(method.getName());

		driver.get(Reading_properties.getProperty("url"));

	}

	@AfterMethod

	public void CloseBrowser(ITestResult result) throws IOException {

		System.out.println(result.getMethod().getMethodName());
		if (result.getStatus() == ITestResult.FAILURE)

			test.log(LogStatus.FAIL, result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			test.log(LogStatus.SKIP, result.getThrowable());

		else

			test.log(LogStatus.PASS, "Test passes");
		if (result.getStatus() == ITestResult.FAILURE) {

			String imagePath = ScreenShot_page.captureScreenshot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(imagePath));

		}

		else {

			if (result.getStatus() == ITestResult.SUCCESS) {

				test.log(LogStatus.PASS, "Test Case Pass");
			}
		}
		//driver.quit();

	}

	@AfterSuite

	public void Close() {

		extent.flush();
		driver.quit();

	}
}