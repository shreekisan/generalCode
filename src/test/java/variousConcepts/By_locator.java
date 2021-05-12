package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class By_locator {
	
	WebDriver driver;

	@Test
	public void invalidUsersShouldBeAbleToLogIn() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://techfios.com/test/billing/?ng=login/");
		
		// storing web element using by class
		
		By username= By.xpath("//input[@id='username']");
		By password= By.xpath("//input[@id='password']");
		By signin= By.xpath("//button[@name='login']");
		
		driver.findElement(username).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(password).sendKeys("abc123");
		driver.findElement(signin).click();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		driver.close();
	}

}
