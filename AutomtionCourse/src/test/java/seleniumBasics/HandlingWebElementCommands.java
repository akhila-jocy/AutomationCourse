package seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElementCommands extends Base{
	
	public void verifyWebElemets() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		
		WebElement messageBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageBox.sendKeys("Akhila"); //sendkeys - method used to input a value.
		
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //applying wait to a specific element -explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(showMessageButton));
		
		//fluent wait
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
		.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.elementToBeClickable(showMessageButton));
		
		showMessageButton.click();  //click - click function of web elements
		
		System.out.println(showMessageButton.isDisplayed());//boolean result true or false
		
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(yourMessage.getText()); //getText() - to show value in console
		messageBox.clear();
		WebElement valueA = driver.findElement(By.id("value-a"));
		System.out.println(valueA.getTagName());
		
	}
	public static void main(String[] args) {
		HandlingWebElementCommands webElements = new HandlingWebElementCommands();
		webElements.initializeBrowser();
		webElements.verifyWebElemets();

	}

}
