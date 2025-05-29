package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumBasics.TestNGBase;

public class LoginTest extends TestNGBase{
	
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		//WebElement usernameField = driver.findElement(By.id("user-name"));
		//usernameField.sendKeys("standard_user");
		//WebElement passwordField = driver.findElement(By.id("password"));
		//passwordField.sendKeys("secret_sauce");
		//WebElement loginButton = driver.findElement(By.id("login-button"));
		//loginButton.click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField();
		loginPage.enterPasswordOnpasswordField();
		loginPage.clickOnLoginButton();
	}
	
	
	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("user");
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	
	
	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret");
		
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	
	
	@Test
	public void verifyUserLoginWithInvalidCredentials()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("user");
		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret");
		
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
}
