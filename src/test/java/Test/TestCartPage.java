package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class TestCartPage extends Base {
	
	Logger log;
	public WebDriver driver;
		
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestCartPage.class.getName());
		log.info("========== Starting Test Setup ==========");
		
		driver = intializeDriver();
		log.info("Browser got launched successfully");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the application URL: " + prop.getProperty("url"));
		log.info("========== Test Setup Completed ==========");
	}
	
	@AfterMethod
	public void closer() {
		log.info("========== Starting Test Cleanup ==========");
		try {
			driver.close();
			log.info("Browser closed successfully");
		} catch (Exception e) {
			log.error("Error closing browser: " + e.getMessage(), e);
		}
	log.info("========== Ending Cart Page Test ==========");
}
	
	
	@Test	
	public void CartPage() throws InterruptedException {
		   log.info("========== Starting Cart Page Test ==========");
		
		   
		   
		 LandingPage landingpage = new LandingPage(driver); 
		 
		 landingpage.LoginLink().click();
		 
		 LoginPage loginpage = new LoginPage(driver);
		 
		 loginpage.UserEmail().sendKeys(prop.getProperty("useremail"));
		 
		 loginpage.Password().sendKeys(prop.getProperty("c_password"));
		 
		 Thread.sleep(20000); // Wait for 20 seconds to allow the user to complete the CAPTCHA manually
		
		loginpage.SignInButton().click();
		 
		 
		 
		 
		 
		
	}
	
	
	
	

}
