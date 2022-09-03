package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlousesPage extends Basepage {

	public BlousesPage(WebDriver driver) {
		super(driver);
	}

	private By PageTitle = By.className("cat-name");
	private By product = By.className("product_img_link");
	private By AddToCartBtn = By.xpath("//span[normalize-space()='Add to cart']");
	private By ProceedToCheckoutBtn = By.xpath("//span[normalize-space()='Proceed to checkout']");
	private By AddToCartMsg = By.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']");
	private String BlousePageURL = "http://automationpractice.com/index.php?id_category=7&controller=category";
	private String BlousesPageTitle = "BLOUSES ";


	public Boolean CheckNavigateToBlousesPage () {

		waitUntilURLToBe(BlousePageURL);
		return CheckElementText(PageTitle, BlousesPageTitle);
	}

	public void AddBlouseToCart () {
		
		waitUntilElementIsVisabile(product);
		hoverOnElement(product);
		click(AddToCartBtn);
	}

	public Boolean CheckNavigateToCheckoutProcedure () {
		
		waitUntilElementIsVisabile(AddToCartMsg);
		return CheckElementVisiblity(ProceedToCheckoutBtn);
	}

	public void ClickOnProceedToCheckout () {
		
		waitUntilElementIsVisabile(ProceedToCheckoutBtn);
		click(ProceedToCheckoutBtn);
	}

}
