package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	
	WebDriver driver;
    @BeforeTest
	public void TestsetUp() {
		 WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 driver.manage().window().setSize(new Dimension(1024, 768));
		 driver.get("http://automationpractice.com/index.php");

	
		
		 
	}
    
    
    @AfterTest
    public void TesttearDown(){
        driver.quit();
    }
    

}
