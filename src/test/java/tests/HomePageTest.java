package tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest{
	HomePage homePageObj ;

	
	@Test
	public void Verify_signin_Button_Visiblity() {
		homePageObj = new HomePage(driver);
		Assert.assertTrue(homePageObj.checkLoginBtnVisiblity());
	}
	
	@Test
	public void Verify_Women_Button_Visiblity() {
		homePageObj = new HomePage(driver);
		Assert.assertTrue(homePageObj.CheckWomenVisisblity());
	}
	
	@Test
	public void Verify_Bluses_Button_Visiblity() {
		homePageObj = new HomePage(driver);
		Assert.assertTrue(homePageObj.checkBlusesVisiblity());
	}

}
