package seleniumBasics;

public class HandlingNavigationCommands extends Base{
	public void verifyNavigationCommands() {
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		}
	
	public static void main(String[] args) {
		HandlingNavigationCommands navigate = new HandlingNavigationCommands();
		navigate.initializeBrowser();
		navigate.verifyNavigationCommands();
		//navigate.browserClose();

	}

}
