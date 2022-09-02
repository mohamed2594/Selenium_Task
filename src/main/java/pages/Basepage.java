package pages;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	WebDriver driver ; 
	private WebDriverWait wait;
	
	public Basepage(WebDriver driver){
        this.driver= driver;
    }
	

	public void setText(By by , String value) {
		driver.findElement(by).sendKeys(value);
	}
	
	public void clearText(By by) {
		driver.findElement(by).clear();
	}
	
	public void click(By by) {
		driver.findElement(by).click();
	}
	
	public void selectFromDropDown(By by,String value ) {
		
		
        Select dropDown = new Select(driver.findElement(by));
        dropDown.selectByValue(value);
    }
	
	
	public void hoverOnElement(By by) {
		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(by)).perform();
	}
	
	 
	public void waitUntilElementIsVisabile(By by) {
	        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }
	 
	 
//	public void scrollToElement(WebElement element) {
//		 
//		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		 
//	 }
	
//	public void sendKeysInSequence(WebElement element ,String text) {
//	    Random r = new Random();
//	    for(int i = 0; i < text.length(); i++) {
//	        try {
//	            Thread.sleep((int)(r.nextGaussian() * 15 + 100));
//	        } catch(InterruptedException e) {}
//	        String s = new StringBuilder().append(text.charAt(i)).toString();
//	        element.sendKeys(s);
//	    }
	    
	  
//	}
	  public String RandomMobileNum() {
	    	Random rnd = new Random();
		    String number = "010" + rnd.nextInt(99999999);
		    return number;
		    
	    }
	  public String RndomeEmail() {
	    	Random rnd = new Random();
		    String email = "mohamed" + rnd.nextInt(99999999) + "@test.com";
		    return email;
		    
	    }
	  public Boolean CheckElementVisiblity(By by) {
		return   driver.findElement(by).isDisplayed();
		  
	  }
	  public Boolean CheckElementText(By by , String text) {
		  
			   return driver.findElement(by).getText().contains(text);
			  
		  }
	  
	

}