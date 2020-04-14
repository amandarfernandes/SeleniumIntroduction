import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d =  new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		d.get("https://www.amazon.com");
		Actions a = new Actions(d);
		
		
		WebElement target = d.findElement(By.cssSelector("#twotabsearchtextbox"));
		a.moveToElement(target).click().keyDown(Keys.SHIFT).sendKeys("yeast").build().perform();
		
		a.moveToElement(d.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
	}

}
