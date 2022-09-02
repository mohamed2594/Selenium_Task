package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage extends Basepage{

	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}
	
	private By CreateAccountTitleLocator = By.className("page-heading");
	private By MaleGender = By.id("id_gender1");
	private By FemaleGender = By.id("id_gender2");
	private By FirstNameTab = By.id("customer_firstname");
	private By LastNameTab = By.id("customer_lastname");
	private By RegPasswdTab = By.id("passwd");
	private By DaysList = By.id("days");
	private By MonthsList = By.id("months");
	private By YearsList = By.id("years");
	private By CompanyTab = By.id("company");
	private By AddressTab = By.id("address1");
	private By CityTab = By.id("city");
	private By StateList = By.id("id_state");
	private By PostalCodeTab = By.id("postcode");
	private By MobileNumTab = By.id("phone_mobile");
	private By RegisterBtn = By.id("submitAccount");
	private By MobileNumMissed = By.xpath("//li[normalize-space()='You must register at least one phone number.']");
	private By FirstNameMissed = By.xpath("//div[@id='center_column']//b[normalize-space()='firstname']");
	private By LastNameMissed = By.xpath("//div[@id='center_column']//b[normalize-space()='lasstname']");
	private By PasswordMissed = By.xpath("//div[@id='center_column']//b[normalize-space()='passwd']");
	private By AddressMissed = By.xpath("//div[@id='center_column']//b[normalize-space()='address1']");
	private By CityMissed = By.xpath("//div[@id='center_column']//b[normalize-space()='city']");
	private By StateMissed = By.xpath("//li[normalize-space()='This country requires you to choose a State.']");
	private By PostalMissed = By.xpath("//div[@id='center_column']//li[contains(text(),'It must follow this format: 00000')]");
	private String CreatAccountURL  = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	private String CreatAccountPageTitle = "CREATE AN ACCOUNT";
	
	
	public Boolean CheckNavigationToCreateAccountPage () {
		
		waitUntilURLToBe(CreatAccountURL);
		return CheckElementText(CreateAccountTitleLocator, CreatAccountPageTitle);
	}
	
	public void SelectGender (String gender) {
		
		waitUntilElementIsVisabile(MaleGender);
		if(gender == "male") 
			click(MaleGender);
		else if(gender == "female")
			click(FemaleGender);
	}

	public void EnterFirstName (String Fname) {
		
		waitUntilElementIsVisabile(FirstNameTab);
		setText(FirstNameTab, Fname);
	}

	public void EnterLastName (String Lname) {
		
		waitUntilElementIsVisabile(LastNameTab);
		setText(LastNameTab, Lname);
	}

	public void EnterRegPassword (String Passwd) {
		
		waitUntilElementIsVisabile(RegPasswdTab);
		setText(RegPasswdTab, Passwd);
	}

	public void EnterDateOfBirth (String Day, String Month, String Year) {
		
		waitUntilElementIsVisabile(DaysList);
		selectFromDropDown(DaysList, Day);
		selectFromDropDown(MonthsList, Month);
		selectFromDropDown(YearsList, Year);
	}

	public void EnterCompany (String Company) {
		
		waitUntilElementIsVisabile(CompanyTab);
		setText(CompanyTab, Company);
	}

	public void EnterAddress (String Address) {
		
		waitUntilElementIsVisabile(AddressTab);
		setText(AddressTab, Address);
	}

	public void EnterCity (String City) {
		
		waitUntilElementIsVisabile(CityTab);
		setText(CityTab, City);
	}

	public void SelectState (String StateValue) {
		
		waitUntilElementIsVisabile(StateList);
		selectFromDropDown(StateList, StateValue);
	}

	public void EnterPostalCode (String PostalCode) {
		
		waitUntilElementIsVisabile(PostalCodeTab);
		setText(PostalCodeTab, PostalCode);
	}

	public void EnterMobileNumber (String MobileNum) {
		
		waitUntilElementIsVisabile(MobileNumTab);
		setText(MobileNumTab, MobileNum);
	}

	public void ClickOnRegisterBtn () {
		
		waitUntilElementIsVisabile(RegisterBtn);
		click(RegisterBtn);
	}

	public Boolean CheckFirstNameRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(FirstNameMissed);
	}

	public Boolean CheckLastNameRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(LastNameMissed);
	}

	public Boolean CheckPasswordRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(PasswordMissed);
	}

	public Boolean CheckAddressRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(AddressMissed);
	}

	public Boolean CheckCityRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(CityMissed);
	}

	public Boolean IsStateRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(StateMissed);
	}

	public Boolean CheckMobileNumRequiredMsgIsDisplayed () {
		
		return CheckElementVisiblity(MobileNumMissed);
	}
	
	public Boolean CheckInvalidPostalCodeMsgIsDisplayed () {
		
		return CheckElementVisiblity(PostalMissed);
	}
}
