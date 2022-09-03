package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends Basepage {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	private By PageTitle = By.className("navigation_page");
	private By PayByBankWireBtn = By.xpath("//a[@title='Pay by bank wire']");
	private String PaymentPageTitle = "Your payment method";
	
	
	public Boolean CheckNavigateToPaymentPage () {
		
		waitUntilElementIsVisabile(PageTitle);
		return CheckElementText(PageTitle, PaymentPageTitle);
	}
	
	public void ChooseBankWirePayment () {
		
		waitUntilElementIsVisabile(PayByBankWireBtn);
		click(PayByBankWireBtn);
	}
	
	

}
