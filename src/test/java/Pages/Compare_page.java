package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v105.input.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Common.BaseTest;
import Property.Reading_properties;

public class Compare_page extends BaseTest{
	 WebDriver driver;
	 Logger log = Logger.getLogger(Compare_page.class.getName());
	 
		
		public  Compare_page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]/div[1]/label[1]/span[1]")
		WebElement Compare_checkbox;
		@FindBy(xpath="//span[contains(text(),'COMPARE')]")
		WebElement Compare_btn;
		@FindBy(xpath="//input[@name='q']")
		WebElement SrchTxt;
		@FindBy(xpath="//input[@name='q']")
		WebElement SrchBtn;
		@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[2]/div/span/label/div")
		WebElement Compare_checkbox_2;
		@FindBy(xpath="//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[1]/div[3]/div[1]/div/span[1]/label/div")
		WebElement Show_difference;
		

		
		public void Compare_now() throws InterruptedException {
			Compare_checkbox.click();
			log.info("add to compare checkbox clicked");
			Compare_btn.click();
			log.info("Compare button clicked");
			SrchTxt.sendKeys(Reading_properties.getProperty("product2"));
			
			SrchTxt.sendKeys(Keys.RETURN);
			log.info("Product searched");
			Compare_checkbox_2.click();
			log.info("Add to compare checkbox clicked");
			Compare_btn.click();
			log.info("Compare button clicked");
			Show_difference.click();
			log.info("Show only difference checkbox clicked");
			String expected_Compare_Title = "Nothing Phone 1- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
			String actual_Compare_Title = driver.getTitle();
			System.out.print(actual_Compare_Title);
			Assert.assertEquals(actual_Compare_Title, expected_Compare_Title);
			Thread.sleep(3000);
			log.info("Assertion checked successfully");
		}

}
