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

public class Flipkart_stories_page extends BaseTest {
	WebDriver driver; 
	Logger log = Logger.getLogger(Flipkart_stories_page.class.getName());
	 
	
	public  Flipkart_stories_page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//a[contains(text(),'Flipkart Stories')]")
	WebElement Flipkart_stories;
	@FindBy(xpath="//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement image;
	
	@FindBy(xpath="//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/span[1]")
	WebElement Watch;
	@FindBy(xpath="//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/span[1]")
	WebElement View_all;
	@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
    WebElement Home;
	public void Flipkart() {
		Home.click();
	}
	
	public void stories() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)","");
		log.info("Page scrolled successfully");
		Flipkart_stories.click();
		log.info("Flipkart stories footer clicked");
		Actions action = new Actions(driver);
		action.moveToElement(image).perform();
		log.info("Mouse hover performed on image");
		Thread.sleep(4000);
		jse.executeScript("window.scrollBy(0,400)","");
		log.info("Page scrollled successfully");
		Watch.click();
		log.info("Video clicked successfully");
		Thread.sleep(4000);
		View_all.click();
		log.info("View all clicked");
		Thread.sleep(5000);
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> iterator = windowhandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();

		driver.switchTo().window(childWindow);
		log.info("Switched to another window");
		String youtube_title="Experience #SafeCommerce with Flipkart - YouTube";
		String youtube_Actual=driver.getTitle();
		System.out.print(youtube_Actual);
		Assert.assertEquals(youtube_Actual, youtube_title);
		log.info("Assertion checked successfully");
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.navigate().back();
		Thread.sleep(2000);
		
		
		
	}

}
