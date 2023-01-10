package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Common.BaseTest;

public class TravelPage extends BaseTest {
	WebDriver driver;
	Logger log = Logger.getLogger(TravelPage.class.getName());

	public TravelPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//div[contains(text(),'Travel')]")
	WebElement Travel_Option;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[2]/div[1]\r\n"
			+ "")
	WebElement Round_trip;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement From_city;
	

	@FindBy(xpath = "//div[contains(text(),'CCU')]")
	WebElement Select_From_city;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	WebElement To_city;
	

	@FindBy(xpath = "//div[contains(text(),'BLR')]")
	WebElement Select_To_city;

	@FindBy(name = "0-dateto")
	WebElement ReturnDate;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div/table[2]/tbody/tr[2]/td[2]/div/button")
	WebElement date;

	@FindBy(xpath = "//span[contains(text(),'SEARCH')]")
	WebElement Search;



	public void Travel_now() throws InterruptedException {

		Travel_Option.click();
		log.info("Travel option Clicked");
		Round_trip.click();
		log.info("Round Trip Selected successfully");
		Thread.sleep(2000);
	}


	public void From_city(String From) throws InterruptedException {

		From_city.sendKeys(From);
		Select_From_city.click();
		log.info("From City entered successfully");
		
	}

	public void To_city(String TO) throws InterruptedException {

		To_city.sendKeys(TO);
		Thread.sleep(2000);
		Select_To_city.click();
		log.info("To City entered successfully");
		
	}

	public void Return_Date() throws InterruptedException {

		ReturnDate.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		date.click();
		log.info("Return Date selected");
	}

	public void Search_Flight() throws InterruptedException {
		Search.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		log.info("Flight Kolkata To Mumbai searched Successfully");
	}

}
