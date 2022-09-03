package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends Basepage {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}
	
		private By PageTitle = By.className("navigation_page");
		private By OrderList = By.id("order-list");
		private String OrderHistoryPageTitle = "Order history";
		
		public Boolean CheckNavigateToOrderHistoryPage () {
			
			waitUntilElementIsVisabile(PageTitle);
			return CheckElementText(PageTitle, OrderHistoryPageTitle);
		}
		
		public Boolean CheckIsOrderAdded () {
			
			return CheckElementVisiblity(OrderList);
		}
		
		
		
	

}