package elements;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DivTablesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		String site = "https://www.cricbuzz.com/live-cricket-scorecard/22758/ind-vs-sl-2nd-t20i-sri-lanka-tour-of-india-2020";
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(site);
		
		WebElement srilanka = d.findElement(By.xpath("//*[@id='innings_1']/div"));
		
		List<WebElement>players = srilanka.findElements(By.cssSelector(".cb-scrd-itms"));
		System.out.println(players.size());
		int score = 0;
		for (int i=0; i< players.size()-1;i++) {
			score = score + Integer.parseInt(players.get(i).findElement(By.className("text-bold")).getText());
		}
		
		System.out.println(score);
		int finalScore = Integer.parseInt(players.get(players.size()-1).findElement(By.className("text-bold")).getText());
		if (score == finalScore)
			System.out.println("Matches");
		else
			System.out.println("Does not match");
		//WebElement india = d.findElement(By.id("innings_2"));
		
		

	}

}
