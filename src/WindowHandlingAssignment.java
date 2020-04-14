import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingAssignment {

	public static void main(String[] args) {
		String site = "https://the-internet.herokuapp.com/"; 
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d =  new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		d.get(site);
		
		d.findElement(By.linkText("Multiple Windows")).click();
		d.findElement(By.linkText("Click Here")).click();
		
		Set<String> windowIds = d.getWindowHandles();
		Iterator<String> iterator = windowIds.iterator();
		
		String parent = iterator.next();
		String child = iterator.next();
		
		d.switchTo().window(child);
		System.out.println(d.findElement(By.tagName("h3")).getText());
		
		d.switchTo().window(parent);
		System.out.println(d.findElement(By.tagName("h3")).getText());
		
		
		d.quit();
		
	}

}
