package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends Basepage {

	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	private By signinBtn = By.className("login");
	private By womenBtn = By.xpath("//a[@title='Women']");
	private By BlousesBtn = By.xpath("//a[@title='Blouses']");
	public String HomePageURL = "http://automationpractice.com/index.php";


	public void OpenAuthPage() {

		waitUntilElementIsVisabile(signinBtn);
		click(signinBtn);
	}

	public void OpenBlusesPage() {
		waitUntilElementIsVisabile(womenBtn);
		hoverOnElement(womenBtn);
		click(BlousesBtn);
	}

	public Boolean CheckWomenVisisblity() {
		return CheckElementVisiblity(womenBtn);
	}

	public Boolean checkBlusesVisiblity() {
		hoverOnElement(womenBtn);
		return CheckElementVisiblity(BlousesBtn);
	}

	public Boolean checkLoginBtnVisiblity() {
		return CheckElementVisiblity(signinBtn);
	}

	public void NavigateToHomePage () {
		driver.get(HomePageURL);
	}

}
