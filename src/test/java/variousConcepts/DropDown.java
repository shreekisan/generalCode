package variousConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown 
{
	
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
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[4]/a")).click();
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[4]/ul/li[2]/a")).click();
		/*
		 * List<WebElement> lists1 =
		 * driver.findElements(By.xpath("//div[@class='col-sm-10']/select/option"));
		 * for(WebElement i:lists1) { String sir =i.getText(); System.out.println(sir);
		 * }
		 */
		//  +++++++++++++++++++++++++++OR ++++++++++++++++++++++
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='cid']")));
		List<WebElement> lists1 = sel.getOptions();
		for(WebElement i:lists1) 
		{
			String sir = i.getText();
			System.out.println(sir);
		}
		
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		//driver.close();
	}

}
