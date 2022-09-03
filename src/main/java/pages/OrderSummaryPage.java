package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends Basepage {

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	private By PageTitle = By.className("page-heading");
	private By PayMethod = By.className("page-subheading");
	private By ConfirmOrderBtn = By.className("button btn btn-default button-medium");
	private String OrderSummaryPageURL = "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment";
	private String OrderSummaryPageTitle = "ORDER SUMMARY";
	private String BankWirePaymentMethod = "BANK-WIRE PAYMENT.";

	public Boolean CheckNavigateToOrderSummaryPage () {

		waitUntilURLToBe(OrderSummaryPageURL);
		return CheckElementText(PageTitle, OrderSummaryPageTitle);
	}

	public Boolean CheckPaymentMethodIsBankWire () { 

		return CheckElementText(PayMethod, BankWirePaymentMethod);
	}

	public void ConfirmOrder () {

		waitUntilElementIsVisabile(ConfirmOrderBtn);
		click(ConfirmOrderBtn);
	}
}
