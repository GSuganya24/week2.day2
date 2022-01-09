package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		// Setup the driver
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

		// click Phone tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9886337375");

		// then click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(1000);

		// Getting the first lead id and printed

		WebElement lead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String leadID = lead.getText();
		System.out.println(leadID);
		
		//We can directly use like this also instead of the first two lines
		//String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
		

		// Click the first lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Delete the first resulting id
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		// Then click find elements
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter captured id and click find leads
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input")).sendKeys(leadID);
		//can use the parent field reference if the actual field locator doesn't accept the input

		// then click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);

		// Verify 'No records found message' and close the browser
		String result = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor' ]//div")).getText();
		System.out.println(result);
		driver.close();

	}

}
