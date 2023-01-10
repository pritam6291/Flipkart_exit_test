package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class GroceryPage extends BaseTest {
	 WebDriver driver; 
	 Logger log = Logger.getLogger(GroceryPage.class.getName());
	 
		
		public  GroceryPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")
		WebElement grocery;
		@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[1]/form/input")
		WebElement pincode;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
		WebElement addItemBtn;
		@FindBy(xpath="//span[contains(text(),'Cart')]")
		WebElement CartBtn;
		
		public void Grocery_click() {
			grocery.click();
			log.info("Grocery button clicked");
		}
		
		public void enter_pin(String s) {
			pincode.sendKeys(s);
			log.info("Pin entered successfully");
		}
		public void Pin() throws InterruptedException {
			pincode.sendKeys(Keys.RETURN);
			Thread.sleep(4000);
			
		}
		public void Add_Item() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,40)","");
			addItemBtn.click();
			log.info("Item added");
			Thread.sleep(4000);
		}
		public void Check_cart() throws InterruptedException {
			CartBtn.click();
			log.info("Cart checked successfully");
			Thread.sleep(4000);
			String Expected_cart_title="Shopping Cart | Flipkart.com";
		    String Actual_cart_title=driver.getTitle();
			System.out.print(Actual_cart_title);
			Assert.assertEquals(Actual_cart_title, Expected_cart_title);
			log.info("Assertion checked successfully");
		}

}
