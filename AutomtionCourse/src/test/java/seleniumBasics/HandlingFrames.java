package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFrames extends Base{
	
	public void verifyFrames()
	{
	driver.navigate().to("https://demoqa.com/frames");
	List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
	System.out.println(totalFrames.size());
	
	WebElement mainframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
	driver.switchTo().frame(mainframe);
	
	WebElement tableHeading = driver.findElement(By.xpath("//h1[@id=\'sampleHeading\']"));
	System.out.println(tableHeading.getText());
	
	driver.switchTo().defaultContent(); //control goes back
	
	}

	public static void main(String[] args) {
		HandlingFrames frames = new HandlingFrames();
		frames.initializeBrowser();
		frames.verifyFrames();
		//frames.browserClose();
	}

}
