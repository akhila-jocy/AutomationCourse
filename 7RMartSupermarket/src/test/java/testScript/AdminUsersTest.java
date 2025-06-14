package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.SigninPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	
	
	@Test(description="Adding new users to the users list",retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserAbleToaddNewAdminUsers() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnAdminUsersMoreInfo();
		adminUsersPage.clickOnNewButton();
		
		boolean isAddAdminUsersPageDisplayed = adminUsersPage.addAdminUsersPageDisplayed();
		Assert.assertTrue(isAddAdminUsersPageDisplayed,"User was unable to navigate to Add New Admin Users Page");
		RandomDataUtility random = new RandomDataUtility();
		String adminUsername = random.createRandomUsername(); //Testdata using faker
		adminUsersPage.enterUsernameonUsernameField(adminUsername);
		String adminPassword = random.createRandomPassword();
		adminUsersPage.enterPasswordonPasswordField(adminPassword);
		adminUsersPage.selectUserTypefromUserTypeDropDown();
		adminUsersPage.clickOnSaveButton();	
	}
	
	@Test(description="Searching users using username and userType")
	public void verifyWhetherUserAbleToSearchAdminUsers() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnAdminUsersMoreInfo();
		adminUsersPage.clickOnSearchButtonInAdminUsersPage();
		
		boolean isAdminUsersSearchPageDisplayed = adminUsersPage.adminUsersSearchPageDisplayed();
		Assert.assertTrue(isAdminUsersSearchPageDisplayed,"User was unable to navigate to  Admin Users Search Page");
		
		String adminUsername = ExcelUtility.getStringData(0, 0,"AdminUsersPage");
		adminUsersPage.enterUsernameToSearchAdminUser(adminUsername);
		adminUsersPage.selectUserTypeFromDropdownToSearch();
		adminUsersPage.clickOnSearchButtonToSearchAdminUsers();
	}
}
