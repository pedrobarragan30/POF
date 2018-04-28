package pofIMDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("Find Page Constructor");
	}
	
	/*
	 * Selectors
	 */

	/*
	 * Methods
	 */
	public void moreMatches() {
		System.out.println("Find Page moreMatches");
	}

	public TitlePage locateAndOpen() {
		System.out.println("Find Page locateAndOpens");
		return new TitlePage(driver);
	}
}