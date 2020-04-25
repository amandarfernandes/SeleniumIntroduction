package elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InputsVerification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");

		WebDriver cDriver = new ChromeDriver();
		cDriver.get(" https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Check box validations
		WebElement student = cDriver.findElement(By.cssSelector("input[id*='chk_IndArm']"));
		Assert.assertFalse(student.isSelected());
		System.out.println("Checkbox is not selected");
		student.click();
		Assert.assertTrue(student.isSelected(),"Checkbox is selected");
		System.out.println("Checkbox is selected");
		System.out.println(cDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Simple HTML Select dropdown
		Select s = new Select(cDriver.findElement(By.cssSelector("select[id*='DropDownListCurrency']")));
		s.selectByValue("USD");
		Assert.assertEquals(s.getFirstSelectedOption().getText(),"USD");
		//more complicated drop down not a select form item
		WebElement pax = cDriver.findElement(By.cssSelector("div#divpaxinfo"));
		pax.click();
		Thread.sleep(3000L);
		cDriver.findElement(By.id("hrefIncAdt")).click();
		System.out.println(cDriver.findElement(By.cssSelector("#spanAudlt")).getText());
		System.out.println(pax.getText());
		Thread.sleep(2000L);
		for (int i=0;i<3;i++) {
			cDriver.findElement(By.id("hrefIncChd")).click();
		}
		
		System.out.println(cDriver.findElement(By.cssSelector("#spanChild")).getText());
		System.out.println(pax.getText());
		
		//Dynamic Drop downs
		
		cDriver.findElement(By.cssSelector("input[id*='originStation1']")).click();
		cDriver.findElement(By.cssSelector("a[value='BOM']")).click();
		Thread.sleep(2000L);
		cDriver.findElement(By.xpath("//div[contains(@id,'destinationStation1')] //a[@value='GOI']")).click();
	
		//Auto suggestive drop downs
		
		
		//calendar 
		cDriver.findElement(By.className("ui-state-highlight")).click();
		Thread.sleep(2000L);
		System.out.println(cDriver.findElement(By.cssSelector("[id*='view_date1']")).getAttribute("value"));		
	}

}
