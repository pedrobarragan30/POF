package pofIMDB.pages;

import java.util.List;

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

public class FindPage {
	WebDriver driver;
	WebDriverWait waitFindPage;

	/*
	 * Constructor
	 */
	public FindPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitFindPage = new WebDriverWait(driver,Properties.WAIT_15S);
	}
	
	/*
	 * Selectors
	 */
	@FindBy(how = How.LINK_TEXT, using = Locators.FINDPAGE_MORE_MATCHES_LNK_TXT)
	WebElement moreMatchesLink;
	
	@FindBy(how = How.CLASS_NAME, using = Locators.FINDPAGE_CLEAR_RECENT_HISTORY_ID)
	WebElement clearRecentHistory;
	
	@FindBy(how = How.CLASS_NAME, using = Locators.FINDPAGE_MOVIES_LIST_CLASS)
	List <WebElement> moviesList;

	/*
	 * Methods
	 */
	public void moreMatches() {
		waitFindPage.until(ExpectedConditions.presenceOfElementLocated(By.linkText(Locators.FINDPAGE_MORE_MATCHES_LNK_TXT)));
		waitFindPage.until(ExpectedConditions.elementToBeClickable(By.linkText(Locators.FINDPAGE_MORE_MATCHES_LNK_TXT)));
		
		this.moreMatchesLink.click();
	}

	public TitlePage locateAndOpen(String sequelName, String movieYear) {
		//If something at the Bottom is already present, then something from top should be available.
		waitFindPage.until(ExpectedConditions.presenceOfElementLocated(By.id(Locators.FINDPAGE_CLEAR_RECENT_HISTORY_ID)));
		
		waitFindPage.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(Locators.FINDPAGE_MOVIES_LIST_CLASS)));
		WebElement correctElement = null;
		
		for(WebElement currentMovie: moviesList) {
			if(currentMovie.getAttribute("textContent").contains(sequelName) && currentMovie.getAttribute("textContent").contains(movieYear)) {
				correctElement = currentMovie;
				break;
			}
		}
		WebElement correctLink = correctElement.findElement(By.partialLinkText(sequelName));
		correctLink.click();
		return new TitlePage(driver);
	}
}