package adNabu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchAndFilters {

	public static WebDriver driver;

	@BeforeTest

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shyam\\Desktop\\ADNABU\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://adnabu-arjun.myshopify.com");

		driver.manage().window().maximize();
	}
	@Test

	public void searchAndFilter() {
		//Search field
		driver.findElement(By.cssSelector("header > .header__search ")).click();
		driver.findElement(By.cssSelector("[open] [type='search']")).sendKeys("bloom");
		driver.findElement(By.
				cssSelector(".header--has-localizations > .header__search:nth-child(2) [role] [aria-label='Search'] [aria-hidden]")).click();

		//availability 
		driver.findElement(By.cssSelector(".facets__summary-label")).click();

		//Availability - In stock filter
		driver.findElement(By.
				cssSelector("[role='list']:nth-child(2) .facets__item:nth-of-type(1) .facet-checkbox [aria-hidden='true']:nth-child(4)")).click();


		//Sort By Filter
		Select dropDown = new Select(driver.findElement(By.id("SortBy")));
		dropDown.selectByValue("price-descending");

		System.out.println("Search and filter functionality is working fine");

	}
	@AfterTest
	public void end() {
		driver.quit();
	}



}


