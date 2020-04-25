package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnabledDisabledVerification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver cDriver = new ChromeDriver();
		
		cDriver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		Thread.sleep(2000L);
		String styleAttr = cDriver.findElement(By.cssSelector("div#Div1")).getAttribute("style");
		System.out.println(styleAttr);
		System.out.println(styleAttr.contains("opacity: 0.5"));
		System.out.println("Disabled");
		cDriver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		Thread.sleep(2000L);
		styleAttr = cDriver.findElement(By.cssSelector("div#Div1")).getAttribute("style");
		System.out.println(styleAttr);
		Assert.assertTrue(styleAttr.contains("opacity: 1"));
		System.out.println("Enabled");
		
	}

}
