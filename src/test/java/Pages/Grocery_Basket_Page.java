package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Grocery_Basket_Page extends BaseTest {
	
		 WebDriver driver; 
		 Logger log = Logger.getLogger(Grocery_Basket_Page.class.getName());
		 
			
			public  Grocery_Basket_Page(WebDriver d) {
				driver=d;
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")
			WebElement staples;
			@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/a/div[2]/div[2]/div[2]/div/div/div[1]/a[3]")
			WebElement Atta;
			@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[4]/button[2]/span")
			WebElement AddFirst;
			@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[4]/button[2]/span")
			WebElement AddSecond;
			@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/span[1]")
			WebElement Basket;
			public void Hover_staples() throws InterruptedException {
				Actions action = new Actions(driver);
				action.moveToElement(staples).perform();
				log.info("Mouse hover performed on staples");
				Thread.sleep(4000);
			}
			public void Item_Add() {
				Atta.click();
				log.info("Atta option clicked");
				AddFirst.click();
				log.info("First product added");
				AddSecond.click();
				log.info("Second product added");
			}
			public void Check_Basket() throws InterruptedException {
				Basket.click();
				log.info("Clicked on basket button");
				Thread.sleep(2000);
				String Expected_grocery_title="Atta - Buy Atta 1Kg MRP Rs.55 Only at Flipkart.com";
			    String Actual_grocery_title=driver.getTitle();
				System.out.print(Actual_grocery_title);
				Assert.assertEquals(Actual_grocery_title, Expected_grocery_title);
				log.info("Assertion checked successfully");
				
						
			}
			

}

