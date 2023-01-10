package Pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common.BaseTest;

public class FooterPage extends BaseTest{
	 WebDriver driver; 
	 Logger log = Logger.getLogger(FooterPage.class.getName());
	 
		
		public  FooterPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
				
		}
		@FindBy(xpath="//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[4]/a[1]")
		WebElement Facebook;
		@FindBy(xpath="//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[4]/a[2]")
		WebElement Twitter;
		@FindBy(xpath="//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[4]/a[3]")
		WebElement Youtube;
		
		public void FooterPage() throws InterruptedException {
			String fb_title="Flipkart - Home | Facebook";
			String twitter_title="Flipkart (@Flipkart) / Twitter";
			String youtube_title="Flipkart - YouTube";
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page Scrolled Successfully");
			Facebook.click();
			log.info("Facebook footer clicked");
			Thread.sleep(5000);
			String fb_Actual=driver.getTitle();
			System.out.print(fb_Actual);
			Assert.assertEquals(fb_Actual, fb_title);
			log.info("Assertion Checked successfully");
			Thread.sleep(5000);
			driver.navigate().back();
			log.info("Navigate back to Flipkart page");
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,400)","");
			log.info("Page Scrolled Successfully");
			Twitter.click();
			log.info("Twitter footer clicked");
			Thread.sleep(5000);
			String twitter_Actual=driver.getTitle();
			System.out.print(twitter_Actual);
			Assert.assertEquals(twitter_Actual, twitter_title);
			log.info("Assertion Checked successfully");
			driver.navigate().back();
			log.info("Navigate back to Flipkart page");
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,450)","");
			Youtube.click();
			log.info("Youtube footer clicked");
			Thread.sleep(5000);
			
		
		}
		

}
