package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestData.ExcelReader;
import pages.AuthPage;
import pages.HomePage;
import pages.MyAccountPage;

public class AuthenticationTest extends BaseTest {
	
	HomePage homePageObj;
	AuthPage AuthPageObj;
	MyAccountPage MyAccountPageObj;
	
	@DataProvider(name="SignInInvalidData")
	public Object[][] SignInInvalidData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData("SignInInvalidData", 3);
	}
	
	@DataProvider(name="SignInValidData")
	public Object[][] SignInValidData() throws IOException
	{
		
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData("SignInValidData", 2);
	}

	@Test(priority = 3)
	public void verify_that_signIn_page_is_Accessible () {
		
		homePageObj = new HomePage(driver);
		AuthPageObj = new AuthPage(driver) ;
		
		homePageObj.OpenAuthPage();
		Assert.assertTrue(AuthPageObj.CheckNavigationToAuthPage());

	}
	
	@Test(priority = 2,dataProvider = "SignInValidData")
	public void verify_that_user_can_signIn_with_valid_data (String Email , String Password) {
		
		homePageObj = new HomePage(driver);
		AuthPageObj = new AuthPage(driver) ;
		MyAccountPageObj = new MyAccountPage(driver);
		
		homePageObj.OpenAuthPage();
		AuthPageObj.SignIn(Email, Password);
		Assert.assertTrue(MyAccountPageObj.CheckNavigateToMyAccountPage());
		MyAccountPageObj.LogOut();

	}

	@Test(priority = 1,dataProvider = "SignInInvalidData")
	public void verify_Invalid_SignIn (String Email, String Password, String ErrorMsg) {

		homePageObj = new HomePage(driver);
		AuthPage.LoginErrorMessage = ErrorMsg;
		AuthPageObj = new AuthPage(driver) ;
		MyAccountPageObj = new MyAccountPage(driver);
		
		homePageObj.OpenAuthPage();
		AuthPageObj.SignIn(Email, Password);
		Assert.assertTrue(AuthPageObj.CheckLoginErrorMsgIsDisplayed());

	}

}
