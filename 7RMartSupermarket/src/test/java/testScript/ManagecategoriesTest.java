package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.ManagecategoriesPage;
import pages.SigninPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManagecategoriesTest extends Base {

	@Test(description = "Adding new category into the category list by entering category informations.")
	public void verifyWhetherUserAbleToAddNewCategory() throws IOException {
		HomePage homePage;
		String username = ExcelUtility.getStringData(0, 0, "SigninPage");
		String password = ExcelUtility.getStringData(0, 1, "SigninPage");
		SigninPage signinPage = new SigninPage(driver);
		signinPage.enterUsernameOnUsernameField(username).enterPasswordOnpasswordField(password);
		homePage = signinPage.clickOnSigninButton();

		ManagecategoriesPage manageCategories;
		manageCategories = homePage.clickMoreInfoInManageCategories();
		RandomDataUtility random = new RandomDataUtility();
		String category = random.createRandomCategoryNames(); // faker
		manageCategories.clickOnNewButtonToAddNewCategory().enterCategoryInCategoryField(category).clickOnDiscount()
				.clickOnFileUploadToUploadImage().showOnTopMenuRadioButton().showOnLeftMenuRadioButton()
				.clickOnSaveButtonToSavecategory();
		String actual = manageCategories.addcategoryDisplayed();
		String expected = "Add Category";
		Assert.assertEquals(actual, expected, "User was unable to Navigate to Add Category page");

	}
}
