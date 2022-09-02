package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage extends Basepage{

	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}

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


	public void SelectGender (String gender) {

		if(gender == "male")
			click(MaleGender);
		else if(gender == "female")
			click(FemaleGender);
	}

	public void EnterFirstName (String Fname) {
		setText(FirstNameTab, Fname);
	}

	public void EnterLastName (String Lname) {
		setText(LastNameTab, Lname);
	}

	public void EnterRegPassword (String Passwd) {
		setText(RegPasswdTab, Passwd);
	}

	public void EnterDateOfBirth (String Day, String Month, String Year) {
		selectFromDropDown(DaysList, Day);
		selectFromDropDown(MonthsList, Month);
		selectFromDropDown(YearsList, Year);
	}

	public void EnterCompany (String Company) {
		setText(CompanyTab, Company);
	}

	public void EnterAddress (String Address) {
		setText(AddressTab, Address);
	}

	public void EnterCity (String City) {
		setText(CityTab, City);
	}

	public void SelectState (String StateValue) {
		selectFromDropDown(StateList, StateValue);
	}

	public void EnterPostalCode (String PostalCode) {
		setText(PostalCodeTab, PostalCode);
	}

	public void EnterMobileNumber (String MobileNum) {
		setText(MobileNumTab, MobileNum);
	}

	public void ClickOnRegisterBtn () {
		click(RegisterBtn);
	}

	public Boolean Is_First_Name_Required_Msg_displayed () {
		return CheckElementVisiblity(FirstNameMissed);
	}

	public Boolean Is_Last_Name_Required_Msg_displayed () {
		return CheckElementVisiblity(LastNameMissed);
	}

	public Boolean Is_Password_Required_Msg_displayed () {
		return CheckElementVisiblity(PasswordMissed);
	}

	public Boolean Is_Address_Required_Msg_displayed () {
		return CheckElementVisiblity(AddressMissed);
	}

	public Boolean Is_City_Required_Msg_displayed () {
		return CheckElementVisiblity(CityMissed);
	}

	public Boolean Is_State_Required_Msg_displayed () {
		return CheckElementVisiblity(StateMissed);
	}

	public Boolean Is_MobileNum_Required_Msg_displayed () {
		return CheckElementVisiblity(MobileNumMissed);
	}
}
