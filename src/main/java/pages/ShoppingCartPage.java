package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends Basepage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	private By CartTitle = By.id("cart_title");
	private By CartProduct = By.className("cart_product");
	private By ProccedToCheckoutBtn = By.className("button btn btn-default standard-checkout button-medium");
	

}
