package pomtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

//import pageobjects.LoginPage;
import pageobjects.LoginPageFactory;

public class LoginTests {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//LoginPage login = new LoginPage(driver);
		LoginPageFactory login = new LoginPageFactory(driver);
		login.userName().sendKeys("amandarfernandes");
		login.password().sendKeys("amanda23");
		login.signIn().click();
		
	}
}
