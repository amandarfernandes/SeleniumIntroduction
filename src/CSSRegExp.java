import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSRegExp {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		
		cdriver.get("https://www.rediff.com");
		WebElement signIn = cdriver.findElement(By.cssSelector("a[title*='user?']"));
		System.out.println(signIn.getAttribute("title"));
		signIn.click();
		
		
		cdriver.findElement(By.cssSelector("input#login1")).sendKeys("amandarfernandes");
		cdriver.findElement(By.cssSelector("input#password")).sendKeys("amanda23");
		cdriver.findElement(By.cssSelector("input[value*=Sign]")).click();
		
		//System.out.println(cdriver.findElement(By.cssSelector("//a[href*='myprofile']")).getText());

	}

}
