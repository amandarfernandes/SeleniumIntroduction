import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableColumnSort {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver cdriver =  new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String site="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		cdriver.get(site);
		
		
		
		
		
		WebElement tbody = cdriver.findElement(By.xpath("//table[@id='sortableTable']/tbody"));
		
		//get elements from second column of table
		List<WebElement> cols = tbody.findElements(By.cssSelector("tr td:nth-child(2"));
		
		
		//store element text in array list
		ArrayList<String> fruits = new ArrayList<String>();
		for (WebElement fruit:cols) {
			fruits.add(fruit.getText());
		}
		
		ArrayList<String> fruitsSorted = (ArrayList<String>) fruits.clone();
		
		//Collections.sort(fruitsSorted, Collections.reverseOrder());
		Collections.sort(fruitsSorted);
		System.out.println("initial sort check");		
		System.out.println(fruits.equals(fruitsSorted));
		
		//ascending sort check
		WebElement vegColTitle = cdriver.findElement(By.cssSelector("#sortableTable thead tr th:nth-child(2)"));
		vegColTitle.click();
		vegColTitle.click();
		Thread.sleep(2000L);
		
		//get elements from second column of table after sorting asc
		cols = tbody.findElements(By.cssSelector("tr td:nth-child(2"));
				
				
		//store element text in array list
		fruits = new ArrayList<String>();
		for (WebElement fruit:cols) {
			fruits.add(fruit.getText());
		}
		
		System.out.println("Asc sort check");		
		System.out.println(fruits.equals(fruitsSorted));
		
		
		//descending sort check
		vegColTitle.click();
		Thread.sleep(2000L);
		
		//get elements from second column of table after sorting asc
		cols = tbody.findElements(By.cssSelector("tr td:nth-child(2"));
				
				
		//store element text in array list
		fruits = new ArrayList<String>();
		for (WebElement fruit:cols) {
			fruits.add(fruit.getText());
		}
		Collections.sort(fruitsSorted, Collections.reverseOrder());
		System.out.println("desc sort check");		
		System.out.println(fruits.equals(fruitsSorted));		

	}

}
