import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		String site = "https://the-internet.herokuapp.com/"; 
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		
		WebDriver d =  new ChromeDriver();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		d.get(site);
		
		d.findElement(By.linkText("Nested Frames")).click();
		d.switchTo().frame(d.findElement(By.cssSelector("[name='frame-top']")))
				.switchTo().frame(d.findElement(By.cssSelector("[name='frame-middle']")));
		System.out.println(d.findElement(By.id("content")).getText());
		d.quit();
	}

}
