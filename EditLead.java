package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
		// Setting the Chrome Driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Load the url
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@class='inputLogin' and @id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[text()[normalize-space()='CRM/SFA']]")).click();// To eliminate space
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// click Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Enter the first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']")).sendKeys("Suganya");
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		
		//Click the first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Verify Title of the page
		String title = driver.getTitle();
        System.out.println("The tile of the page is : "+title);
		if(title.contains("Lead")) {
			System.out.println("I confirmed the title");
		}else {
			System.out.println("The title doesnot have the title");
		}
		
		
		//Click the edit button
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Edit']")).click();
		
		//Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Hindustan");
		
		//Click update
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		
		//Verify the Company name
		String Verify = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(Verify);
		
		//Close the browser
		driver.close();
	}

}
