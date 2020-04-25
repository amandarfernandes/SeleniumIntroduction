package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	@FindBy(css="input#login1")
	private WebElement userName;
	
	@FindBy(css="input#password")
	private WebElement password;
	
	@FindBy(css="input[value='Sign in']")
	WebElement signin;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public WebElement userName() {
		return userName;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement signIn() {
		return signin;
	}
}