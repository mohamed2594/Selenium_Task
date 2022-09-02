package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AuthPage extends Basepage {

	public AuthPage(WebDriver driver) {
		super(driver);	
		}
	
	public static String Msg = null;
	private By RegisterEmailTab = By.id("email_create");
	private By CreateAccountBtn = By.id("SubmitCreate");
	private By LoginEmailTab = By.id("email");
	private By LoginPasswordTab = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
//	private By AuthFail = By.xpath("//li[normalize-space()='Authentication failed.']");
//	private By PasswdMissed = By.xpath("//li[normalize-space()='Password is required.']");
//	private By LoginEmailMissed = By.xpath("//li[normalize-space()='An email address required.']");
//	private By LoginEmailInvalid = By.xpath("//li[normalize-space()='Invalid email address.']");
	public By LoginErrorMsg = By.xpath("//li[normalize-space()='" + Msg + ".']");
	private By RegEmailInvalid = By.xpath("//li[normalize-space()='Invalid email address.']");
	private By RegEmailduplicat = By.xpath("//li[contains(text(),'An account using this email address has already be')]");
	public String AuthURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	
	public void EnterRegisterEmail (String email) {
		waitUntilElementIsVisabile(RegisterEmailTab);
		setText(RegisterEmailTab, email);
		click(CreateAccountBtn);
	}
	
	public void EnterLoginEmail (String email) {
		waitUntilElementIsVisabile(LoginEmailTab);
		setText(LoginEmailTab, email);
	}
	
	public void EnterLoginPassword (String password) {
		waitUntilElementIsVisabile(LoginPasswordTab);
		setText(LoginPasswordTab, password);
	}
	
	public void ClickOnSignInBtn () {
		waitUntilElementIsVisabile(loginBtn);
		click(loginBtn);
	}
	
	public String Get_AuthPage_URL () {
		waitUntilElementIsVisabile(loginBtn);
		return driver.getCurrentUrl();
	}
	
//	public Boolean Is_Missing_Login_Email_Error_Msg_Displayed () {
//		return CheckElementVisiblity(LoginEmailMissed);
//	}
//	
//	public Boolean Is_Missing_Login_Password_Error_Msg_Displayed () {
//		return CheckElementVisiblity(PasswdMissed);
//	}
//	
//	public Boolean Is_Invalid_Login_Email_Error_Msg_Displayed () {
//		return CheckElementVisiblity(LoginEmailInvalid);
//	}
//	
//	public Boolean Is_Authentication_Failed_Msg_Displayed () {
//		return CheckElementVisiblity(AuthFail);
//	}
	
	public Boolean Is_Error_Msg_Displayed () {
		return CheckElementVisiblity(LoginErrorMsg);
	}
	
	public Boolean Is_Invalid_Register_Email_Error_Msg_Displayed () {
		return CheckElementVisiblity(RegEmailInvalid);
	}
	
	public Boolean Is_Duplicate_Register_Email_Error_Msg_Displayed () {
		return CheckElementVisiblity(RegEmailduplicat);
	}
	
}
