package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddressPage;
import pages.AuthPage;
import pages.BlousesPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ShippingPage;
import pages.ShoppingCartPage;

public class CheckoutProcedureTest extends BaseTest {

	AuthPage AuthPageObj;
	HomePage homePageObj;
	BlousesPage BlousesPageObj;
	ShoppingCartPage ShoppingCartPageObj;
	AddressPage AddressPageObj;
	ShippingPage ShippingPageObj;
	PaymentPage PaymentPageObj; 
	
	@Test
	public void verify_correct_checkout_procedure_proccess () {

		AuthPageObj = new AuthPage(driver);
		homePageObj = new HomePage(driver);
		BlousesPageObj = new BlousesPage(driver);
		ShoppingCartPageObj = new ShoppingCartPage(driver);
		AddressPageObj = new AddressPage(driver);
		ShippingPageObj = new ShippingPage(driver);
		PaymentPageObj = new PaymentPage(driver);
		
		homePageObj.OpenAuthPage();
		AuthPageObj.SignIn("mohamed022@gmail.com", "mohamedmobarak");
		homePageObj.OpenBlusesPage();
		BlousesPageObj.AddBlouseToCart();
		Assert.assertTrue(BlousesPageObj.CheckNavigateToCheckoutProcedure());
		BlousesPageObj.ClickOnProceedToCheckout();
		Assert.assertTrue(ShoppingCartPageObj.CheckNavigateToShoppingCartPage());
		Assert.assertTrue(ShoppingCartPageObj.CheckSelectedProductIsExist());
		ShoppingCartPageObj.ClickOnProceedToCheckout();
		Assert.assertTrue(AddressPageObj.VerifyNavigateToAddressPage());
		AddressPageObj.ClickOnProceedToCheckout();
		Assert.assertTrue(ShippingPageObj.CheckNavigateToShippingPage());
		ShippingPageObj.AcceptTerms();
		ShippingPageObj.ClickOnProceedToCheckout();
		Assert.assertTrue(PaymentPageObj.CheckNavigateToPaymentPage());
		
		
		

	}
}
