package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private By PageTitle = By.className("page-heading");
	private By LogOutBtn = By.xpath("//a[@title='Log me out']");
	private By HistoryBtn = By.xpath("//span[normalize-space()='Order history and details']");
	private String MyAccountURL = "http://automationpractice.com/index.php?controller=my-account";
	private String MyAccountPageTitle = "MY ACCOUNT";
	
	
	public Boolean CheckNavigateToMyAccountPage() {

		waitUntilURLToBe(MyAccountURL);
		return CheckElementText(PageTitle, MyAccountPageTitle);
	}
	
	public void ClickOnOrdersHistory () {
		
		waitUntilElementIsVisabile(HistoryBtn);
		click(HistoryBtn);
	}
	
	public void LogOut () {
		waitUntilElementIsVisabile(LogOutBtn);
		click(LogOutBtn);
	}
	
	

}
