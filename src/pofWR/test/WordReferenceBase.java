package pofWR.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pofWR.libs.Properties;
import pofWR.pages.DefinitionPage;
import pofWR.pages.HomePage;


public class WordReferenceBase {
	protected WebDriver driver;
	protected DefinitionPage wrDefinitionPage;
	protected HomePage wrHomePage;

	public void setUp(String browserToUse, String urlToOpen) {
		switch(browserToUse) {
		case Properties.CHROME_WB:
			ChromeOptions options = new ChromeOptions();
			options.addArguments(Properties.CHROME_NOINFOBARS);
			options.addArguments(Properties.CHROME_NONOFICATIONS);

			driver = new ChromeDriver(options);
		   break;
		case Properties.FIREFOX_WB:
			driver = new FirefoxDriver();
			break;
		case Properties.EDGE_WB:
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(Properties.WAIT_30S, TimeUnit.SECONDS);
		
		wrHomePage = new HomePage(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}