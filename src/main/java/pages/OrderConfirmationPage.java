package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends Basepage {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	private By PageTitle = By.className("navigation_page");
	private By ConfirmOrderBtn = By.xpath("//span[normalize-space()='I confirm my order']");
	private By MyAccountBtn = By.className("header_user_info");
	private String OrderConfirmPageTitle = "Order confirmation";



	public void ConfirmOrder () {

		waitUntilElementIsVisabile(ConfirmOrderBtn);
		click(ConfirmOrderBtn);
	}

	public Boolean CheckFinishingOrder () {

		waitUntilElementIsVisabile(PageTitle);
		return CheckElementText(PageTitle, OrderConfirmPageTitle);
	}
	
	public void NavigateToMyAccount () {
		
		waitUntilElementIsVisabile(MyAccountBtn);
		click(MyAccountBtn);
	}

}
