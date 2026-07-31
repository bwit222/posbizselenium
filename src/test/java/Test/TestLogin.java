package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class TestLogin extends Base {
	
	Logger log;
	public WebDriver driver; //Screenshot listener needs this driver to be public so that it can access it for taking screenshots on test failure
	
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestContactUsForm.class.getName());
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
	log.info("========== Ending Login Test ==========");
}
	
	
	@Test
	public void LoginTestCorrectDetail() {
		log.info("========== Starting Login Test ==========");
		
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		System.out.println("Git hub update for testing");
		
		
		
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			log.info("Entering Password: " + prop.getProperty("c_password"));
			loginPage.Password().sendKeys(prop.getProperty("c_password"));
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = loginPage.SuccessMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Success message is not displayed - login may have failed");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void LoginTestWrongDetail() {
		log.info("========== Starting Login Test with Incorrect Details ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			log.info("Entering Password: " + prop.getProperty("w_password"));
			loginPage.Password().sendKeys(prop.getProperty("w_password"));
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is not displayed - login may have unexpectedly succeeded");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Incorrect Details: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Incorrect Details: " + e.getMessage(), e);
		}
	}
	
	public void LoginTestEmptyDetail() {
		log.info("========== Starting Login Test with Empty Details ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Clicking on Sign In Button without entering any details");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is not displayed - login may have unexpectedly succeeded");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Empty Details: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Empty Details: " + e.getMessage(), e);
		}
	}
		
}


