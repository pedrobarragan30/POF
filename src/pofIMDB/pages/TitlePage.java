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

public class TitlePage {
	WebDriver driver;
	WebDriverWait waitTitlePage;

	/*
	 * Constructor
	 */
	public TitlePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitTitlePage = new WebDriverWait(driver,Properties.WAIT_15S);
	}
	
	/*
	 * Selectors
	 */
	@FindBy(how = How.CLASS_NAME, using = Locators.TITLEPAGE_MOVIE_TITLE_WRAPPER_CLASS)
	WebElement movieTitle;
	
	@FindBy(how = How.LINK_TEXT, using = Locators.TITLEPAGE_FULL_CAST_LNK_TXT)
	WebElement fullCast;

	/*
	 * Methods
	 */
	public void validateTitle(String sequelName, String movieYear) {
		waitTitlePage.until(ExpectedConditions.presenceOfElementLocated(By.className(Locators.TITLEPAGE_MOVIE_TITLE_WRAPPER_CLASS)));
		
		if(movieTitle.getAttribute("textContent").contains(sequelName) && movieTitle.getAttribute("textContent").contains(movieYear)) {
			System.out.println("TITLE PAGE: El titulo de la pelicula es " + sequelName + " y fue exhibida en el año " + movieYear);
		}
	}

	public CastPage openCast() {
		waitTitlePage.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Locators.TITLEPAGE_FULL_CAST_LNK_TXT)));
		this.fullCast.click();

		return new CastPage(driver);
	}
}