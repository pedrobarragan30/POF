package pofWR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pofWR.libs.Locators;
import pofWR.libs.Properties;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait waitHomePage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHomePage = new WebDriverWait(driver,Properties.WAIT_15S);
	}


	@FindBy(how = How.CLASS_NAME, using = Locators.SEARCH_BOX_CLASSNAME)
	WebElement searchField;
	
	@FindBy(how = How.CLASS_NAME, using = Locators.SEARCH_BUTTON_CLASSNAME)
	WebElement submitButton;

	

	public DefinitionPage search(String searchTerm1) {
		searchField.clear();
		searchField.sendKeys(searchTerm1);

		waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.className(Locators.SEARCH_BUTTON_CLASSNAME)));
		waitHomePage.until(ExpectedConditions.elementToBeClickable(By.className(Locators.SEARCH_BUTTON_CLASSNAME)));
		submitButton.click();
		return new DefinitionPage(driver);
	}
}