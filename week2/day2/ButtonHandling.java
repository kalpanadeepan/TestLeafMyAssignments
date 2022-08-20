package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ButtonHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/button.xhtml");
		
		driver.manage().window().maximize();
		
		WebElement elementClick=driver.findElement(By.xpath("//span[text()='Click']"));
		elementClick.click();
		
		if (driver.getTitle().contains("Dashboard")) {
			System.out.println("The title is confirmed as Dashboard");
		}else
		{
			System.out.println("The Tile is not confirmed");
		}
		
		driver.navigate().back();
		
		WebElement elementDisabledCheck=driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following::button[1]"));
		String elementDisabled=elementDisabledCheck.getAttribute("disabled");
		if(elementDisabled.equals("true"))
		System.out.println("Button Element Disabled");
		else
			System.out.println("The button is not disabled");
		
		WebElement elementPosition=driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/following::button[1]"));
		System.out.println("The Position of element :: "+elementPosition.getLocation());
		
		WebElement elementButtonColor=driver.findElement(By.xpath("//h5[text()='Find the Save button color']/following::button[1]"));
		System.out.println("Button Color is "+elementButtonColor.getCssValue("color"));
		
		WebElement elementWidthAndHeight=driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']/following::button[1]"));
		System.out.println("The Height of button is "+elementWidthAndHeight.getSize().getHeight());
		System.out.println("The Width of button is "+elementWidthAndHeight.getSize().getWidth());
		
		WebElement elementMouseOverChange=driver.findElement(By.xpath("//h5[text()='Mouse over and confirm the color changed']/following::button[1]/span"));
		System.out.println("The color after Mouse over "+elementMouseOverChange.getAttribute("style"));
		Thread.sleep(2000);
		
		WebElement elementImageDisabled=driver.findElement(By.xpath("//span[text()='Image']/parent::button"));
		System.out.println("The image is not displayed "+elementImageDisabled.getAttribute("aria-expanded"));
		elementImageDisabled.click();
		Thread.sleep(2000);

		if(elementImageDisabled.getAttribute("aria-expanded").equals("true"))
		System.out.println("The Button clicked image is displayed ");
		else
		{
			System.out.println("The image is not displayed ");
		}
		List<WebElement>elementNoOfButtons=driver.findElements(By.xpath("//h5[text()='How many rounded buttons are there?']/following::button"));
		System.out.println("The Number Of Buttons are "+elementNoOfButtons.size());
		
		
		
		
	}

}
