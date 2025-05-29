package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingAlert extends Base{

	public void verifySimpleAlert() {
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement simpleAlert = driver.findElement(By.id("alertButton"));
		simpleAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.accept();
		
	}
	public void verifyConfirmAlert()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
		confirmAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.accept();
		//alerts.dismiss();
		
	}
	
	public void verifyPromptAlert()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement promptAlert = driver.findElement(By.id("promtButton"));
		promptAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.sendKeys("Akhila");
		alerts.accept();
	}
	public static void main(String[] args) {
	HandlingAlert alert = new HandlingAlert();
	alert.initializeBrowser();
	//alert.verifySimpleAlert();
	//alert.verifyConfirmAlert();
	alert.verifyPromptAlert();
	//alert.browserClose();
	}

}
