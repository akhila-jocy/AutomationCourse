package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
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

		RandomDataUtility random = new RandomDataUtility();
		String adminUsername = random.createRandomUsername(); // Testdata using faker
		String adminPassword = random.createRandomPassword();
		adminUsersPage.enterUsernameonUsernameField(adminUsername).enterPasswordonPasswordField(adminPassword)
				.selectUserTypefromUserTypeDropDown().clickOnSaveButton();
		boolean isAddAdminUsersPageDisplayed = adminUsersPage.addAdminUsersPageDisplayed();
		Assert.assertTrue(isAddAdminUsersPageDisplayed,Messages.ADD_ADMIN_USERS_PAGE_NAVIGATION_ERROR);
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

		String adminUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterUsernameToSearchAdminUser(adminUsername).selectUserTypeFromDropdownToSearch()
				.clickOnSearchButtonToSearchAdminUsers();
		boolean isAdminUsersSearchPageDisplayed = adminUsersPage.adminUsersSearchPageDisplayed();
		Assert.assertTrue(isAdminUsersSearchPageDisplayed,Messages.SEARCH_ADMIN_USER_PAGE_NAVIGATION_ERROR);
	}
}
