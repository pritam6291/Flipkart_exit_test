package Pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;
import Property.Reading_properties;

public class Gift_Cards_page  extends BaseTest{
	 WebDriver driver; 
	 Logger log = Logger.getLogger(Gift_Cards_page.class.getName());
	 
		
		public  Gift_Cards_page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
			
			
			
			
		}
		@FindBy(xpath="//span[contains(text(),'Gift Cards')]")
		WebElement giftCard;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[6]/div[1]/div[3]/a[1]/div[1]/div[1]/img[2]")
		WebElement BirthDay;
		@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div[1]/div/a[1]/div[1]/div/div/img")
		WebElement Card_select;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/form[1]/button[1]")
		WebElement Buy_Now;
		@FindBy(name="recipient_name")
		WebElement Recipient_name;
		@FindBy(name="email")
		WebElement email;
		@FindBy(name="confirm_email")
		WebElement confirm_email;
		@FindBy(name="message")
		WebElement Message;
		@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
	    WebElement Home;
		public void Flipkart() {
			Home.click();
		}


		public void GiftCardFunction() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page scrolled successfully");
			giftCard.click();
			log.info("Gift card button clicked");
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page scrolled successfully");
			BirthDay.click();
			log.info("Birthday option clicked");
			Thread.sleep(5000);
			Card_select.click();
			log.info("Digital card selected");
			Thread.sleep(5000);
		}
		public void Buy_Card() throws InterruptedException {
			Set<String> windowhandles = driver.getWindowHandles();

			Iterator<String> iterator = windowhandles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();

			driver.switchTo().window(childWindow);
			log.info("Window switched successfully");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page scrolled");
			Buy_Now.click();
			log.info("Buy now button clicked");
			Thread.sleep(5000);
			
		}
		public void fill_details() throws InterruptedException {
			Set<String> windowhandles = driver.getWindowHandles();

			
			Iterator<String> iterator = windowhandles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();
			Recipient_name.sendKeys(Reading_properties.getProperty("Name"));
			log.info("Name entered");
			email.sendKeys(Reading_properties.getProperty("Email"));
			log.info("Email entered");
			confirm_email.sendKeys(Reading_properties.getProperty("Email"));
			log.info("Email entered");
			Message.sendKeys(Reading_properties.getProperty("Message"));
			log.info("Message entered");
			Thread.sleep(5000);
			String expected_GiftCard_Title = "Flipkart Digital Gift Card Price in India - Buy Flipkart Digital Gift Card online at Flipkart.com";
			String actual_GiftCard_Title = driver.getTitle();
			System.out.print(actual_GiftCard_Title);
			Assert.assertEquals(actual_GiftCard_Title, expected_GiftCard_Title);
			log.info("Assertion checked");
			driver.close();
			driver.switchTo().window(parentWindow);
			Flipkart();
			Thread.sleep(2000);
		}

}
