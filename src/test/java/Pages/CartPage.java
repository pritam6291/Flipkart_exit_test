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

public class CartPage extends BaseTest{
	 WebDriver driver; 
	 Logger log = Logger.getLogger(CartPage.class.getName());
	 
		
		public  CartPage(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[contains(text(),'MOTOROLA Edge 30 Fusion (Solar Gold, 128 GB)')]")
		WebElement ClickProduct;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
		WebElement CartButton;
		@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
	    WebElement Home;
		public void Flipkart() {
			Home.click();
		}
		
		
		
		public void Product_Click() {
			ClickProduct.click();
			log.info("Product selected");
			
		}
		public void AddTocart() throws InterruptedException {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			Set<String> windowhandles = driver.getWindowHandles();

			Iterator<String> iterator = windowhandles.iterator();
			String parentWindow = iterator.next();
			String childWindow = iterator.next();

			driver.switchTo().window(childWindow);
			log.info("switched to the next window");
			jse.executeScript("window.scrollBy(0,40)","");
			CartButton.click();
			log.info("Product added to the cart");
			Thread.sleep(4000);
			String expected_Cart_Title = "Shopping Cart | Flipkart.com";
			String actual_Cart_Title = driver.getTitle();
			System.out.print(actual_Cart_Title);
			Assert.assertEquals(actual_Cart_Title, expected_Cart_Title);
			log.info("Assertion checked successfully");
			driver.close();
			driver.switchTo().window(parentWindow);
			Flipkart();
			Thread.sleep(2000);
			
			
			
		}
		
}
