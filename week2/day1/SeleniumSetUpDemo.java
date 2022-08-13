package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSetUpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();//To add Driver to the code
		
		ChromeDriver driver = new ChromeDriver();//Open a browser
		
		driver.manage().window().maximize();//To maximize the browser window
		
		driver.get("http://leaftaps.com/opentaps");//To load URL
		
		driver.close();//To close the current browser

	}

}
