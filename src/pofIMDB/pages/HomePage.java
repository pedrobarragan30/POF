package pofIMDB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pofIMDB.libs.Locators;
import pofIMDB.libs.Properties;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait waitHomePage;

	/*
	 * Constructor
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHomePage = new WebDriverWait(driver,Properties.WAIT_15S);
	}
	
	/*
	 * Selectors
	 */
	@FindBy(how = How.ID, using = Locators.HOMEPAGE_SEARCH_FIELD_ID)
	WebElement searchField;
	
	@FindBy(how = How.ID, using = Locators.HOMEPAGE_SEARCH_BUTTON_ID)
	WebElement searchButton;

	/*
	 * Methods
	 */
	public FindPage searchMovie(String movieName) {
		waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.id(Locators.HOMEPAGE_SEARCH_FIELD_ID)));
		searchField.clear();
		searchField.sendKeys(movieName);
		
		waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.id(Locators.HOMEPAGE_SEARCH_BUTTON_ID)));
		waitHomePage.until(ExpectedConditions.elementToBeClickable(By.id(Locators.HOMEPAGE_SEARCH_BUTTON_ID)));
		searchButton.click();
		
		return new FindPage(driver);
	}
}