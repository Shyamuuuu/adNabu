package adNabu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {

	public static WebDriver driver;
	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shyam\\Desktop\\ADNABU\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://adnabu-arjun.myshopify.com");

		driver.manage().window().maximize();

	}

		@Test
		public void addToCart() throws InterruptedException  {
		//Search field
		
		driver.findElement(By.cssSelector("header > .header__search ")).click();
		driver.findElement(By.cssSelector("[open] [type='search']")).sendKeys("bloom");
		driver.findElement(By.
				cssSelector(".header--has-localizations > .header__search:nth-child(2) [role] [aria-label='Search'] [aria-hidden]")).click();

		//select product
		driver.findElement(By.cssSelector("li:nth-of-type(2) .card__heading.h5 > .full-unstyled-link")).click();
		driver.findElement(By.cssSelector(".product-form__submit")).click();

		//thread sleep
		Thread.sleep(2000);

		//exit button
		driver.findElement(By.cssSelector(".cart-notification__header [href]")).click();

		//catalog button
		driver.findElement(By.cssSelector("#HeaderMenu-catalog span")).click();

		//selecting product
		driver.findElement(By.cssSelector("li:nth-of-type(4) .card__heading.h5 > .full-unstyled-link")).click();

		//add to cart again
		driver.findElement(By.cssSelector(".product-form__submit")).click();

		//thread sleep
		Thread.sleep(2000);

		//go to add to cart page
		driver.findElement(By.cssSelector("a#cart-icon-bubble  path")).click();

		//remove item
		driver.findElement(By.cssSelector("[aria-label='Remove 18k Wire Bloom Earrings'] .icon-remove")).click();
		System.out.println("Add to cart functionality is working fine");

	}

		@AfterTest
		public void end() {
			driver.quit();
		}
}
