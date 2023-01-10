

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log_Generator_class {
public static void main(String[] args) {
	
		
		
		Logger log = Logger.getLogger(Log_Generator_class.class);
		
		WebDriver driver=new ChromeDriver();
	  
      
     String title = driver.getTitle();
     System.out.println("title value is"+ title);
     log.info("title value is"+ title);
     
     
     if(title.equals("Google")) {
    	 
    	 System.out.println("correct title is google");
    	 log.info("correct title is google and test case is passed");
     }else {
    	 
    	 System.out.println("correct title is not google");
    	 log.info("correct title is google and test case is Failed");
     }

}
}
