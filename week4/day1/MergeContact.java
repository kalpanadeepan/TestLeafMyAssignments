package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		// 2. Enter UserName and Password Using Id Locator
		WebElement elementUserNAme = driver.findElement(By.id("username"));
		elementUserNAme.sendKeys("Demosalesmanager");

		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		WebElement elementClick = driver.findElement(By.className("decorativeSubmit"));
		elementClick.click();

		// 4. Click on CRM/SFA Link
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();

		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// 7. Click on Widget of From Contact
		WebElement widget = driver.findElement(By.xpath("(//img[@src  ='/images/fieldlookup.gif']) [1]"));
		widget.click();

		Set<String> child = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(child);
		driver.switchTo().window(l.get(1));
		System.out.println("Title of To child window is " + driver.getTitle());
		driver.manage().window().maximize();
		// 8. Click on First Resulting Contact
		WebElement firtContact = driver.findElement(By.xpath("//td//a[@class='linktext']"));

		firtContact.click();
		driver.switchTo().window(l.get(0));
		System.out.println("Title of From child window is " + driver.getTitle());

		// 9. Click on Widget of To Contact
		WebElement widgetTo = driver.findElement(By.xpath("(//img[@src  ='/images/fieldlookup.gif']) [2]"));
		widgetTo.click();
		Thread.sleep(3000);

		Set<String> child1 = driver.getWindowHandles();
		List<String> ll = new ArrayList<String>(child1);

		// 10 Click on Second Resulting Contact
		driver.switchTo().window(ll.get(1));
		System.out.println("Title of To child window is " + driver.getTitle());
		driver.manage().window().maximize();

		WebElement toContact = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		toContact.click();
		Thread.sleep(3000);
		driver.switchTo().window(ll.get(0));
		System.out.println("Title of From child window is " + driver.getTitle());
		Thread.sleep(3000);

		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();

		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// 13. Verify the title of the page
		String title = driver.getTitle();
		if (title.contains("Merge Contacts"))
			System.out.println("Title Of Final Page reached " + title);
		else
			System.out.println("Title Not matched !!" + title);

	}

}
