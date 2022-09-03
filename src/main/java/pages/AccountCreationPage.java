package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreationPage extends Basepage{

	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}
	
	public static String RegisterErrorMessage = null; // the error message appeared while Registeration failure
	private By PageTitle = By.className("page-heading");
	private By MaleGender = By.xpath("//input[@id='id_gender1']");
	private By FemaleGender = By.xpath("//input[@id='id_gender2']");
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
	private By RegisterErrorMsg = By.xpath("//div[@id='center_column']//li[contains(.,'" + RegisterErrorMessage + "')]");
	private String CreatAccountURL  = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	private String CreatAccountPageTitle = "CREATE AN ACCOUNT";
	
	
	public Boolean CheckNavigationToCreateAccountPage () {
		
		waitUntilURLToBe(CreatAccountURL);
		return CheckElementText(PageTitle, CreatAccountPageTitle);
	}
	
	public void FillRegisterationData (String Gender,String Fname,String Lname,String Password,String Day,String Month,String Year,String Company,String Address,String City,String State,String PostalCode, String MobileNum) {
		
		waitUntilElementIsVisabile(FirstNameTab);
		SelectGender(Gender);
		setText(FirstNameTab, Fname);
		setText(LastNameTab, Lname);
		setText(RegPasswdTab, Password);
		selectFromDropDown(DaysList, Day);
		selectFromDropDown(MonthsList, Month);
		selectFromDropDown(YearsList, Year);
		setText(CompanyTab, Company);
		setText(AddressTab, Address);
		setText(CityTab, City);
		selectFromDropDown(StateList, State);
		setText(PostalCodeTab, PostalCode);
		setText(MobileNumTab, MobileNum);
	}
	
	public void SelectGender (String gender) {
		
		if(gender == "male") 
			click(MaleGender);
		else if(gender == "female")
			click(FemaleGender);
	}

	public void ClickOnRegisterBtn () {
		
		waitUntilElementIsVisabile(RegisterBtn);
		click(RegisterBtn);
	}
	
	public Boolean CheckAnyFieldRequiredMsgIsDisplayed() {
		
		return CheckElementVisiblity(RegisterErrorMsg);
	}


}
