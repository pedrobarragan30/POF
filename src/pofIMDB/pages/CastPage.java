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
	}
	
	/*
	 * Selectors
	 */
	@FindBy(how = How.CLASS_NAME, using = Locators.CASTPAGE_MOVIE_TITLE_PARENT_CLASS)
	WebElement movieTitle;
	
	@FindBy(how = How.XPATH, using = Locators.CASTPAGE_CAST_TABLE_XPATH)
	WebElement movieList;
	
	
	/*
	 * Methods
	 */
	public void validateTitle(String sequelName, String movieYear) {
		waitCastPage.until(ExpectedConditions.presenceOfElementLocated(By.className(Locators.CASTPAGE_MOVIE_TITLE_PARENT_CLASS)));
		
		if(movieTitle.getAttribute("textContent").contains(sequelName) && movieTitle.getAttribute("textContent").contains(movieYear)) {
			System.out.println("CAST PAGE: El titulo de la pelicula es " + sequelName + " y fue exhibida en el año " + movieYear);
		}	
	}

	public void validateActor_Role(String actor_and_Roles) {
		String[] actorRole = actor_and_Roles.split(":");
		for(String currentActorRole : actorRole){
			splitActorAndRole(currentActorRole);
		}
	}

	private void splitActorAndRole(String currentActorRole) {
		String[] splitActorRole = currentActorRole.split("_");
		String actor = splitActorRole[0];
		String role = splitActorRole[1];

		WebElement correctRow = null;

		waitCastPage
				.until(ExpectedConditions.presenceOfElementLocated(By.className(Locators.CASTPAGE_CAST_TABLE_CLASS)));

		List<WebElement> castList = driver.findElements(By.xpath("//table[@class='cast_list']//tr"));
		for (WebElement currentRow : castList) {
			String trText = currentRow.getAttribute("textContent");
			if (trText.contains(actor) && trText.contains(role)) {
				correctRow = currentRow;
				break;
			}
		}
		if (correctRow != null) {
			if(correctRow.getAttribute("textContent").contains(actor) && correctRow.getAttribute("textContent").contains(role)) {
				System.out.println("El actor " + actor + " actua el rol de " + role);
			}
			else {
				System.out.println("El actor " + actor + " NO actua el rol de " + role);
			}
		} else {
			System.out.println("Actor y Role no encontrados");
		}
	}
}