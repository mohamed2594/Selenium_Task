package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends Basepage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	private By PageTitle = By.className("navigation_page");
	private By CartProduct = By.className("cart_product");
	private By ProceedToCheckoutBtn = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
	private String CartPageTitle = "Your shopping cart";

	public Boolean CheckNavigateToShoppingCartPage () {

		waitUntilElementIsVisabile(PageTitle);
		return CheckElementText(PageTitle, CartPageTitle);
	}

	public Boolean CheckSelectedProductIsExist () {

		return CheckElementVisiblity(CartProduct);
	}

	public void ClickOnProceedToCheckout () {

		waitUntilElementIsVisabile(ProceedToCheckoutBtn);
		click(ProceedToCheckoutBtn);
	}

}
