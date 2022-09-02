package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends Basepage {

	public AddressPage(WebDriver driver) {
		super(driver);	
	}
	
	public static int index;
	private By AddressTitle = By.className("page-heading");
	private By AddressDetailsLocator = By.xpath("//*[@id=\"address_delivery\"]/li[" + index + "]");
	private By ProceedToCheckoutBtn = By.className("button btn btn-default button-medium");
	
	
	public Boolean VerifyNavigateToAddressPage () {
		return driver.findElement(AddressTitle).isDisplayed();
	}
	
	public String [] GetDeliveryAddress () {
		
		String [] AddressDetails = new String [5] ;
		for(int i=0;i<5;i++) {
			index = i+2;
			AddressDetails [i] = driver.findElement(AddressDetailsLocator).getText();
		}
		
		return AddressDetails ;
		
	}
	
	public void ClickOnProceedToCheckout () {
		waitUntilElementIsVisabile(AddressTitle);
		click(ProceedToCheckoutBtn);
	}
}
