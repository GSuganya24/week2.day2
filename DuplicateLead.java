package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
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

		// Click Email tab
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// Enter Email address
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']"))
				.sendKeys("gsuganyakrishnan@gmail.com");

		// then click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(1000);
		
		//Capture name of the first resulting lead
		String fLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		System.out.println(fLead);
		
		//Click first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//click the duplicate lead button
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		String title = driver.getTitle();
		System.out.println("Title : " +title);
		
		//Click the create lead button
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		Thread.sleep(2000);
		
		//Get the first name
		String fName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(fName);
		
		
		
		//Check whether both the names are same
		if (fLead.equalsIgnoreCase(fName)) {
			System.out.println("Duplicated lead name is same as captured name");
		}
		else {
			System.out.println("Duplicated lead name is not same as captured name");
		}
		//Close the browser
		driver.close();


	}
}
