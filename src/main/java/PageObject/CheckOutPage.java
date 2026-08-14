package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	WebDriver driver;	
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}	
	
	@FindBy(xpath="//h1[normalize-space()='Checkout']")	
	private WebElement checkoutpagetitle;
	
	@FindBy(xpath="//a[normalize-space()='Add new address']")	
	private WebElement addnewaddresslink;
	
	@FindBy(css="#coupon_field")	
	private WebElement couponinputfield;
	
	@FindBy(xpath="//button[normalize-space()='Apply']")	
	private WebElement applycouponbutton;
	
	@FindBy(xpath="label[for='sh_0_13']")	
	private WebElement standardshipping;
	
	@FindBy(xpath="label[for='sh_0_6']")	
	private WebElement expressdelovery;
	
	@FindBy(css="#payments_14")
	private WebElement banktransfer;
	
	@FindBy(css="#payments_34")
	private WebElement creditcard;  
	
	@FindBy(xpath="//label[normalize-space()='Newsletter Subscribers']")
	private WebElement newslettersub;  
	
	@FindBy(xpath="//label[@for='id_accept_terms6a7efefdb4006']")
	private WebElement termcondition;  
	
		
	
	public WebElement CheckOutPageTitle() {
		return checkoutpagetitle;
	}
		
	public WebElement AddNewAddressLink() {
		return addnewaddresslink;
	}
	
	public WebElement CouponInputField() {
		return couponinputfield;
	}
	
	public WebElement ApplyCouponButton() {
		return applycouponbutton;
	}
	
	public WebElement StandardShipping() {
		return standardshipping;
	}
	
	public WebElement ExpressDelovery() {
		return expressdelovery;
	}
	
	public WebElement BankTransfer() {
		return banktransfer;
	}
	
	public WebElement CreditCard() {
		return creditcard;
	}
	
	public WebElement NewsLetterSub() {
		return newslettersub;
	}
	
	public WebElement TermCondition() {
		return termcondition;
	}
	
		
		

}
