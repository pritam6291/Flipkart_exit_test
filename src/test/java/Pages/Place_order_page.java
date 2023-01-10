package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Place_order_page extends BaseTest {

	WebDriver driver;
	Logger log = Logger.getLogger(Place_order_page.class.getName());
	public Place_order_page(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div._1Er18h div._6t1WkM._3HqJxg div._1YokD2._2GoDe3.col-12-12 div._1YokD2._3Mn1Gg:nth-child(1) div._1YokD2._3Mn1Gg.col-12-12 div._1AtVbE.col-12-12:nth-child(3) div.zab8Yh._10k93p div.nZz3kj._1hNI6F div._1uc2IE div._3dY_ZR > button._23FHuj:nth-child(3)")
	WebElement add_more;
	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement Place_order;

	public void Order() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		log.info("Page scrolled");
		add_more.click();
		log.info("Increased the quantity");
		Place_order.click();
		log.info("Order placed");
		String expected_payment_Title = "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		String actual_payment_Title = driver.getTitle();
		System.out.print(actual_payment_Title);
		Assert.assertEquals(actual_payment_Title, expected_payment_Title);
		log.info("Assertion checked successfully");
	}

}
