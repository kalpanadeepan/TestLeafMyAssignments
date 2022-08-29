package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    WebDriverManager.chromedriver().setup();
			
//			ChromeOptions option = new ChromeOptions();
//	        option.addArguments("--disable-notifications");
	        
			ChromeDriver driver=new ChromeDriver();//01) Launch Edge / Chrome
			driver.manage().window().maximize();
			
		    driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		    
		    driver.switchTo().frame("iframeResult");
		    
		    driver.findElement(By.xpath("//button[text()='Try it']")).click();
		    
		    Alert alert=driver.switchTo().alert();
		    System.out.println("The Text is "+alert.getText());
		    alert.accept();
		    
		    String text = driver.findElement(By.xpath("//h2[text()='JavaScript Confirm Box']/following::p")).getText();
		    System.out.println("The reult is "+text);
		    
		    driver.switchTo().defaultContent();//to switch from Frame to Normal web page
		    

	}

}
