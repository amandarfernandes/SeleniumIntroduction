package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRegExp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium-work\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		
		cdriver.get("https://www.rediff.com");
		WebElement signIn = cdriver.findElement(By.xpath("//a[contains(@title,'user?')]"));
		System.out.println(signIn.getAttribute("title"));
		signIn.click();
		
		cdriver.findElement(By.xpath("//input[@id='login1']")).sendKeys("amandarfernandes");
		cdriver.findElement(By.xpath("//input[@id='password']")).sendKeys("amanda23");
		cdriver.findElement(By.xpath("//input[contains(@value,'Sign')]")).click();
		

	}

}
