package pofIMDB.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pofIMDB.pages.*;
import pofIMDB.libs.*;

public class IMDBBase {	
	protected WebDriver driver;
	protected HomePage imdbHomePage;
	protected FindPage imdbFindPage;
	protected TitlePage imdbTitlePage;
	protected CastPage imdbCastPage;

	public void setUp(String browserToUse, String urlToOpen) {
		switch(browserToUse) {
		case Properties.CHROME_WB:
			ChromeOptions options = new ChromeOptions();
			options.addArguments(Properties.CHROME_NOINFOBARS);
			options.addArguments(Properties.CHROME_NONOFICATIONS);

			driver = new ChromeDriver(options);
			System.out.println("STARTING WEB BROWSER: " + Properties.CHROME_WB);
			break;
		case Properties.FIREFOX_WB:
			driver = new FirefoxDriver();
			System.out.println("STARTING WEB BROWSER: " + Properties.FIREFOX_WB);
			break;
		case Properties.EDGE_WB:
			driver = new EdgeDriver();
			System.out.println("STARTING WEB BROWSER: " + Properties.EDGE_WB);
			break;
		case Properties.IE_WB:
			driver = new InternetExplorerDriver();
			System.out.println("STARTING WEB BROWSER: " + Properties.IE_WB);
			break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(Properties.WAIT_30S, TimeUnit.SECONDS);
		
		imdbHomePage = new HomePage(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}