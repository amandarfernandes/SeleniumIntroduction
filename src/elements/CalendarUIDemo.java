package elements;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUIDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		String site = "https://www.path2usa.com/travel-companions";
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(site);
	
		//open calendar
		d.findElement(By.id("travel_date")).click();
		
		String month = "March";
		String day = "23";
		
		String currMonth = d.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
		
		while (!currMonth.contains(month)) {
			d.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
			currMonth = d.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
		}
		
		List<WebElement>days = d.findElements(By.cssSelector(".day"));
		
		for (int i =0; i< days.size(); i++) {
			if (day.equalsIgnoreCase(days.get(i).getText())) {
				days.get(i).click();
				break;
			}
					
		}
		

	}

}
