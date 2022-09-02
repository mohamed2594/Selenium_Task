package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private By MyAccount = By.xpath("//h1[@class='page-heading']");
	private By LogOutBtn = By.xpath("//a[@title='Log me out']");
	private WebDriverWait wait ;
	
	
	public Boolean Check_MyAccount_visibility() {

		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("?controller=my-account"));
		
		return CheckElementVisiblity(MyAccount);
	}
	
	public void LogOut () {
		waitUntilElementIsVisabile(LogOutBtn);
		click(LogOutBtn);
	}
	
	

}
