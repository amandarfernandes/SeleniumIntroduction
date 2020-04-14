import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		String site="https://us.megabus.com/";
		
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.get(site);
		
		WebElement fromCity = d.findElement(By.cssSelector("#startingAt"));
		fromCity.clear();
		fromCity.sendKeys("NEW");
		Thread.sleep(2000L);
		
		
		fromCity.sendKeys(Keys.DOWN);
		String city = "New York, NY";
		String script="return document.getElementById(\"startingAt\").value;";
		JavascriptExecutor jd = (JavascriptExecutor)d;
		String val = (String)jd.executeScript(script);
		System.out.println(fromCity.getAttribute("value"));
		System.out.println(val);		
		int count = 10;
		while(!val.equalsIgnoreCase(city)) {
			fromCity.sendKeys(Keys.DOWN);
			val = (String)jd.executeScript(script);
			System.out.println(fromCity.getAttribute("value"));
			System.out.println(val);
			count--;
			if (count == 0) {
				System.out.println("City not found");
				break;
			}
		}
	}

}
