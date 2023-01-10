package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Advertise_page extends BaseTest{
	WebDriver driver; 
	Logger log = Logger.getLogger(Advertise_page.class.getName());
	
	 
	
	public  Advertise_page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
		
		
		
		
	}
	@FindBy(xpath="//span[contains(text(),'Advertise')]")
	WebElement Advertisement;
	@FindBy(xpath="//span[contains(text(),'How to Get Started')]")
	WebElement Video;
	@FindBy(xpath="//span[contains(text(),'×')]")
	WebElement Cross_btn;
	
	public void Advertisement_Function() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)","");
		Advertisement.click();
		log.info("Advertisement footer clicked");
		Thread.sleep(5000);
		Video.click();
		log.info("Video link clicked");
		Thread.sleep(5000);
		Cross_btn.click();
		log.info("Cross button clicked");
		Thread.sleep(5000);
		String expected_Advertisement_Title = "Flipkart Brand Health, Brand Pulse, Flipkart Insights, Flipkart Advertising, Commerce Advertising Platform";
		String actual_Advertisement_Title = driver.getTitle();
		System.out.print(actual_Advertisement_Title);
		Assert.assertEquals(actual_Advertisement_Title, expected_Advertisement_Title);
		log.info("Assertion checked successfully");
		
	}

}
