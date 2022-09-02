package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends Basepage {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	private By PaymentPageTitle = By.className("page-heading");
	private By PayByBankWireBtn = By.className("bankwire");
	
	
	public Boolean VerifyNavigateToPaymentPage () {
		waitUntilElementIsVisabile(PaymentPageTitle);
		return CheckElementVisiblity(PaymentPageTitle);
	}
	
	public void ChooseBankWirePayment () {
		waitUntilElementIsVisabile(PaymentPageTitle);
		click(PayByBankWireBtn);
	}

}
