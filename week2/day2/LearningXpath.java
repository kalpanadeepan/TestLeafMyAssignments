package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");

		WebElement elementUserNAme = driver.findElement(By.xpath("//input[@id='username']"));
		elementUserNAme.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");

		WebElement elementClick = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementClick.click();

		WebElement elementLoginSuccess = driver.findElement(By.xpath("//div[@id='form']/h2"));
		String text = elementLoginSuccess.getText();
		
		if (text.contains("Welcome"))
			System.out.println("Login Success");
		else
			System.out.println("Login Failed");

		WebElement elementCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		elementCRMSFA.click();

		WebElement elementLeads = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		elementLeads.click();

		WebElement elementCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		elementCreateLead.click();

		WebElement elementCompanyName = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
		elementCompanyName.sendKeys("TestLeaf");

		WebElement elementFirstName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
		elementFirstName.sendKeys("Kalpana");

		WebElement elementLastName = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
		elementLastName.sendKeys("Deepan");
		
		WebElement elementDepartmentName = driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']"));
		elementDepartmentName.sendKeys("ComputerScience");

		WebElement elementDescription = driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']"));
		elementDescription.sendKeys("Wonderful Job Done By TestLeaf !!!");

		WebElement elementEmailID = driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']"));
		elementEmailID.sendKeys("kalpanakalps1828@gmail.com");
		
		WebElement elementCreateButton = driver.findElement(By.xpath("//input[@class='smallSubmit']"));
		elementCreateButton.click();
		System.out.println("The Title Of the Result page is " + driver.getTitle());



	}

}
