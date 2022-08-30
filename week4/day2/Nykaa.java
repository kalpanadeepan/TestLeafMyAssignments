package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Mouseover on Brands and Search L'Oreal Paris
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();

		// Search L'Oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");

		// Click L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();

		// Check the title contains L'Oreal Paris(Hint-GetTitle)
		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("The Title Verified " + driver.getTitle());
		} else {
			System.out.println("The Title not Verified ");
		}

		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();

		// select customer top rated
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(3000);
		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();

		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		hair.click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		// Click->Concern->Color Protection
		WebElement color = driver.findElement(By.xpath("//span[text()='Concern']"));
		color.click();

		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("color");

		driver.findElement(By.xpath("//div//span[text()='Color Protection']")).click();

		// check whether the Filter is applied with Shampoo
		boolean selected = driver.findElement(By.xpath("//span[text()='Shampoo']")).isSelected();
		if (selected == true) {
			System.out.println("Filter is applied with Shampoo");
		} else {
			System.out.println("Filter is not applied with Shampoo");
		}

		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//a[@class='css-qlopj4']")).click();

		// GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("windowHandles size " + windowHandles.size());
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		Select s = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
		s.selectByIndex(0);

		// Print the MRP of the product

		WebElement mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
		String text = mrp.getText();
		System.out.println("The MRP is " + text.replaceAll("^0-9", text));

		// Click on ADD to BAG
		driver.findElement(By.xpath("(//button//span[text()='Add to Bag'])[1]")).click();

		// Go to Shopping Bag
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();

		WebElement frame = driver.findElement(By.className("css-acpm4k"));
		driver.switchTo().frame(frame);

		// Print the Grand Total amount
		String total = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		System.out.println("total " + total);
		Thread.sleep(3000);

		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();

		// Check if this grand total is the same in step 14
		String finalTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if (finalTotal.equals(total)) {
			System.out.println("The Value is same ");

		} else {
			System.out.println("The value is not same ");
		}

		driver.quit();

	}

}
