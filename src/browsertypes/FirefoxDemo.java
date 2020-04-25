package browsertypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDemo {

	public static void main(String[] args) {
		//invoke Firefox 
				System.setProperty("webdriver.gecko.driver", "C:\\selenium-work\\geckodriver.exe");
				WebDriver firefoxDriver = new FirefoxDriver(); 
				
				firefoxDriver.get("http://www.google.com");
				System.out.println(firefoxDriver.getTitle());
				System.out.println(firefoxDriver.getCurrentUrl());
	}

}
