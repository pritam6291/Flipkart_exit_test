package Pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Careers_Page extends BaseTest {
	WebDriver driver;
	Logger log = Logger.getLogger(Careers_Page.class.getName());

	public Careers_Page(WebDriver d) {
		driver = d;
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Careers')]")
	WebElement careers;
	@FindBy(xpath = "//header/nav[@id='main-navbar']/div[1]/div[2]/ul[1]/li[3]/a[1]")
	WebElement jobs;
	@FindBy(xpath = "//header/nav[@id='main-navbar']/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	WebElement job_india;
	@FindBy(xpath = "//input[@id='Location_bangalore,karnataka']")
	WebElement location;
	@FindBy(xpath = "//input[@id='Function_Technology']")
	WebElement function;
	@FindBy(xpath = "//*[@id=\"current-list\"]/list/section/div/div/div/div[8]/div/div[1]/h3")
	WebElement Senior_systms_engineer;
	@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
    WebElement Home;
	public void Flipkart() {
		Home.click();
	}
	
	public void Careers_footer() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)","");
		log.info("Page scrolled");
		careers.click();
		log.info("Flipkart careers footer clicked");
		Thread.sleep(5000);
	}

	public void hoverIt() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(jobs).perform();
		log.info("Mouse hovered on the job tab");
		Thread.sleep(4000);
	}

	public void Job_places() throws InterruptedException {

		job_india.click();
		log.info("Job@india clicked successfully");
		Thread.sleep(4000);
	}
	public void filters() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,400)","");
		location.click();
		log.info("Location filter clicked successfully");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,400)","");
		function.click();
		log.info("Function filter clicked successfully");
		Thread.sleep(2000);
		

	}
	public void choose_job() throws InterruptedException {
		Senior_systms_engineer.click();
		log.info("Job role selected successfully");
		Thread.sleep(2000);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(4000);
		String expected_Job_Title = "Senior Systems Engineer Bangalore,Karnataka Windows Server Operations and Administration@www.flipkartcareers.com";
		String actual_Job_Title = driver.getTitle();
		System.out.print(actual_Job_Title);
		Assert.assertEquals(actual_Job_Title, expected_Job_Title);
		log.info("Assertion checked successfully");
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.navigate().back();
		Thread.sleep(2000);
		
		
	}

}
