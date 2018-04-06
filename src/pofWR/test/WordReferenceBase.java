package pofWR.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pofWR.pages.DefinitionPage;
import pofWR.pages.HomePage;


public class WordReferenceBase {
	protected WebDriver driver;
	protected DefinitionPage wrDefinitionPage;
	protected HomePage wrHomePage;

	public void setUp(String urlToOpen, String browserToUse) {
		switch(browserToUse) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("-disable-notifications");
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
		   break;
		case "firefox":
			
			driver = new FirefoxDriver();
			break;
		case "edge":
			
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wrHomePage = new HomePage(driver);
		wrDefinitionPage = new DefinitionPage(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}