package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends Base{
	public void verifyRightClick()
	{
		WebElement rightClick = driver.findElement(By.xpath("//a[text()='Home']"));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).build().perform();
	}
	
	public void verifyMouseHover()
	{
		WebElement mouseHover = driver.findElement(By.id("others"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover).build().perform();
		
	}
	
	public void dragAndDrop()
	{
		driver.navigate().to("https://demoqa.com/droppable");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		
	}
	public void keyboardAction() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public static void main(String[] args) {
		HandlingActions action = new HandlingActions();
		action.initializeBrowser();
		//action.verifyRightClick();
		//action.verifyMouseHover();
		//action.dragAndDrop();
		try {
			action.keyboardAction();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//action.browserClose();

	}

}
