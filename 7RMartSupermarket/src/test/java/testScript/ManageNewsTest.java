package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.ManageNewsPage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(description = "Adding new news into the Manage news list")
	public void verifyWhetherUserAbleToAddNewNews() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		ManageNewsPage manageNewsPage;
		manageNewsPage = homePage.clickOnManageNewsTileMoreInfo();
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		manageNewsPage.clickOnManageNewsAddButton().enterNewsOnNewsField(news).clickSaveButtonToSaveNews();
	}

	@Test(description = "Searching news from the news list")
	public void verifyWhetherUserAbleToSearchNews() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		ManageNewsPage manageNewsPage;
		manageNewsPage = homePage.clickOnManageNewsTileMoreInfo();
		String searchNews = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		manageNewsPage.clickOnSearchButton().enterNewsTitleToSearch(searchNews).clickOnSearchButtonToSearchNews();

	}

}
