package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.dockerjava.api.model.SELContext;

public class ShippingPage extends Basepage {

	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	
	private By ShippingTitle = By.className("page-heading");
	private By TermsCheckbox = By.id("uniform-cgv");
	private By ProceedToCheckoutBtn = By.className("button btn btn-default standard-checkout button-medium");
	
	
	public Boolean CheckNavigateToShippingPage () {
		return driver.findElement(ShippingTitle).isDisplayed();
	}
	
	public void AcceptTerms () {
		selectFromDropDown(TermsCheckbox, "1");
	}
	
	public void ClickOnProceedToCheckout () {
		waitUntilElementIsVisabile(ProceedToCheckoutBtn);
		click(ProceedToCheckoutBtn);
	}
}
