import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com");

		Select adultDD = new Select(driver.findElement(By.id("Adults")));
		adultDD.selectByValue("2");
		
		Select childDD = new Select(driver.findElement(By.id("Childrens")));
		childDD.selectByValue("1");
		
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.className("ui-state-highlight")).click();

		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Spice Jet");
		
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		driver.close();
	}

}

