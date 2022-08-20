package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Go to Dashboard Take me to dashboard
		
		System.out.println("Go to Dashboard");
		WebElement go = driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]"));
		go.click();
		System.out.println("The tile of given link "+driver.getTitle());
		
        driver.navigate().back();		

		//Find my destination Find the URL without clicking 
		System.out.println("Find my destination ");
		WebElement url = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']"));
		url.click();
		driver.navigate().back();
		
		
		//brokenLink
		System.out.println("BrokenLink ");
		WebElement brokenLink = driver.findElement(By.xpath("//a[text()='Broken?']"));
		brokenLink.click();
		String title=driver.getTitle();
		if(title.contains("Error 404 /lists.xhtml Not Found"))
		{
			System.out.println("The Link is Broken");
		}
		else
		{
			System.out.println("The Link is Valid");
		}
		driver.navigate().back();
		
		//Duplicate Link
		System.out.println("Duplicate Link ");
		List<WebElement> duplicateLink = driver.findElements(By.xpath("//a[text()='Go to Dashboard']"));
		driver.navigate().back();
		int size=duplicateLink.size();
		if(size>1)
		{
			System.out.println("The Link is Duplicate");
		}
		else
		{
			System.out.println("The Link Is not Duplicate");
		}
		driver.navigate().back();
		
		//Count Links
		System.out.println("Count Links");
		List<WebElement> countLinks=driver.findElements(By.tagName("a"));
		System.out.println("The Number of Links Available in this link "+countLinks.size());
		Thread.sleep(4000);
		//driver.navigate().back();
		
		//Count a links in this layout
		System.out.println("The count links in this layout ");
		driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
		
		driver.navigate().back();
		
		List<WebElement> layoutLinkCount=driver.findElements(By.tagName("a"));
		System.out.println("How many links in this layout? "+layoutLinkCount.size());
	}

}
