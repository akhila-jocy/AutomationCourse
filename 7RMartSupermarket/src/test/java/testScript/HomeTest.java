package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "logout from home page.")
	public void verifyWhetherUserAbleToLogout() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage=signinPage.clickOnSigninButton();

		homePage.clickOnadmindropdownLink();
		signinPage=homePage.clickOnLogoutOption();
		boolean isSigninPageDisplayed = homePage.signinPageDisplayed();
		Assert.assertTrue(isSigninPageDisplayed, "User was unable to logout");

	}
}
