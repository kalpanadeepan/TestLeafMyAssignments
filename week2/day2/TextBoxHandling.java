package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementName = driver.findElement(By.xpath("//input[@id='j_idt88:name']"));
		elementName.sendKeys("KalpanaSelvaraj");
		
		WebElement elementCountry=driver.findElement(By.xpath("//input[@value='Chennai']"));
		String text=elementCountry.getText();
		elementCountry.sendKeys(text+" India");
		
		WebElement elementDisableCheck=driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled']"));
	      if(elementDisableCheck.getAttribute("disabled").equals("disabled"))
	      {
	    	  System.out.println("The textBox is Disabled");
	      }
	      else
	      {
	    	  System.out.println("The Textbox is enabled");
	      }
	     WebElement elementClearText=driver.findElement(By.xpath("//input[@value='Can you clear me, please?']"));
	     elementClearText.clear();
         elementClearText.sendKeys("How Are you Doing???");
		
		WebElement elementRetriveValue=driver.findElement(By.xpath("//input[@value='My learning is superb so far.']"));
		System.out.println("The Message is "+elementRetriveValue.getAttribute("value"));
		
		WebElement elementTab=driver.findElement(By.xpath("//input[@placeholder='Your email and tab']"));
		elementTab.sendKeys("abc@gmail.com",Keys.TAB);
		
		WebElement elementAboutYou=driver.findElement(By.xpath("//textarea[@placeholder='About yourself']"));
		elementAboutYou.sendKeys("I am Kalpana. I am From Coimbatore. I have 4 years Experience in IT industry. I am a selfmotivated person ");
		
		WebElement elementTextEditor=driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		elementTextEditor.sendKeys("This is Wonderful learning course");
		
		WebElement elementAge=driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']"));
		elementAge.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement elementErrorMsg=driver.findElement(By.xpath("//span[@class='ui-message-error-detail']"));
		String errorMsg=elementErrorMsg.getText();
		System.out.println("The error msg is "+errorMsg);
		
		
		WebElement elementLabelPosition=driver.findElement(By.xpath("//span[@class='ui-float-label']//input[@id='j_idt106:float-input']"));
		elementLabelPosition.click();
		WebElement elementMsg=driver.findElement(By.xpath("//span[@class='ui-float-label']/label[text()='Username']"));
		System.out.println("The elementMsg is "+elementMsg.getText());
		
		WebElement elementTyperName=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		elementTyperName.sendKeys("Kalpana");
		Thread.sleep(3000);
		
		
		WebElement elementButtonClick=driver.findElement(By.xpath("//input[@placeholder='Search']/following::button[@aria-label='Show Options']"));
		
		Actions builder=new Actions(driver) ;
		builder.moveToElement(elementButtonClick).perform();
		Thread.sleep(3000);
		for(int i=0;i<3;i++)
		{
			elementTyperName.sendKeys(Keys.DOWN);	
		}
		elementTyperName.sendKeys(Keys.ENTER);	
		
	
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		System.out.println("Type your DOB (mm/dd/yyyy) and confirm date chosen ");
		WebElement elementDatePicker=driver.findElement(By.xpath("//h5[text()='Type your DOB (mm/dd/yyyy) and confirm date chosen ']/following::input[1]"));
		elementDatePicker.sendKeys("28/02/1995");
		
		//Type number and spin to confirm value changed
		System.out.println("Type number and spin to confirm value changed");
		WebElement spin = driver.findElement(By.xpath("//h5[text()='Type number and spin to confirm value changed']/following::input[1]"));
		spin.sendKeys("6");
		WebElement elementDegcrement=driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-s']"));
		Thread.sleep(2000);
		elementDegcrement.click();
		
		String textDegreec=spin.getAttribute("value");
        System.out.println("Decremented value is "+textDegreec);
		
        WebElement elementIncrement=driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']"));
		Thread.sleep(2000);
		elementIncrement.click();
		
		String textInc=spin.getAttribute("value");
        System.out.println("Incremented value is "+textInc);
		
        
        //Type random number (1-100) and confirm slider moves correctly
        System.out.println("Type random number (1-100) and confirm slider moves correctly");
        Point location=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]")).getLocation();
        
        WebElement randomMoves = driver.findElement(By.xpath("//h5[text()='Type random number (1-100) and confirm slider moves correctly']/following::input[1]"));
        randomMoves.sendKeys("25");
        Point location2=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]")).getLocation();
        if(!location.equals(location2))
        {
        	System.out.println("The Position Changed ");
        }
        else
        {
        	System.out.println("The Position not Changed ");	
        }
        //Click and Confirm Keyboard appears
        System.out.println("Click and Confirm Keyboard appears");
        driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm Keyboard appears')]/following::input[1]")).click();
        boolean displayed = driver.findElement(By.xpath("//input[contains(@class,'ui-inputfield ui-keyboard-input ui-widget ui-state-default ui-corner-all is-keypad')]")).isDisplayed();
	   if(displayed)
		   System.out.println("Keyboard displayed");
	   else
       System.out.println("Keyboad not displayed");
	   
	   //Custom Toolbar
	   WebElement toolBar=driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]"));
	   toolBar.sendKeys("Kalpana TestLeaf");
	   
	   
	   
	
	}

}
