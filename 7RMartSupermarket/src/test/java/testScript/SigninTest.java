package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.SigninPage;
import utilities.ExcelUtility;

public class SigninTest extends Base{
	
	@Test(description="User sigin with valid credentials",priority=1, groups= {"smoke"})
	public void verifyUserSigninWithValidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		//boolean isDashboardDisplayed = signinPage.dashboardDisplayed();
		//Assert.assertTrue(isDashboardDisplayed,"User was unable to login with valid credentials");
		String actual = signinPage.dashboardDisplayed();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected,"User was unable to login with valid credentials");
		
	}
	
	@Test(description="User sigin with valid username and invalid password",priority=2,groups= {"smoke"})
	public void  verifyUserSigninWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(1, 0,"SigninPage");
		String password = ExcelUtility.getStringData(1, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();	
		
		
	}
	
	@Test(description="User sigin with invalid username and valid password",priority=3)
	public void  verifyUserSigninWithInvalidUsernameAndValidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(2, 0,"SigninPage");
		String password = ExcelUtility.getStringData(2, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
	}
	
	@Test(description="User sigin with invalid credentials",priority=4)
	public void verifyUserSigninWithInvalidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(3, 0,"SigninPage");
		String password = ExcelUtility.getStringData(3, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
	}
}
