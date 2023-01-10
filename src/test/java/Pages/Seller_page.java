package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Seller_page extends BaseTest{
	WebDriver driver; 
	Logger log = Logger.getLogger(Seller_page.class.getName());
	 
	
	public  Seller_page(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[4]/a/span")
	WebElement Seller;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[2]/div[1]/button/span")
	WebElement Start_selling;
	@FindBy(name="mobileNumber")
	WebElement Mobile_no;
	@FindBy(name="email")
	WebElement Email;
	@FindBy(name="gst")
	WebElement GST;
	
	public void Seller_method() throws InterruptedException {
		Seller.click();
		log.info("Become a seller option clicked");;
		Start_selling.click();
		log.info("Start selling clicked");
		Mobile_no.sendKeys("6587654527");
		log.info("Mobile number entered");
		Email.sendKeys("prit7847@hd");
		log.info("Email entered");
		GST.sendKeys("646374");
		log.info("GST entered");
		String expected_Seller_Title ="Seller Dashboard";
		String actual_Seller_Title = driver.getTitle();
		System.out.print(actual_Seller_Title);
		Assert.assertEquals(actual_Seller_Title, expected_Seller_Title);
		Thread.sleep(3000);
		log.info("Assertion checked");
	}

}
