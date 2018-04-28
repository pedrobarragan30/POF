package pofIMDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pofIMDB.libs.Properties;

public class CastPage {
	WebDriver driver;
	WebDriverWait waitCastPage;

	/*
	 * Constructor
	 */
	public CastPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitCastPage = new WebDriverWait(driver,Properties.WAIT_15S);
		System.out.println("Cast Page Constructor");
	}
	
	/*
	 * Selectors
	 */

	/*
	 * Methods
	 */
	public void validateTitle() {
		System.out.println("Cast Page validateTitle");		
	}

	public void validateActor_Role() {
		System.out.println("Cast Page validateActor_Role");	
	}
}