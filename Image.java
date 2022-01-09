package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {
	public static void main(String[] args) {
	// Setting the Chrome Driver
			WebDriverManager.chromedriver().setup();
			// Launch the browser
			ChromeDriver driver = new ChromeDriver();

			// Load the url
			driver.get("http://www.leafground.com/pages/Image.html");
			//Click on the image to go to homepage
			driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
			//Click on Image button
			driver.findElement(By.xpath("//h5[text()='Image']")).click();
			//Click on Am I broken Image
			driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img")).click();
			//click me using the mouse or keyboard
			driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();
			
}
}
