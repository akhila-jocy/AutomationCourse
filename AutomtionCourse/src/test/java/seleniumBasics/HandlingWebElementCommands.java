package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingWebElementCommands extends Base{
	
	public void verifyWebElemets() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		
		WebElement messageBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageBox.sendKeys("Akhila"); //sendkeys - method used to input a value.
		
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
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
