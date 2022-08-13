package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");

		WebElement elementUserNAme = driver.findElement(By.id("username"));
		elementUserNAme.sendKeys("Demosalesmanager");

		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");

		WebElement elementClick = driver.findElement(By.className("decorativeSubmit"));
		elementClick.click();

		WebElement elementLoginSuccess = driver.findElement(By.tagName("h2"));
		String text = elementLoginSuccess.getText();

		if (text.contains("Welcome"))
			System.out.println("Login Success");
		else
			System.out.println("Login Failed");

		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();

		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();

		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();

		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys("TestLeaf");

		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys("Kalpana");

		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys("Deepan");

		WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		elementFirstNameLocal.sendKeys("kalpanaDeepan");

		WebElement elementDepartmentName = driver.findElement(By.id("createLeadForm_departmentName"));
		elementDepartmentName.sendKeys("ComputerScience");

		WebElement elementDescription = driver.findElement(By.id("createLeadForm_description"));
		elementDescription.sendKeys("Wonderful Job Done By TestLeaf !!!");

		WebElement elementEmailID = driver.findElement(By.id("createLeadForm_primaryEmail"));
		elementEmailID.sendKeys("kalpanakalps1828@gmail.com");

		WebElement elementcreateLead = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select dd = new Select(elementcreateLead);
		dd.selectByVisibleText("New York");

		WebElement elementCreateButton = driver.findElement(By.className("smallSubmit"));
		elementCreateButton.click();
		System.out.println("The Title Of the Result page is " + driver.getTitle());

		driver.close();

	}

}
