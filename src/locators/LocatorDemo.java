package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorDemo {

	public static void main(String[] args) {
		//invoke Chrome 
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver(); 
		
		chromeDriver.get("http://www.facebook.com");
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		
		chromeDriver.findElement(By.linkText("Forgot account?")).click();
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		
		chromeDriver.navigate().back();
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		
		chromeDriver.findElement(By.id("email")).sendKeys("amanda.dcunha.fernandes@facebook.com");;
		chromeDriver.findElement(By.name("pass")).sendKeys("LaSwans1971");
		chromeDriver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		chromeDriver.close();
		chromeDriver.quit();
	}
	

}
