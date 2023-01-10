package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.BaseTest;

public class LoginPage extends BaseTest{
     WebDriver driver; 
     Logger log = Logger.getLogger(LoginPage.class.getName());
	
	public  LoginPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a")
	WebElement LoginBtn;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement Phone_No;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")
	WebElement Request_Otp_btn;
	
	
	public void login_btn() {
		LoginBtn.click();
		log.info("Login button clicked");
	
	}
	public void Phn(String phoneno) {
		Phone_No.sendKeys(phoneno);
		log.info("Phone number entered");
	
	}
	public void OTP_btn() {
		Request_Otp_btn.click();
		log.info("Request OTP clicked");
	
	}
	
	

}
