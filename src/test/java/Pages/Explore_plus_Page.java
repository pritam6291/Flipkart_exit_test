package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.BaseTest;

public class Explore_plus_Page extends BaseTest{
	 WebDriver driver; 
	 Logger log = Logger.getLogger(Explore_plus_Page.class.getName());
	 
		
		public  Explore_plus_Page(WebDriver d) {
			driver=d;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="/html/body/div[2]/div/div/button")
		WebElement cross_btn;
		@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[2]")
		WebElement Explore_Plus;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/a[1]/div[1]/div[1]/img[2]")
		WebElement Reward_store;
		@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]/div[1]/div[1]/img[2]")
		WebElement Claimed_Reward;
		
		public void cancel() {
			cross_btn.click();
		}
		
		public void reward_store() throws InterruptedException {
			Explore_Plus.click();
			log.info("Explore plus clicked");
			Thread.sleep(4000);
			Reward_store.click();
			log.info("Reward store button clicked");
			Thread.sleep(4000);
			Claimed_Reward.click();
			log.info("Claimed reward clicked");
			Thread.sleep(4000);
			String expected_Reward_Title = "Claimed Offers – Check the list of Offers claimed";
			String actual_Reward_Title = driver.getTitle();
			System.out.print(actual_Reward_Title);
			Assert.assertEquals(actual_Reward_Title, expected_Reward_Title);
			log.info("Assertion checked successfully");
			
		}

}
