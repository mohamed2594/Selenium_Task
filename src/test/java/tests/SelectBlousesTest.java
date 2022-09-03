package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BlousesPage;
import pages.HomePage;

public class SelectBlousesTest extends BaseTest {
	
	HomePage homePageObj;
	BlousesPage BlousesPageObj;
	
	@Test
	public void verify_that_user_can_open_blouses_page () {
		
		homePageObj = new HomePage(driver);
		BlousesPageObj = new BlousesPage(driver);
		
		homePageObj.NavigateToHomePage();
		homePageObj.OpenBlusesPage();
		Assert.assertTrue(BlousesPageObj.CheckNavigateToBlousesPage());
	}

}
