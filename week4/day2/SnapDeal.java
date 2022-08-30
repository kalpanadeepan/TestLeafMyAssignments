package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));

		Actions builder = new Actions(driver);
		builder.moveToElement(mens).perform();

		// Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		// Get the count of the sports shoes
		String text = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("count of the sports shoes " + text);

		// Click Training shoes
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();

		// Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();

		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();

		// Check if the items displayed are sorted correctly
		Thread.sleep(5000);
		List<WebElement> sortVal = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println("Sorted items size " + sortVal.size());

		List<String> list = new ArrayList<String>();

		System.out.println("The Sorted Values are ");
		for (WebElement webElement : sortVal) {

			String text1 = webElement.getText();
			list.add(text1);
			// builder.scrollToElement(webElement).perform();

		}
		System.out.println(list);

		// Select the price range (900-1200)
		Thread.sleep(3000);
		WebElement price = driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[1]"));
		price.clear();
		price.sendKeys("900", Keys.ENTER);
		WebElement priceTo = driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[2]"));
		priceTo.clear();
		priceTo.sendKeys("1200");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

		// verify the all applied filters
		String text2 = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText();
		System.out.println("Fillters applied " + text2);

		// Mouse Hover on first resulting Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		WebElement firstResult = driver.findElement(By.xpath("//img[@class='product-image ']"));
		builder.moveToElement(firstResult).perform();

		// click QuickView button
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();

		// Print the cost and the discount percentage
		String discount = driver.findElement(By.xpath("//span[@class='strikee ']")).getText();
		System.out.println("discount " + discount);
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost " + cost);
		String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Percentage " + percentage);

		// Take the snapshot of the shoes.
		WebElement snap = driver.findElement(By.xpath("//img[@slidenum='0']"));
		File src = snap.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/shoes.png");
		FileUtils.copyFile(src, des);

		// 15. Close the current window
		driver.close();
		// 16. Close the main window
		driver.quit();

	}

}
