package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LogoutPage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{

	
	@Test
	public void verifyWhetherUserAbleToLogout() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickOnadmindropdownLink();
		logoutPage.clickOnLogoutOption();
		
		
	}
}
