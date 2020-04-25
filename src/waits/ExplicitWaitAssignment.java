package waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		String site="http://www.itgeared.com/demo/1506-ajax-loading.html";
		d.get(site);
		
		d.findElement(By.linkText("Click to load get data via Ajax!")).click();
		WebDriverWait wd = new WebDriverWait(d,5);
		
		By results = By.id("results");
		wd.until(ExpectedConditions.visibilityOfElementLocated(results));
		System.out.println(d.findElement(results).getText());
				
		d.quit();
	}

}
