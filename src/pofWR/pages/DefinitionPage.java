package pofWR.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

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

public class DefinitionPage {
	public WebDriver driver;
	public WebDriverWait waitDefinitionPage; 

	public DefinitionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitDefinitionPage = new WebDriverWait(driver,Properties.WAIT_15S);
	}
	

	@FindBy(how = How.ID, using = Locators.SEARCH_FIELD_ID)
	WebElement searchField;
	
	@FindBy(how = How.ID, using = Locators.SEARCH_BUTTON_ID)
	WebElement searchButton;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = Locators.WR_REVERSE_TAB_PARTIALLINKTEXT)
	WebElement tab;
	
	@FindBy(how = How.ID, using = Locators.SEE_ALSO_ID)
	WebElement linksTable;
	
	@FindBy(how = How.XPATH, using = Locators.SEE_ALSO_ELEMENTS_XPATH)
	WebElement totalTerms;
	
	@FindBy(how = How.ID, using = Locators.SEE_ALSO_ELEMENT_LINKTAG)
	WebElement link;
	
	
	public void search(String searchTerm2) {
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.id(Locators.SEARCH_FIELD_ID)));
		searchField.clear();
		searchField.sendKeys(searchTerm2);
		
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.id(Locators.SEARCH_BUTTON_ID)));
		waitDefinitionPage.until(ExpectedConditions.elementToBeClickable(By.id(Locators.SEARCH_BUTTON_ID)));
		searchButton.click();	
	}
	
	public void wrReverse() {
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(Locators.WR_REVERSE_TAB_PARTIALLINKTEXT)));
		waitDefinitionPage.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(Locators.WR_REVERSE_TAB_PARTIALLINKTEXT)));
		tab.click();		
	}

	public void searchList(int numberOfElementToSearch) {
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated((By.id(Locators.SEE_ALSO_ID))));
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated((By.id(Locators.SEE_ALSO_ID))));
		List <WebElement> totalTerms = linksTable.findElements(By.xpath(Locators.SEE_ALSO_ELEMENTS_XPATH));
		
		assertTrue(numberOfElementToSearch <= totalTerms.size());
		WebElement link = totalTerms.get(numberOfElementToSearch-1).findElement(By.tagName(Locators.SEE_ALSO_ELEMENT_LINKTAG));
		
		waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(link.getText())));
		link.click();	
	}

}