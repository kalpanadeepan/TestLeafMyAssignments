package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		
		driver.manage().window().maximize();
		
		//Basic Checkbox
		System.out.println("Basic Checkbox");
		 boolean selected = driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).isSelected();
		 if(selected)
		 {
			 System.out.println("The select");
		 }else
		 { System.out.println("The not selected Then go and Check");
			 driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		 }
		 
		 //Notification
		 System.out.println("Notification");
		 boolean selectedAjax = driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']/following::span[text()='Ajax']")).isSelected();
		 if(selectedAjax)
		 {
			 System.out.println("The select");
		 }else
		 { System.out.println("The not selected Then go and Check");
			 driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']/following::span[text()='Ajax']")).click();
		 }
		 
		 //Choose your favorite language(s)
		 System.out.println("Choose your favorite language(s)");
		 driver.findElement(By.xpath("//label[text()='Java']")).click();//Java
		 driver.findElement(By.xpath("//label[text()='Python']")).click();//Python
		 
		 //Tri State Checkbox
		 System.out.println("Tri State Checkbox");
		 driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
		 
		 //Toggle Switch
		 System.out.println("Toggle Switch");
		 driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']")).click();
		 
		 //Verify if check box is disabled
		 System.out.println("Verify if check box is disabled");
		 boolean enabled = driver.findElement(By.xpath("//input[@disabled='disabled']")).isEnabled();
		 if(enabled)
		 {
			 System.out.println("The Enabled");
		 }
		 else
		 {
			 System.out.println("Disabled");
		 }
		 
		 //Select Multiple
		 System.out.println("Select Multiple");
		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		 driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
		 driver.findElement(By.xpath("(//label[text()='Berlin'])[2]")).click();

	}

}
