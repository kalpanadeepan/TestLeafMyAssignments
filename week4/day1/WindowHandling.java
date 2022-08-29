package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://leafground.com/window.xhtml");

		// Click and Confirm new Window Opens
		System.out.println("Tittle of Curret Page " + driver.getTitle());
		WebElement openWindow = driver.findElement(By.xpath("//span[text()='Open']"));
		openWindow.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));
		System.out.println("Tittle of Child Page " + driver.getTitle());
		driver.close();
		driver.switchTo().window(l.get(0));

		// Find the number of opened tabs
		WebElement openedTabs = driver.findElement(By.xpath("//span[text()='Open Multiple']"));
		openedTabs.click();
		Set<String> openTabs = driver.getWindowHandles();
		List<String> ll = new ArrayList<String>(openTabs);
		int len = openTabs.size();
		System.out.println("Number of Opened Windows " + len);
		driver.switchTo().window(ll.get(1));
		driver.switchTo().window(ll.get(0));
		System.out.println("Tittle of parent opened tabs Page " + driver.getTitle());

		// Close all windows except Primary
		WebElement closeWindow = driver.findElement(By.xpath("//span[text()='Close Windows']"));
		closeWindow.click();
		Set<String> closeTabs = driver.getWindowHandles();
		List<String> close = new ArrayList<String>(closeTabs);
		int lenClose = closeTabs.size();
		System.out.println("lenClose " + lenClose);
		for (String each : close) {
			if (each != close.get(0)) {
				driver.switchTo().window(each);
				driver.close();
			} 
		}
		driver.switchTo().window(close.get(0));

		// Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	   driver.quit();

	}

}
