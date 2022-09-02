package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlousesPage extends Basepage {

	public BlousesPage(WebDriver driver) {
		super(driver);
	}
	
	private By product = By.className("product_img_link");
	private By BlousesCategory = By.className("cat-name");
	private By AddToCartBtn = By.className("button ajax_add_to_cart_button btn btn-default");
	private By ProceedToCheckoutBtn = By.className("btn btn-default button button-medium");
	private By AddToCartMsg = By.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']");
	
	
	public Boolean VerifyNavigateToBlousesPage () {
		return driver.findElement(BlousesCategory).isDisplayed();
	}
	
	public void AddBlouseToCart () {
		waitUntilElementIsVisabile(product);
		hoverOnElement(product);
		click(AddToCartBtn);
	}
	
	public Boolean VerifyNavigateToChecoutProcedure () {
		waitUntilElementIsVisabile(AddToCartMsg);
		return driver.findElement(AddToCartMsg).isDisplayed();
	}
	
	public void ClickOnProceedToCheckout () {
		waitUntilElementIsVisabile(AddToCartMsg);
		click(ProceedToCheckoutBtn);
	}
	
}
