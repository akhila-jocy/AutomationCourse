package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingTables extends Base{
 public void verifyTable()
 {
	 driver.navigate().to("https://money.rediff.com/indices/nse");
	 WebElement fullTable = driver.findElement(By.xpath("//table[@id=\'dataTable\']"));
	 System.out.println(fullTable.getText());
	 WebElement tableRow = driver.findElement(By.xpath("//table[@id=\'dataTable\']/tbody/tr[2]"));
	 System.out.println(tableRow.getText());
	 //tableRow.getText();
 }
	public static void main(String[] args) {
		HandlingTables table = new HandlingTables();
		table.initializeBrowser();
		table.verifyTable();
		//table.browserClose();

	}

}
