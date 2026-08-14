package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.SearchPage;
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
		
		   
		 log.info("Creating LandingPage object and clicking on Login link");
		 LandingPage landingpage = new LandingPage(driver); 		 
		 landingpage.LoginLink().click();
		 
		 log.info("Creating LoginPage object and entering user credentials");
		 LoginPage loginPage = new LoginPage(driver);
		 
		 log.info("Creating SearchPage object and adding product to cart");
		 SearchPage searchpage = new SearchPage(driver);
		 
		 log.info("Creating CartPage object to verify cart contents");
		 CartPage cartpage = new CartPage(driver);
		 
log.info("==============Entering user email and password==============");

		 loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));		 
		 loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));		 
		 Thread.sleep(20000); // Wait for 20 seconds to allow the user to complete the CAPTCHA manually
		 loginPage.SignInButton().click();
		 
		 try {
		 boolean successVisible = loginPage.SuccessMessage().isDisplayed();
		 Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
		 
		 } catch (Exception e) {
				log.error("Error occurred during Login Test: " + e.getMessage());
				// Make sure exception causes test failure
				Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}
		 
		 
log.info("==============Searching for product using SKU number==============");

		 landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));		 
		 landingpage.SearchButton().click();			 
			 
		 try {
		 boolean successVisible = searchpage.ProductFoundMessage().isDisplayed();
		 Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
		 
		 } catch (Exception e) {
				log.error("Error occurred during Login Test: " + e.getMessage());
				// Make sure exception causes test failure
				Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			} 
		 
		 
log.info("==============Clicking on Add to Cart button and then Continue Shopping==============");

		 searchpage.AddToCartButton().click();
		 //Thread.sleep(5000);
		 searchpage.ContinueShoppingButton().click();
		 landingpage.CartLink().click();
		 searchpage.ViewCartButton().click();
		 Thread.sleep(5000);
		 
		 try {
			 boolean successVisible = cartpage.CartPageTitle().isDisplayed();
			 Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
			 
			 } catch (Exception e) {
					log.error("Error occurred during Login Test: " + e.getMessage());
					// Make sure exception causes test failure
					Assert.fail("Exception during Login Test: " + e.getMessage(), e);
				} 
			 
		 
	
		 //-------------------------------------------
		 cartpage.ProceedToCheckoutButton().click();
		 
			 
		 
		 
		 
	}
	
	
	
	
	

}
