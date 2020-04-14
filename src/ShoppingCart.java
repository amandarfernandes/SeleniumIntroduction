import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium-work\\chromedriver.exe");
		WebDriver cdriver =  new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		cdriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Items to be added to shopping cart
		String[] items = {"Cucumber","Onion","Potato","Tomato"};
		
		
		addItemsToShoppingCart(cdriver, items);
		cdriver.findElement(By.cssSelector(".cart-icon")).click();
		cdriver.findElement(By.cssSelector("div.cart-preview.active>div.action-block>button")).click();
		
		
		cdriver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		cdriver.findElement(By.cssSelector(".promoBtn")).click();
		
		//explicit wait
		WebDriverWait driverWait  = new WebDriverWait(cdriver,5);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(cdriver.findElement(By.cssSelector(".promoInfo")).getText());		
	}

	public static void addItemsToShoppingCart(WebDriver driver, String[] items) {
		int remainingCartItems = items.length;
		//get all products in the shop
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		System.out.println(products.size());
		
		//get all "add to cart" buttons.
		System.out.println(driver.findElements(By.xpath("//div[@class='product-action']/button")).size());
		
		//iterate through product list
		for (int i=0;i<products.size();i++) {
			
			//Get just product name from the product text
			String product = products.get(i).getText().split(" - ")[0];
			
			//convert array to list to make searching easy
			List<String> cartItems = Arrays.asList(items);
			
			// if product is in shopping list, add it to the cart 
			// and reduce shopping list by 1
			// if shopping list is empty break out of loop
			
			if (cartItems.contains(product)) {
				remainingCartItems--;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (remainingCartItems <= 0) break;
			}
		}

	}
}
