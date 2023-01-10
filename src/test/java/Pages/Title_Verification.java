package Pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import Common.BaseTest;

public class Title_Verification extends BaseTest{
	Logger log = Logger.getLogger(Title_Verification.class.getName());
	
	
	public void VerifyIt() {
		
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("Assertion checked successfully");
		
	}

}
