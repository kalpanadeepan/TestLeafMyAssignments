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


public class AdministratorCertifications {

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
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(learnTrailHead));
		
		builder.moveToElement(learnTrailHead).perform();// Mouse Hover

		// Clilck on Salesforce Certifications
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();

		//  Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		
		//Get the Text(Summary) of Salesforce Architect 
		WebElement text = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div[1]"));
		System.out.println("text Summary"+text.getText());
		
		//Get the List of Salesforce Architect Certifications Available
		List<WebElement>  listOfSalesforce = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a[contains(text(),'Architect')]"));
		System.out.println("listOfSalesforce "+listOfSalesforce.size());
		System.out.println(" Salesforce Architect Certifications are ");
		for(WebElement i:listOfSalesforce)
		{
		System.out.println("-->"+i.getText());
		}     
		
		//Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		//Get the List of Certifications available
		List<WebElement> noOfCertifications = driver.findElements(By.xpath("//div[@class='credentials-card_title']//a"));
		System.out.println("noOfCertifications "+noOfCertifications.size());
		System.out.println("Certifications are ");
		for (WebElement webElement : noOfCertifications) {
			System.out.println("-->"+webElement.getText());
			
		}
		
		driver.quit();
	}

}
