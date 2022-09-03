package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends Basepage {

	public AddressPage(WebDriver driver) {
		super(driver);	
	}

	private By PageTitle = By.className("navigation_page");
	private By ProceedToCheckoutBtn = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
	private String AddressPageTitle = "Addresses";


	public Boolean VerifyNavigateToAddressPage () {

		waitUntilElementIsVisabile(PageTitle);
		return CheckElementText(PageTitle, AddressPageTitle);
	}

	public void ClickOnProceedToCheckout () {
		
		waitUntilElementIsVisabile(ProceedToCheckoutBtn);
		click(ProceedToCheckoutBtn);
	}
}
