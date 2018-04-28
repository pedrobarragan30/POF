package pofIMDB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("Home Page Constructor");
	}
	
	/*
	 * Selectors
	 */

	/*
	 * Methods
	 */
	public FindPage searchMovie() {
		System.out.println("Home Page searchMovie");
		return new FindPage(driver);
	}
}