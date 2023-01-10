package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Mouse_hover_Page extends BaseTest {
	WebDriver driver; 
	Logger log = Logger.getLogger(Mouse_hover_Page.class.getName());
	 
	
	public  Mouse_hover_Page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]/div[2]/div[1]/div[1]")
	WebElement FashionBtn;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a/div[2]/div[2]/div[2]/div/div/div[1]/a[1]")
	WebElement MenTopWear;
	
	public void hoverIt() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(FashionBtn).perform();
		log.info("Mouse hover performed on Fashion option");
		Thread.sleep(4000);
		}
	public void ClickMen() throws InterruptedException {
		
		MenTopWear.click();
		log.info("Men Topwear clicked");
		Thread.sleep(4000);
		String expected_Tab_Title = "Topwear - Buy Topwear For Men, Women & Kids Online at Best Prices In India | Flipkart.com";
		String actual_Tab_Title = driver.getTitle();
		System.out.print(actual_Tab_Title);
		Assert.assertEquals(actual_Tab_Title, expected_Tab_Title);
		log.info("Assertion checked successfully");
	}

}
