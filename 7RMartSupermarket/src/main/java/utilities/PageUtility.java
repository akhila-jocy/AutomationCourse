package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}
	public void selectDropdownByIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}
	public void selectDropdownByValue(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByValue(text);
	}
	public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
	public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void scrollDown(WebDriver driver, int value) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0," + value + ")");
	}

}
