package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookXpath {
	public static void main(String[] args) {
		// Setup the driver
		WebDriverManager.chromedriver().setup();

		// Launch the Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the url
		driver.get("https://en-gb.facebook.com/");

		// Maximize the browser
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Click Create Account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Suganya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gopalakrishnan");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9886337375");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("rishikesh");
		driver.findElement(By.xpath("//span[@data-name='birthday_wrapper']//select")).sendKeys("24");
		driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Oct");
		driver.findElement(By.xpath("//select[@id='year']")).sendKeys("1991");
		driver.findElement(By.xpath("//label[contains(text(),Female)]")).click();
	}

}
