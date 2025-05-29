package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorSample extends Base{
	public void verifyJavaScriptExecutor()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", showMessageButton);
		js.executeScript("window.scrollBy(0,350)", ""); //to scroll down
		//js.executeScript("window.scrollBy(0,-350)", ""); //to scroll up
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaScriptExecutorSample script = new JavaScriptExecutorSample();
		script.initializeBrowser();
		script.verifyJavaScriptExecutor();
		//script.browserClose();
		
	}

}
