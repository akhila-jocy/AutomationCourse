package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumBasics.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		//WebElement usernameField = driver.findElement(By.id("user-name"));
		//usernameField.sendKeys("standard_user");
		//WebElement passwordField = driver.findElement(By.id("password"));
		//passwordField.sendKeys("secret_sauce");
		//WebElement loginButton = driver.findElement(By.id("login-button"));
		//loginButton.click();
		
		String username = ExcelUtility.getStringData(0, 0,"LoginPage");
		String password = ExcelUtility.getStringData(0, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnpasswordField(password);
		loginPage.clickOnLoginButton();
	}
	
	
	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		
		String username = ExcelUtility.getStringData(1, 0,"LoginPage");
		String password = ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnpasswordField(password);
		loginPage.clickOnLoginButton();
	}
	
	
	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(2, 0,"LoginPage");
		String password = ExcelUtility.getStringData(2, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnpasswordField(password);
		loginPage.clickOnLoginButton();
	}
	
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(3, 0,"LoginPage");
		String password = ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnpasswordField(password);
		loginPage.clickOnLoginButton();
	}
}
