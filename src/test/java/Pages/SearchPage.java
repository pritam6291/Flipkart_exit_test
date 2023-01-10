package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class SearchPage extends BaseTest{
	
	     WebDriver driver; 
	     Logger log = Logger.getLogger(SearchPage.class.getName());
	     
	 	 
		public  SearchPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
			
		}
		@FindBy(xpath="//input[@name='q']")
		WebElement SrchTxt;
		@FindBy(xpath="//input[@name='q']")
		WebElement SrchBtn;
		
		public void Search_Text(String s) {
			SrchTxt.sendKeys(s);
			log.info("Product entered");
		}
		public void Search_button() {
			SrchTxt.sendKeys(Keys.RETURN);
			log.info("Product searched");
			
		}
		
		public void Verify_Title() {
			String expectedTitle = "Motorola Edge 30 Fusion- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
			String actualTitle = driver.getTitle();
			System.out.print(actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			log.info("Assertion checked successfully");
			
		}

}
