package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintErrorMessage {
	WebDriver driver;

	@Test
	public void invalidUsersShouldBeAbleToLogIn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Go to TechFios Website
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// Type username in the username field
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		// Type password in the password field
		driver.findElement(By.name("password")).sendKeys("abc12");
		// Click on Sign In button
		driver.findElement(By.name("login")).click();
		
		
		String text = driver.findElement(By.xpath("//div[@class='alert alert-danger fade in']")).getText();
		Assert.assertEquals("×\n" + "Invalid Username or Password",text, "Test is failed"); 
		//if test is passed no message display but if test failed message is displayed "test is failed".
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
