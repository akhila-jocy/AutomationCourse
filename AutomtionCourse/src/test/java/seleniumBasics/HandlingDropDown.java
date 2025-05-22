package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown extends Base{
	public void verifyDropDown()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropDown =driver.findElement(By.id("dropdowm-menu-1"));
		Select select = new Select(dropDown);
		//select.selectByIndex(2);
		//select.selectByVisibleText("C#");
		select.selectByValue("sql");
	}

	public static void main(String[] args) {
		HandlingDropDown dropDown = new HandlingDropDown();
		dropDown.initializeBrowser();
		dropDown.verifyDropDown();
		//dropDown.browserClose();

	}

}
