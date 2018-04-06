package pofWR.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("Inside HomePage Constructor");
	}

	public void search() {
		System.out.println("Inside HomePage -> search Method");
	}
}