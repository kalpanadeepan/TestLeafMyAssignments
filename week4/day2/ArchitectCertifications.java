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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
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

		// Enter the password as Password#123
		driver.findElement(By.id("password")).sendKeys("Password#123");

		// click on the login button
		driver.findElement(By.id("Login")).click();

		// click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();

		// Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Size of Window " + windowHandles.size());
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		// click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		// Click Resources and mouse hover on Learning On Trailhead
		Set<String> resourse = driver.getWindowHandles();
		System.out.println("Size " + resourse.size());
		List<String> lLearn = new ArrayList<String>(resourse);
		driver.switchTo().window(lLearn.get(1));

		driver.findElement(By.xpath("//a[text()='Resources']")).click();

		Shadow dom = new Shadow(driver);// for Shadow DOM Element

		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement learnTrailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");

		Actions builder = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(learnTrailHead));

		builder.moveToElement(learnTrailHead).perform();// Mouse Hover

		// Clilck on Salesforce Certifications
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();

		// Click on Ceritification Administrator
		driver.findElement(By.xpath("//div//a[text()='Administrator']")).click();

		// Navigate to Certification - Administrator Overview window
		// Verify the Certifications available for Administrator Certifications should
		// be displayed
		WebElement finalResult = driver.findElement(By.xpath(
				"//div[@class='certification-banner_title slds-container--medium slds-container--center slds-text-align--center']"));
		if (finalResult.getText().contains("Administrator")) {
			System.out.println("The Page Verified Successfully");
		} else {
			System.out.println("The Page not Verified Successfully");
		}

		driver.quit();
	}

}
