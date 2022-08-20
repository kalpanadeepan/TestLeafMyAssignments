package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in/");

		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MS", Keys.TAB);

		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("PDY", Keys.TAB);
		driver.findElement(By.xpath("//label[@for='chkSelectDateOnly']")).click();

		List<WebElement> elementsOfRows = driver.findElements(
				By.xpath("//div[@id='divMain']//table[@class='DataTable TrainList TrainListHeader']//tbody//tr"));

		System.out.println("elementsOfRows::: " + elementsOfRows.size());

		List<WebElement> elementsColoumns = driver.findElements(
				By.xpath("//div[@id='divMain']//table[@class='DataTable TrainList TrainListHeader']//tbody//tr//td"));

		System.out.println("elementsColoumns:: " + elementsColoumns.size());

		for (int i = 1; i < elementsOfRows.size(); i++) {
			for (int j = 1; j <= 9; j++) {
				String Text = driver.findElement(
						By.xpath("//div[@id='divMain']//table[@class='DataTable TrainList TrainListHeader']//tbody//tr["
								+ i + "]//td[" + j + "]"))
						.getText();
				System.out.print(Text + "          ");

			}
			System.out.println();
		}

	}

}
