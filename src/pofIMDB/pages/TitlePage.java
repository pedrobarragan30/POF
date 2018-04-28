package pofIMDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("Title Page Constructor");
	}
	
	/*
	 * Selectors
	 */

	/*
	 * Methods
	 */
	public void validateTitle() {
		System.out.println("Title Page validateTitle");
	}

	public CastPage openCast() {
		System.out.println("Title Page openCast");
		return new CastPage(driver);
	}
}