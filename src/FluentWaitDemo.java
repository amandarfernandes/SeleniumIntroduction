import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		d.findElement(By.cssSelector("#start button")).click();
		
		Wait<WebDriver> fw = new FluentWait<WebDriver>(d).withTimeout(Duration.ofSeconds(30))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);
		
		WebElement msg = fw.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver d) {
				WebElement msg = d.findElement(By.cssSelector("#finish h4"));
				if (msg.isDisplayed())
					return msg;
				else return null;
			}
		});
		
		System.out.println(msg.getText());
		
		//d.close();



	}

}
