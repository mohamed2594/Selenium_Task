package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends Basepage {

	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	
	private By PageTitle = By.className("navigation_page");
	private By TermsCheckbox = By.id("uniform-cgv");
	private By ProceedToCheckoutBtn = By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
	private String ShippingPageTitle = "Shipping";
	
	public Boolean CheckNavigateToShippingPage () {
		
		waitUntilElementIsVisabile(PageTitle);
		return CheckElementText(PageTitle, ShippingPageTitle);
	}
	
	public void AcceptTerms () {
		
		waitUntilElementIsVisabile(TermsCheckbox);
		click(TermsCheckbox);
	}
	
	public void ClickOnProceedToCheckout () {
		
		waitUntilElementIsVisabile(ProceedToCheckoutBtn);
		click(ProceedToCheckoutBtn);
	}
}
