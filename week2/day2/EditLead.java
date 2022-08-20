package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*http://leaftaps.com/opentaps/control/main		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)*/
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");//1	Launch the browser

		WebElement elementUserNAme = driver.findElement(By.xpath("//input[@id='username']"));
		elementUserNAme.sendKeys("Demosalesmanager");//2 Enter the username
		
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");//3	Enter the password

		WebElement elementClick = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementClick.click();//4 Click Login

		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();// 5 Click crm/sfa link
		
		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();//6 Click Leads link  
  
		WebElement elementFindLeads = driver.findElement(By.xpath("//a[text()='Find Leads']"));
		elementFindLeads.click(); //7 Click Find leads
		Thread.sleep(30);		
		
		WebElement elementFirstName=driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input[1]"));     
        //elementFirstName.click();		
		elementFirstName.sendKeys("babu");	

	    WebElement elementFindLeadsClick = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		elementFindLeadsClick.click();//9 Click Login
		
		Thread.sleep(3000);
		WebElement elementFindLeadsClickfirst = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		elementFindLeadsClickfirst.click();//10 Click on first resulting lead
		
		System.out.println("The Title Of the Result page is " + driver.getTitle());//	11 Verify title of the page
		
		WebElement elementEditClick=driver.findElement(By.xpath("//div[@class='frameSectionExtra']//a[text()='Edit']"));
		elementEditClick.click();// 12 Click Edit
		
		WebElement elementChangeCompany=driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		elementChangeCompany.clear();
		elementChangeCompany.sendKeys("TestLeafEdited");//13 Change the company name
		
		String elementUpdateName="TestLeafEdited";
		System.out.println("The Updated Company name is "+elementUpdateName);
		
		WebElement elementClickUpdate=driver.findElement(By.xpath("//input[@value='Update']"));
		elementClickUpdate.click();//14 Click Update
		
		//15 Confirm the changed name appears		
		WebElement compareUpdatedName= driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		
		
		String compareUpdatedNamestr=compareUpdatedName.getText();
		System.out.println("The Compare the Company name is "+compareUpdatedNamestr);
		
	}
	

}
