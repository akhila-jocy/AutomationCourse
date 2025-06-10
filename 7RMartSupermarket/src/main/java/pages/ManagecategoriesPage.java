package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;

public class ManagecategoriesPage {
	
	public WebDriver driver;
	
	public ManagecategoriesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and text()='More info ']") 
	private WebElement manageCategoryMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") private WebElement manageCategoryAddButton;
	@FindBy(id="category") private WebElement categoryField;
	@FindBy(id="134-selectable") private WebElement selectGroups;
	@FindBy(id="main_img") private WebElement imageUpload;
	@FindBy(xpath="//input[@name='top_menu' and @value='no']") private WebElement notShowOnTopMenuRadioButton;
	@FindBy(xpath="//input[@name='show_home' and @value='no']") private WebElement notShowOnLeftMenuRadioButton;
	@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath="//h1[text()='Add Category']") private WebElement addCateory;
	
	public void clickMoreInfoInManageCategories()
	{
		manageCategoryMoreInfo.click();
	}
	public void clickOnNewButtonToAddNewCategory()
	{
		manageCategoryAddButton.click();
	}
	public void enterCategoryInCategoryField(String category)
	{
		categoryField.sendKeys(category);
	}
	public void clickOnDiscount()
	{
		selectGroups.click();
	}
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)", "");
	}
	public void clickOnFileUploadToUploadImage()
	{
		imageUpload.sendKeys(Constant.TESTIMAGEFILE);
	}
	public void selectRadioButtons()
	{
		notShowOnTopMenuRadioButton.click();
		notShowOnLeftMenuRadioButton.click();
	}

	public void saveButtonToSavecategory()
	{
		//saveButton.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",saveButton );
	}
	public String addcategoryDisplayed()
	{
		return addCateory.getText();
	}
}

	