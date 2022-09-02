package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends Basepage {

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	private By OrderSummaryPageTitle = By.className("page-heading");
	private By PayMethod = By.className("page-subheading");
	private By ConfirmOrderBtn = By.className("button btn btn-default button-medium");
	
	
	public Boolean VerifyNavigateToOrderSummaryPage () {
		waitUntilElementIsVisabile(OrderSummaryPageTitle);
		return CheckElementVisiblity(OrderSummaryPageTitle);
	}
	
	public String GetPaymentMethod () { //BANK-WIRE PAYMENT.
		waitUntilElementIsVisabile(OrderSummaryPageTitle);
		return driver.findElement(PayMethod).getText();
	}
	
	public void ConfirmOrder () {
		waitUntilElementIsVisabile(OrderSummaryPageTitle);
		click(ConfirmOrderBtn);
	}
}
