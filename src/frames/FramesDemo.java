package frames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		String site = "https://jqueryui.com/droppable";
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		d.get(site);
		
		d.switchTo().frame(d.findElement(By.cssSelector("iframe.demo-frame")));
		Actions a = new Actions(d);
		WebElement source = d.findElement(By.cssSelector("#draggable p"));
		WebElement target = d.findElement(By.cssSelector("#droppable p"));
		System.out.println(target.getText());
		Thread.sleep(1000L);
		a.moveToElement(source).dragAndDrop(source, target).build().perform();
		System.out.println(target.getText());
		d.quit();
	}

}
