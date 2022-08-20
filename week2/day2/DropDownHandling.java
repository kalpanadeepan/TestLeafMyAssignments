package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementFavoriteTool=driver.findElement(By.xpath("//h5[text()='Which is your favorite UI Automation tool?']/following::select[1]"));
        
		Select favTool=new Select(elementFavoriteTool);
		favTool.selectByVisibleText("Selenium");
		
		
		WebElement eleCountry=driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
		eleCountry.click();
		
		WebElement favCountry = driver.findElement(By.xpath("//li[text()='India']"));
		favCountry.click();
		Thread.sleep(3000);

		WebElement citiesBelongsToCountry=driver.findElement(By.xpath("//label[text()='Select City']"));
		citiesBelongsToCountry.click();
		Thread.sleep(3000);
		WebElement favCity=driver.findElement(By.xpath("//li[text()='Chennai']"));
		Thread.sleep(3000);
    	favCity.click();

		WebElement favCourseHead=driver.findElement(By.xpath("//button[@class='ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only']"));
		favCourseHead.click();
		Thread.sleep(3000);
	    WebElement favCourse = driver.findElement(By.xpath("//li[text()='JMeter']")); 
	    Thread.sleep(3000);
	    favCourse.click();Thread.sleep(3000);
	    favCourseHead.click();Thread.sleep(3000);
	    WebElement favCourse1 = driver.findElement(By.xpath("//li[text()='AWS']")); 	   
	    Thread.sleep(3000);favCourse1.click();
	    
	    WebElement favLanguageHead=driver.findElement(By.xpath("//label[text()='Select Language']"));
	    favLanguageHead.click();
	    Thread.sleep(3000);
	    WebElement favLanguage=driver.findElement(By.xpath("//li[text()='Tamil']"));
	    favLanguage.click();
	    Thread.sleep(3000);
	    
	    
	    WebElement favDiffLanguageHead=driver.findElement(By.xpath("//label[text()='Select Values']"));	
	    favDiffLanguageHead.click();
	    Thread.sleep(3000);
	    WebElement favDiffLanguage=driver.findElement(By.xpath("//li[text()='இரண்டு']"));
	    Thread.sleep(3000);
	    favDiffLanguage.click();
	    
	    
	    
	    
	}

}
