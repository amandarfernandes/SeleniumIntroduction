package elements;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIElementsAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		String site = "https://rahulshettyacademy.com/AutomationPractice/";
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get(site);
		//select check box and get the label
		d.findElement(By.cssSelector("#checkBoxOption2")).click();
		String selectedOption = d.findElement(By.xpath("//input[@id= 'checkBoxOption2']//parent::label")).getText();
		
		//Choose label selected above from drop down 
		Select select = new Select(d.findElement(By.cssSelector("#dropdown-class-example")));
		select.selectByVisibleText(selectedOption);
		
		
		//enter above string in text box and select button
		d.findElement(By.id("name")).sendKeys(selectedOption);
		d.findElement(By.id("alertbtn")).click();
		String mesg = d.switchTo().alert().getText();
		Assert.assertTrue(mesg.contains(selectedOption));
		d.switchTo().alert().accept();
		d.quit();
		

	}

}
