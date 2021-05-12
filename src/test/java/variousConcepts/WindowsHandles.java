package variousConcepts;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandles 
{
	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		
		
		/*
		 * for(String i : driver.getWindowHandles()) { //System.out.println(i);
		 * driver.switchTo().window(i); }
		 */
		// +++++++++++++++OR+++++++++++++++++++++++++++
		int num_windows =driver.getWindowHandles().size();
		System.out.println(num_windows);
		Iterator<String> win_iterator = driver.getWindowHandles().iterator();
		String parent_id = win_iterator.next();
		System.out.println(parent_id);
		
		while (win_iterator.hasNext())
		{
			driver.switchTo().window(win_iterator.next());
			String title = driver.getTitle();
			System.out.println(title);
			
		}
		
		driver.switchTo().window(parent_id);
	}
}
