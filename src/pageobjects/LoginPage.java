package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By username = By.cssSelector("input#login1");
	By password = By.cssSelector("input#password");
	By signin = By.cssSelector("input[value='Sign in']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement userName() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement signIn() {
		return driver.findElement(signin);
	}
}
