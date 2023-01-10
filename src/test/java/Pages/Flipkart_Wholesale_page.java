package Pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseTest;

public class Flipkart_Wholesale_page extends BaseTest{
	 WebDriver driver; 
	 Logger log = Logger.getLogger(Flipkart_Wholesale_page.class.getName());
	 
		
		public  Flipkart_Wholesale_page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);	
		}
		@FindBy(xpath="//a[contains(text(),'Flipkart Wholesale')]")
		WebElement Wholesale;
		@FindBy(xpath="//a[contains(text(),'Know More')]")
		WebElement Know_more;
		@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
		WebElement Name;
		@FindBy(xpath="//*[@id=\"mG61Hd\"]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input")
		WebElement Business_Name;
		@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
	    WebElement Home;
		public void Flipkart() {
			Home.click();
		}
		
		public void wholesale() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,40)","");
			log.info("Page scrolled successfully");
			Wholesale.click();
			log.info("Wholesale clicked");
			Set<String> windowhandles = driver.getWindowHandles();

			Iterator<String> iterator = windowhandles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			driver.switchTo().window(childWindow);
			log.info("Switched to another window");
			Know_more.click();
			log.info("Know more clicked");
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(parentWindow);
			Flipkart();
			Thread.sleep(2000);
			
		}
		
}
