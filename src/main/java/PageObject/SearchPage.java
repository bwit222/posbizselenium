package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'No products found matching the search criteria')]")
	private WebElement productnotfoundmessage;
	
	
	
	public WebElement ProductNotFoundMessage() {
		return productnotfoundmessage;
	}
	
	
	
}
