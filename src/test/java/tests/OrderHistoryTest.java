package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddressPage;
import pages.AuthPage;
import pages.BlousesPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.OrderConfirmationPage;
import pages.OrderHistoryPage;
import pages.PaymentPage;
import pages.ShippingPage;
import pages.ShoppingCartPage;

public class OrderHistoryTest extends BaseTest {
	
	AuthPage AuthPageObj;
	HomePage homePageObj;
	BlousesPage BlousesPageObj;
	ShoppingCartPage ShoppingCartPageObj;
	AddressPage AddressPageObj;
	ShippingPage ShippingPageObj;
	PaymentPage PaymentPageObj; 
	OrderConfirmationPage OrderConfirmationPageObj;
	MyAccountPage MyAccountPageObj;
	OrderHistoryPage OrderHistoryPageObj; 
	
	@Test
	public void verify_order_is_exist_in_order_history  () { 

		AuthPageObj = new AuthPage(driver);
		homePageObj = new HomePage(driver);
		BlousesPageObj = new BlousesPage(driver);
		ShoppingCartPageObj = new ShoppingCartPage(driver);
		AddressPageObj = new AddressPage(driver);
		ShippingPageObj = new ShippingPage(driver);
		PaymentPageObj = new PaymentPage(driver);
		OrderConfirmationPageObj = new OrderConfirmationPage(driver);
		MyAccountPageObj = new MyAccountPage(driver);
		OrderHistoryPageObj = new OrderHistoryPage(driver);
		
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
		OrderConfirmationPageObj.NavigateToMyAccount();
		MyAccountPageObj.ClickOnOrdersHistory();
		Assert.assertTrue(OrderHistoryPageObj.CheckNavigateToOrderHistoryPage());
		Assert.assertTrue(OrderHistoryPageObj.CheckIsOrderAdded());
		
		

	}

}
