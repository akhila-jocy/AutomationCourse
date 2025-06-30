package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class SigninTest extends Base {

	@Test(description = "User sigin with valid credentials", priority = 1, groups = { "smoke" })
	public void verifyUserSigninWithValidCredentials() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		// boolean isDashboardDisplayed = signinPage.dashboardDisplayed();
		// Assert.assertTrue(isDashboardDisplayed,"User was unable to login with valid
		// credentials");
		String actual = signinPage.dashboardDisplayed();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALERROR);

	}

	@Test(description = "User sigin with valid username and invalid password", priority = 2, groups = { "smoke" })
	public void verifyUserSigninWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "SigninPage");
		String password = ExcelUtility.getStringData(1, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password).clickOnSigninButton();
	}

	@Test(description = "User sigin with invalid username and valid password", priority = 3)
	public void verifyUserSigninWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "SigninPage");
		String password = ExcelUtility.getStringData(2, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password).clickOnSigninButton();
	}

	@Test(description = "User sigin with invalid credentials", priority = 4, dataProvider = "signindata")
	public void verifyUserSigninWithInvalidCredentials(String username, String password) throws IOException {
		// String username = ExcelUtility.getStringData(3, 0,"SigninPage"); 
		// String password = ExcelUtility.getStringData(3, 1,"SigninPage"); -used dataProvider instead of excel.
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password).clickOnSigninButton();
	}

	@DataProvider(name = "signindata")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "TestUsername1", "TestPassword1" },
				{ "TestUsername2", "TestPassword2" } };
		// return new Object[][] {new Object[] {ExcelUtility.getStringData(3,0,"SigninPage"),
		//ExcelUtility.getStringData(3, 1,"SigninPage")}}; -reading data through dataprovider
	}
}
