package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddressPage;
import pages.AuthPage;
import pages.BlousesPage;
import pages.HomePage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.ShippingPage;
import pages.ShoppingCartPage;

public class OrderConfirmationTest extends BaseTest {
	
	AuthPage AuthPageObj;
	HomePage homePageObj;
	BlousesPage BlousesPageObj;
	ShoppingCartPage ShoppingCartPageObj;
	AddressPage AddressPageObj;
	ShippingPage ShippingPageObj;
	PaymentPage PaymentPageObj; 
	OrderConfirmationPage OrderConfirmationPageObj;
	
	@Test
	public void verify_order_confirmation_with_select_bank_wire  () { 

		AuthPageObj = new AuthPage(driver);
		homePageObj = new HomePage(driver);
		BlousesPageObj = new BlousesPage(driver);
		ShoppingCartPageObj = new ShoppingCartPage(driver);
		AddressPageObj = new AddressPage(driver);
		ShippingPageObj = new ShippingPage(driver);
		PaymentPageObj = new PaymentPage(driver);
		OrderConfirmationPageObj = new OrderConfirmationPage(driver);
		
		homePageObj.OpenAuthPage();
		AuthPageObj.SignIn("mohamed022@gmail.com", "mohamedmobarak");
		homePageObj.OpenBlusesPage();
		BlousesPageObj.AddBlouseToCart();
		BlousesPageObj.ClickOnProceedToCheckout();
		ShoppingCartPageObj.ClickOnProceedToCheckout();
		AddressPageObj.ClickOnProceedToCheckout();
		ShippingPageObj.AcceptTerms();
		ShippingPageObj.ClickOnProceedToCheckout();
		PaymentPageObj.ChooseBankWirePayment();
		OrderConfirmationPageObj.ConfirmOrder();
		Assert.assertTrue(OrderConfirmationPageObj.CheckFinishingOrder());
		
		
		

	}

}
