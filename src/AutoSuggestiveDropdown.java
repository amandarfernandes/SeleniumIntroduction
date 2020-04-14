import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		String site="https://rahulshettyacademy.com/AutomationPractice/";
		
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		
		wd.get(site);
		
		WebElement autoSuggest = wd.findElement(By.id("autocomplete"));
		autoSuggest.sendKeys("Uni");
		
		Thread.sleep(2000L);
		autoSuggest.sendKeys(Keys.DOWN);
		String countryToFind = "United States (USA)";
		JavascriptExecutor jd = (JavascriptExecutor) wd;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String country = (String)jd.executeScript(script);
		System.out.println(country);
		int i = 10;
		while (!country.equalsIgnoreCase(countryToFind)) {
			autoSuggest.sendKeys(Keys.DOWN);
			country = (String)jd.executeScript(script);
			System.out.println(country);
			i--;
			if (i < 0) {
				System.out.println(countryToFind+" not located. Sorry!");
				break;
			}
		}
	}

}
