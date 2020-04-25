package elements;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		String site = "https://rahulshettyacademy.com/AutomationPractice/";
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(site);
		
		WebElement table = d.findElement(By.id("product"));
		
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.cssSelector("tr:nth-child(1) th")).size());
		System.out.println(table.findElement(By.cssSelector("tr:nth-child(3)")).getText());
	}

}
