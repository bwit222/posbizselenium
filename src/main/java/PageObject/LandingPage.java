package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Contact Us']")
	private WebElement contactuslink;
	
	@FindBy(xpath="//a[@href='https://www.poscentral.biz/index.php?dispatch=auth.login_form']")
	private WebElement loginlink;
	
	public WebElement ContactUsLink() {
		return contactuslink;
	}
	
	public WebElement LoginLink() {
		return loginlink;
	}

}
