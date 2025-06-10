package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.ManageNewsPage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	
	@Test
	public void verifyWhetherUserAbleToAddNewNews() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnManageNewsTileMoreInfo();
		manageNewsPage.clickOnManageNewsAddButton();
		String news = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		manageNewsPage.enterNewsOnNewsField(news);
		manageNewsPage.clickSaveButtonToSaveNews();
	}
	
	
	@Test
	public void verifyWhetherUserAbleToSearchNews() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
		manageNewsPage.clickOnManageNewsTileMoreInfo();
		manageNewsPage.clickOnSearchButton();
		String searchNews = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		manageNewsPage.enterNewsTitleToSearch(searchNews);
		manageNewsPage.clickOnSearchButtonToSearchNews();
		
	}

}
