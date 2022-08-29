package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the username as ramkumar.ramaiah@testleaf.com
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		// 4. Enter the password as Password#123
		driver.findElement(By.id("password")).sendKeys("Password#123");

		// 5.click on the login button
		driver.findElement(By.id("Login")).click();

		// 6.click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();

		// 7.Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Size of Window " + windowHandles.size());
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		// 8.click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		// 9.Get the title
		System.out.println("Title::: " + driver.getTitle());

		// 10.Get back to the parent window
		driver.switchTo().window(l.get(0));

		// 11.close the browser
		driver.quit();

	}

}
