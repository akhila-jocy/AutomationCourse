package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.ManagecategoriesPage;
import pages.SigninPage;
import utilities.ExcelUtility;

public class ManagecategoriesTest extends Base{

	@Test
	public void verifyWhetherUserAbleToAddNewCategory() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0,"SigninPage");
		String password = ExcelUtility.getStringData(0, 1,"SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username);
		signinPage.enterPasswordOnpasswordField(password);
		signinPage.clickOnSigninButton();
		
		ManagecategoriesPage manageCategories = new ManagecategoriesPage(driver);
		manageCategories.clickMoreInfoInManageCategories();
		manageCategories.clickOnNewButtonToAddNewCategory();
		
		String actual = manageCategories.addcategoryDisplayed();
		String expected = "Add Category";
		Assert.assertEquals(actual, expected,"User was unable to Navigate to Add Category page");
		
		String category = ExcelUtility.getStringData(2, 0,"ManageCategoriesPage");
		manageCategories.enterCategoryInCategoryField(category);
		manageCategories.clickOnDiscount();
		manageCategories.scrollDown();
		manageCategories.clickOnFileUploadToUploadImage();
		manageCategories.selectRadioButtons();
		manageCategories.scrollDown();
		manageCategories.saveButtonToSavecategory();
		
		
	}
}
