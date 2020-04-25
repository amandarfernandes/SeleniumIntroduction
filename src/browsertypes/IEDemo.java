package browsertypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\selenium-work\\IEDriverServer.exe");
		WebDriver ieDriver = new InternetExplorerDriver(); 
		
		ieDriver.get("http://www.google.com");
		System.out.println(ieDriver.getTitle());
		System.out.println(ieDriver.getCurrentUrl());

	}

}
