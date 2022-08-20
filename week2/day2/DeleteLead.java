package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*http://leaftaps.com/opentaps/control/main

Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/
public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();//Click on Phone
		
		WebElement elementMobileNumber= driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		elementMobileNumber.sendKeys("123456789");//Enter phone number
		Thread.sleep(3000);
		
		WebElement elementFindLeadClick=driver.findElement(By.xpath("//em[@unselectable='on']//button[text()='Find Leads']"));//click find leads
		elementFindLeadClick.click();
		Thread.sleep(3000);
		
		WebElement elementCaptureLeadID=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));//Capture lead ID of First Resulting lead
		String leadID=elementCaptureLeadID.getText();
		System.out.println("leadID "+leadID);
		
		WebElement elementClickFirstLead=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));//Capture lead ID of First Resulting lead
		elementClickFirstLead.click();//Click First Resulting lead
		
		 WebElement elementLeadDeleted=driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']"));
		 elementLeadDeleted.click();//Click Delete	
		 
		 WebElement elementFindLeadDeleted=driver.findElement(By.xpath("//a[text()='Find Leads']"));
		 elementFindLeadDeleted.click();
		 Thread.sleep(3000); //Click Find leads
		 
		 WebElement elementCapturedID=driver.findElement(By.xpath("(//div[@class='x-form-element'])[18]/input"));
		 elementCapturedID.sendKeys(leadID);//15	Enter captured lead ID
		 
		 WebElement elementAfterDeleteLead=driver.findElement(By.xpath("//em[@unselectable='on']//button[text()='Find Leads']"));//click find leads
		 elementAfterDeleteLead.click();
		 Thread.sleep(3000);//	 16	Click find leads button
		 
		 WebElement elementFinalMessage=driver.findElement(By.xpath("//div[text()='No records to display']"));
		 String Result =elementFinalMessage.getText();
		 System.out.println("The Final Result is :: "+Result);//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	
		 }

}
