import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver cdriver =  new ChromeDriver();
	
		cdriver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String myName = "Amanda";
		cdriver.findElement(By.id("name")).sendKeys(myName);
		
		cdriver.findElement(By.id("alertbtn")).click();
		System.out.println(cdriver.switchTo().alert().getText());
		cdriver.switchTo().alert().accept();
		
		cdriver.findElement(By.id("name")).sendKeys(myName);
		cdriver.findElement(By.id("confirmbtn")).click();
		System.out.println(cdriver.switchTo().alert().getText());
		cdriver.switchTo().alert().dismiss();
	}

}
