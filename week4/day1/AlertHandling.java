package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		
//		ChromeOptions option = new ChromeOptions();
//        option.addArguments("--disable-notifications");
        
		ChromeDriver driver=new ChromeDriver();//01) Launch Edge / Chrome
		
		driver.get("https://www.leafground.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[text()='Browser']/ancestor::a")).click();
		
        driver.findElement(By.xpath("//span[text()='Alert']/ancestor::a")).click();
        
        //Alert (Prompt Dialog)
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[5]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();
        
        //Alert (Confirm Dialog)
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[2]")).click();
        Alert alert1 = driver.switchTo().alert();
        String text = alert1.getText();
        System.out.println("Text is "+text);
        alert1.accept();
        
        //Alert (Simple Dialog)
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[1]")).click();
        Alert alertSimple = driver.switchTo().alert();
        String text1 = alert1.getText();
        System.out.println("Text is "+text1);
        alertSimple.accept();
        
        //Sweet Alert (Confirmation)
        driver.findElement(By.xpath("(//span[text()='Delete']/ancestor::button)[1]")).click();
        WebElement sweet = driver.findElement(By.xpath("(//span[text()='Yes']/ancestor::button)[1]"));
        String text2 = sweet.getText();
        System.out.println("Sweet Alert Text is "+text2);
        sweet.click();
        
        
        //Sweet Alert (Simple Dialog)
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[3]")).click();
        WebElement sweetSimple = driver.findElement(By.xpath("(//span[text()='Dismiss']/ancestor::button)[1]"));
        String text3 = sweetSimple.getText();
        System.out.println("Sweet Alert Text is "+text3);
        sweetSimple.click();
        
        //Minimize and Maximize
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[6]")).click();
       
        WebElement sweetMinMax = driver.findElement(By.xpath("//span[text()='Min and Max']/following::P"));
        String text4 = sweetMinMax.getText();
        System.out.println("Sweet Alert Text is "+text4);
        sweetMinMax.click();
        
        //Sweet Modal Dialog
        driver.findElement(By.xpath("(//span[text()='Show']/ancestor::button)[5]")).click();
        WebElement sweetModel = driver.findElement(By.xpath("(//span[text()='Dismiss']/ancestor::button)[1]"));
        String text5 = sweetModel.getText();
        System.out.println("Sweet Alert Text is "+text5);
        sweetSimple.click();

	}

}
