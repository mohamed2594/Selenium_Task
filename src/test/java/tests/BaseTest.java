package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	
	WebDriver driver;
	
    @BeforeClass
	public void TestsetUp() {
		 WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 driver.manage().window().setSize(new Dimension(1024, 768));
		
	}
    
    @BeforeMethod
    public void NavigateToHomePage () {
    	
    	driver.get("http://automationpractice.com/index.php");
    }
    
    
    @AfterClass
    public void TesttearDown(){
        driver.quit();
    }
    

}
