package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.SigninPage;
import utilities.ExcelUtility;

public class SigninTest extends Base{
	
	@Test
	public void verifyUserSigninWithValidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
	}
	
	@Test
	public void  verifyUserSigninWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(1, 0,"SigninPage");
		String password = ExcelUtility.getStringData(1, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();	
		
	}
	
	@Test
	public void  verifyUserSigninWithInvalidUsernameAndValidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(2, 0,"SigninPage");
		String password = ExcelUtility.getStringData(2, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
	}
	
	@Test
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
