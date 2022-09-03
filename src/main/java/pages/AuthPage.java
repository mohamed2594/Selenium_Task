package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AuthPage extends Basepage {

	public AuthPage(WebDriver driver) {
		super(driver);	
		}
	
	public static String LoginErrorMessage = null; // the error message appeared while login failure
	private By PageTitle = By.className("page-heading");
	private By RegisterEmailTab = By.id("email_create");
	private By CreateAccountBtn = By.id("SubmitCreate");
	private By LoginEmailTab = By.id("email");
	private By LoginPasswordTab = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
	public By LoginErrorMsg = By.xpath("//li[normalize-space()='" + LoginErrorMessage + ".']"); // generic locator for login failure message
	private By RegEmailInvalid = By.xpath("//li[normalize-space()='Invalid email address.']");
	private By RegEmailduplicat = By.xpath("//li[contains(text(),'An account using this email address has already be')]");
	private String AuthURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private String AuthPageTitle = "AUTHENTICATION";
	
	public Boolean CheckNavigationToAuthPage () {
		
		waitUntilURLToBe(AuthURL);
		return CheckElementText(PageTitle, AuthPageTitle);
	}
	
	public void EnterRegisterEmail (String email) {
		
		waitUntilElementIsVisabile(RegisterEmailTab);
		setText(RegisterEmailTab, email);
		click(CreateAccountBtn);
	}
	
	public void SignIn (String email, String password) {
		
		waitUntilElementIsVisabile(loginBtn);
		setText(LoginEmailTab, email);
		setText(LoginPasswordTab, password);
		click(loginBtn);
	}
	
	public Boolean CheckLoginErrorMsgIsDisplayed () {
		
		return CheckElementVisiblity(LoginErrorMsg);
	}
	
	public Boolean CheckInvalidRegisterEmailErrorMsgIsDisplayed () {
		
		return CheckElementVisiblity(RegEmailInvalid);
	}
	
	public Boolean CheckDuplicateRegisterEmailErrorMsgIsDisplayed () {
		
		return CheckElementVisiblity(RegEmailduplicat);
	}
	
}
