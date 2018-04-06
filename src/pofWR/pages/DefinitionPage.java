package pofWR.pages;

import org.openqa.selenium.WebDriver;

public class DefinitionPage {
	WebDriver driver;

	public DefinitionPage(WebDriver driver) {
		this.driver = driver;
		System.out.println("Inside DefinitionPage Constructor");
	}

	public void wrReverse() {
		System.out.println("Inside DefinitionPage -> wrReverse Method");		
	}

	public void searchList() {
		System.out.println("Inside DefinitionPage -> searchList Method");	
	}
}