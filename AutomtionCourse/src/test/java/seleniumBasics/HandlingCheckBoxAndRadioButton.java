package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingCheckBoxAndRadioButton extends Base{
	
	public void verifyCheckbox()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='option-2']"));
		checkBox1.click();
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='option-4']"));
		checkBox2.click();
	}
	
	public void verifyRadioButton()
	{
		WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='yellow']"));
		radioButton1.click();
	}
	public static void main(String[] args) {
		HandlingCheckBoxAndRadioButton obj = new HandlingCheckBoxAndRadioButton();
		obj.initializeBrowser();
		obj.verifyCheckbox();
		obj.verifyRadioButton();
		//obj.browserClose();

	}

}
