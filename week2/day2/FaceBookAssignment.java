package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://en-gb.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();

		WebElement elementFirstName = driver.findElement(By.xpath("//input[contains(@name,'firstname')]"));
		elementFirstName.sendKeys("Kalpana");

		WebElement elementLastName = driver.findElement(By.xpath("//input[contains(@name,'lastname')]"));
		elementLastName.sendKeys("Deepan");

		WebElement elementMobileNumber = driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]"));
		elementMobileNumber.sendKeys("97232312313");

		WebElement elementPassword = driver.findElement(By.xpath("//input[contains(@id,'password_step_input')]"));
		elementPassword.sendKeys("xyz@123");

		WebElement elementDateOfBirthDay = driver
				.findElement(By.xpath("//div[contains(@id,'birthday_wrapper')]//select[contains(@id,'day')]"));
		Select day = new Select(elementDateOfBirthDay);
		day.selectByValue("28");

		WebElement elementDateOfBirthMonth = driver
				.findElement(By.xpath("//div[contains(@id,'birthday_wrapper')]//select[contains(@id,'month')]"));
		Select month = new Select(elementDateOfBirthMonth);
		month.selectByValue("2");

		WebElement elementDateOfBirthYear = driver
				.findElement(By.xpath("//div[contains(@id,'birthday_wrapper')]//select[contains(@id,'year')]"));
		Select year = new Select(elementDateOfBirthYear);
		year.selectByValue("1995");

		WebElement elementGender = driver
				.findElement(By.xpath("//span[contains(@data-name,'gender_wrapper')]//input[@value='1']"));
		elementGender.click();

		driver.close();

	}

}
