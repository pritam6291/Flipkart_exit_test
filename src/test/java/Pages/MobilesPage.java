package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseTest;

public class MobilesPage extends BaseTest{
	WebDriver driver; 
	Logger log = Logger.getLogger(MobilesPage.class.getName());
	 
	
	public  MobilesPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[contains(text(),'Mobiles')]")
	WebElement Mobiles;
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[2]/div[1]/div[1]/section[3]/div[2]/div[1]/div[2]/div[1]/label[1]/div[1]")
	WebElement Realme;
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[2]/div[1]/div[4]/div[1]/label[1]/div[1]")
	WebElement Poco;
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]")
	WebElement Rating;
	
	
	public void Select_Filters() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		Mobiles.click();
		log.info("Clicked on mobile");
		jse.executeScript("window.scrollBy(0,400)","");
		
		Realme.click();
		log.info("Realme checkbox clicked");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,400)","");
		Poco.click();
		log.info("POCO checkbox clicked");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,400)","");
		Rating.click();
		log.info("Rating checkbox clicked");
		Thread.sleep(5000);
		
	}
	
	

}
