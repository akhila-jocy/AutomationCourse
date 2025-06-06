package automationCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser()
	{
	driver = new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.manage().window().maximize();
	//implicit wait - used for browser lauches.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
	@AfterMethod
	public void browserClose() 
	{
		//driver.quit();
	}
}
