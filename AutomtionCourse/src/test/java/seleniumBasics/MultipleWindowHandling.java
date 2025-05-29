package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWindowHandling extends Base {
	
	public void multipleWindow()
	{
		driver.navigate().to("https://demo.guru99.com/popup.php");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHere.click();
		
		Set<String>handleIds=driver.getWindowHandles(); 
		System.out.println(handleIds);
		
		Iterator<String>it=handleIds.iterator();
		while(it.hasNext())
		{
			String currentId= it.next();
			if(!currentId.equals(parentWindow))
			{
				driver.switchTo().window(currentId);
				WebElement email=driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("akhilajocy@gmail.com");
				WebElement submit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submit.click();
			}
		}
		//driver.switchTo().window(parentWindow);
	}

	public static void main(String[] args) {
		MultipleWindowHandling window = new MultipleWindowHandling();
		window.initializeBrowser();
		window.multipleWindow();
		//window.browserClose();

	}

}
