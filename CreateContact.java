package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	public static void main(String[] args) {
		// Setup the driver
				WebDriverManager.chromedriver().setup();
				// Launch the Browser
				ChromeDriver driver = new ChromeDriver();
				// Load the url
				driver.get("http://leaftaps.com/opentaps/control/login");
				// Maximize the browser
				driver.manage().window().maximize();
				
				//Login
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
                driver.findElement(By.xpath("//input[@value='Login']")).click();
                driver.findElement(By.xpath("//a[text()[normalize-space()='CRM/SFA']]")).click();
               
                //click on contacts tab
                driver.findElement(By.xpath("//a[text()='Contacts']")).click();
                driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
                //Enter the details
                driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Suganya");
                driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Gopalakrishnan");
                
                
                WebElement fname = driver.findElement(By.xpath("//input[@id='firstNameField']"));
                String firstname = fname.getAttribute("value");
                driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys(firstname);
                
                WebElement lname = driver.findElement(By.xpath("//input[@id='lastNameField']"));
                String lastname = lname.getAttribute("value");
                driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys(lastname);
                
                driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Sales");
                driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Representative of the sales team");
                driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("gsuganyakrishnan@gmail.com");
                
                //Select the state/province using visibletext
                WebElement dd = driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']"));
                Select dropdown = new Select(dd);
                dropdown.selectByVisibleText("New York");
                
                //Click Create Contact to submit the filled details
                driver.findElement(By.xpath("//input[@name='submitButton']")).click();
                
                //Click edit button
                driver.findElement(By.xpath("//a[text()='Edit']")).click();
                
                //Clear the Description field
                driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
                
                //Input text in the Important Note box
                driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("Important Info to be added");
                
                //Click update
                driver.findElement(By.xpath("//input[@value='Update']")).click();
                
                //Print the resulting page title
                String title = driver.getTitle();
                System.out.println(title);
                
                
                
                
                
	}

}
