import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowsDemo {

	public static void main(String[] args) {
		String site = "https://demoqa.com/automation-practice-switch-windows-2/"; 
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d =  new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		d.get(site);
		System.out.println(d.getTitle());
		d.findElement(By.cssSelector("#button1")).click();
		
		Set<String> windowIds = d.getWindowHandles();
		Iterator<String> iterator = windowIds.iterator();
		
		String parentId = iterator.next();
		System.out.println("Parent Window ID: "+parentId);
		String childId = iterator.next();
		
		d.switchTo().window(childId);
		System.out.println(d.getTitle());
		d.close(); 
		
		d.switchTo().window(parentId);
		System.out.println(d.getTitle());
		
		d.findElement(By.xpath("//button[@id='button1']/following-sibling::button")).click();
		windowIds = d.getWindowHandles();
		
		System.out.println("test"+windowIds.size());
		
		iterator = windowIds.iterator();
		
		iterator.next();
		System.out.println("Parent Window ID 2: "+parentId);
		childId = iterator.next();
		
		d.switchTo().window(childId);
		//System.out.println(d.getTitle());
		System.out.println("Message Window ID: "+childId);
		d.close();
		
		d.switchTo().window(parentId);
		System.out.println(d.getTitle());
		
		d.quit();
		

	}

}
