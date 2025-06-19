package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.SigninPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {

	@Test(description = "Adding new users to the users list", retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserAbleToaddNewAdminUsers() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		AdminUsersPage adminUsersPage;
		adminUsersPage = homePage.clickOnAdminUsersMoreInfo();
		adminUsersPage.clickOnNewButtonInAdminUsersPage();

		boolean isAddAdminUsersPageDisplayed = adminUsersPage.addAdminUsersPageDisplayed();
		Assert.assertTrue(isAddAdminUsersPageDisplayed, "User was unable to navigate to Add New Admin Users Page");
		RandomDataUtility random = new RandomDataUtility();
		String adminUsername = random.createRandomUsername(); // Testdata using faker
		String adminPassword = random.createRandomPassword();
		adminUsersPage.enterUsernameonUsernameField(adminUsername).enterPasswordonPasswordField(adminPassword)
				.selectUserTypefromUserTypeDropDown().clickOnSaveButton();
	}

	@Test(description = "Searching users using username and userType")
	public void verifyWhetherUserAbleToSearchAdminUsers() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		AdminUsersPage adminUsersPage;
		adminUsersPage = homePage.clickOnAdminUsersMoreInfo();
		adminUsersPage.clickOnSearchButtonInAdminUsersPage();

		boolean isAdminUsersSearchPageDisplayed = adminUsersPage.adminUsersSearchPageDisplayed();
		Assert.assertTrue(isAdminUsersSearchPageDisplayed, "User was unable to navigate to  Admin Users Search Page");

		String adminUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterUsernameToSearchAdminUser(adminUsername).selectUserTypeFromDropdownToSearch()
				.clickOnSearchButtonToSearchAdminUsers();
	}
}
