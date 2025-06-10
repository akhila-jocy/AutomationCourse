package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	
	
	@Test
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
		
		String adminUsername = ExcelUtility.getStringData(0, 0,"AdminUsersPage");
		adminUsersPage.enterUsernameonUsernameField(adminUsername);
		String adminPassword = ExcelUtility.getStringData(0, 1,"AdminUsersPage");
		adminUsersPage.enterPasswordonPasswordField(adminPassword);
		adminUsersPage.selectUserTypefromUserTypeDropDown();
		adminUsersPage.clickOnSaveButton();	
	}
	
	@Test
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
