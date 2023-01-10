package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseTest;

public class Customer_care_Page extends BaseTest {
	 WebDriver driver;
	 Logger log = Logger.getLogger(Customer_care_Page.class.getName());
	 
		
		public  Customer_care_Page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
			
			
			
			
		}
		@FindBy(xpath="//a[contains(text(),'Contact Us')]")
		WebElement Contact_us;
		@FindBy(xpath="//div[contains(text(),'24x7 Customer Care')]")
		WebElement Customer_care;
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/span[1]")
		WebElement Others;
		@FindBy(xpath="//span[contains(text(),'Postal Address')]")
		WebElement Postal_address;
		
		public void Contact() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page scrolled successfully");
			Contact_us.click();
			log.info("Contact us footer clicked");
			Thread.sleep(4000);
			
		}
		public void cust_care() throws InterruptedException {
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page scrolled successfully");
			Others.click();
			log.info("Others clicked");
			Postal_address.click();
			log.info("Postal address clicked");
			Thread.sleep(4000);
			
			
		}


}
