package browsertypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDemo {

	public static void main(String[] args) {
		//invoke Chrome 
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver(); 
		
		chromeDriver.get("http://www.google.com");
		System.out.println(chromeDriver.getTitle());
		System.out.println(chromeDriver.getCurrentUrl());
		//System.out.println(chromeDriver.getPageSource());
		
		chromeDriver.get("http://www.yahoo.com");
		System.out.println(chromeDriver.getTitle());
		
		chromeDriver.navigate().back();
		System.out.println(chromeDriver.getTitle());
		
		
		chromeDriver.close();
		chromeDriver.quit();
	}
	

}
