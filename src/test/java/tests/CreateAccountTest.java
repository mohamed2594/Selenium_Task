package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;

import pages.AccountCreationPage;
import pages.AuthPage;
import pages.HomePage;
import pages.MyAccountPage;

public class CreateAccountTest extends BaseTest{

	HomePage homePageObj;
	AuthPage AuthPageObj;
	AccountCreationPage AccountCreationPageObj;
	MyAccountPage MyAccountPageObj;
	CSVReader reader ; 
	Faker fakeData;
	
	@Test(priority = 1)
	public void verify_that_signUp_page_is_Accessible () {

		homePageObj = new HomePage(driver);
		AuthPageObj = new AuthPage(driver) ;

		homePageObj.OpenAuthPage();
		Assert.assertTrue(AuthPageObj.CheckNavigationToAuthPage());

	}
	
	
	@Test(priority = 2)
	public void verify_Successfull_SignUp () {
		
		fakeData = new Faker();
		
		String Email = fakeData.internet().emailAddress();
		String Gender = "male";
		String Fname = fakeData.name().firstName(); 
		String Lname = fakeData.name().lastName(); 
		String Password = fakeData.number().digits(8).toString(); 
		String Day = "2"; 
		String Month = "5";
		String Year = "1994";
		String Company = fakeData.company().name();
		String Address = fakeData.address().streetName();
		String City = fakeData.address().city();
		String State = "8";
		String PostalCode = fakeData.number().digits(5);
		String MobileNum = fakeData.phoneNumber().cellPhone();


		homePageObj = new HomePage(driver);
		AuthPageObj = new AuthPage(driver);
		AccountCreationPageObj = new AccountCreationPage(driver);
		MyAccountPageObj = new MyAccountPage(driver);
		
		homePageObj.OpenAuthPage();
		AuthPageObj.EnterRegisterEmail(Email);
		AccountCreationPageObj.FillRegisterationData(Gender, Fname, Lname, Password, Day, Month, Year, Company, Address, City, State, PostalCode, MobileNum);
		AccountCreationPageObj.ClickOnRegisterBtn();

		Assert.assertTrue(MyAccountPageObj.CheckNavigateToMyAccountPage());
		MyAccountPageObj.LogOut();
	}

	@Test(priority = 3)
	public void verify_validation_on_required_signup_fields () throws IOException  {


		// get path of CSV file 
		String CSV_file = System.getProperty("user.dir")+"/src/test/java/TestData/CreateAccountInvalidData.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 

		String[] csvCell ; 

		// while loop will be executed till the lastvalue in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{

			String Email = csvCell[0];
			String Gender = csvCell[1];
			String Fname = csvCell[2]; 
			String Lname = csvCell[3]; 
			String Password = csvCell[4]; 
			String Day = csvCell[5]; 
			String Month = csvCell[6];
			String Year = csvCell[7];
			String Company = csvCell[8];
			String Address = csvCell[9];
			String City = csvCell[10];
			String State = csvCell[11];
			String PostalCode = csvCell[12];
			String MobileNum = csvCell[13];
			String ErrorMsg = csvCell[14];


			homePageObj = new HomePage(driver);
			AccountCreationPage.RegisterErrorMessage = ErrorMsg;
			AuthPageObj = new AuthPage(driver) ;
			AccountCreationPageObj = new AccountCreationPage(driver);

			homePageObj.OpenAuthPage();
			AuthPageObj.EnterRegisterEmail(Email);
			AccountCreationPageObj.FillRegisterationData(Gender, Fname, Lname, Password, Day, Month, Year, Company, Address, City, State, PostalCode, MobileNum);
			AccountCreationPageObj.ClickOnRegisterBtn();

			Assert.assertTrue(AccountCreationPageObj.CheckAnyFieldRequiredMsgIsDisplayed());

		}
	}
	
	
}
