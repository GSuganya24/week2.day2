package week2.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginACMETest {
	public static void main(String[] args) {
		// Setup the driver
				WebDriverManager.chromedriver().setup();

				// Launch the Browser
				ChromeDriver driver = new ChromeDriver();

				// Load the url
				driver.get("https://acme-test.uipath.com/login");
				
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
				driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
				
				//Get the title of the page and print
				String title = driver.getTitle();
				System.out.println("Title of the page :" +title);
				
				
				//Logout from the application
				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
				
				//Close the browser
				driver.close();
	}

}
