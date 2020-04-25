package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.facebook.com");
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		
		chromeDriver.findElement(By.cssSelector("input#email")).sendKeys("amandadcunha@gmail.com");
		chromeDriver.findElement(By.cssSelector("input[name='pass']")).sendKeys("LaSwans1971");;
		chromeDriver.findElement(By.cssSelector("label#loginbutton>input")).click();
		
		chromeDriver.close();

		
	}

}
