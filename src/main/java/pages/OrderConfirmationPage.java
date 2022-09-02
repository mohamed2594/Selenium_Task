package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends Basepage {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	private By OrderConfirmationPageTitle = By.className("page-heading");
	
	public Boolean CheckOrderConfirmation () {
		return CheckElementVisiblity(OrderConfirmationPageTitle);
	}

}
