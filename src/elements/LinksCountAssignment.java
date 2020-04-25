package elements;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCountAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		String site = "https://rahulshettyacademy.com/AutomationPractice/";
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get(site);
		
		System.out.println(d.findElements(By.tagName("a")).size());
		
		
		System.out.println(d.findElements(By.cssSelector("#gf-BIG a")).size());
		System.out.println(d.findElement(By.id("gf-BIG")).findElements(By.tagName("a")).size());
		
		List<WebElement> footerLinks = d.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[1]/ul")).findElements(By.tagName("a"));
		int numFooterLinks = footerLinks.size();
		System.out.println(numFooterLinks);
		
		for (int i=1; i<numFooterLinks;i++) 
			footerLinks.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		Set<String>ids = d.getWindowHandles();
		Iterator<String> iterator = ids.iterator();
		
		String parentId = iterator.next();
		
		while (iterator.hasNext()){
			d.switchTo().window(iterator.next());
			System.out.println(d.getTitle());
		}
		d.switchTo().window(parentId);
		
		d.quit();
	}

}
