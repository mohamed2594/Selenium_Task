package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BlousesPage;
import pages.HomePage;

public class SelectProductTest extends BaseTest {
	
	HomePage homePageObj;
	BlousesPage BlousesPageObj;
	
	@Test
	public void verify_that_user_can_add_blouse_to_cart () {
		homePageObj = new HomePage(driver);
		BlousesPageObj = new BlousesPage(driver);
		
		homePageObj.OpenBlusesPage();
		BlousesPageObj.AddBlouseToCart();
		Assert.assertTrue(BlousesPageObj.CheckNavigateToCheckoutProcedure());
	}

}
