package variousConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable 
{
	WebDriver driver ;
	
	@Test
	public void webTable()
	{
//		String berfore_xpath= "//tbody/tr[";		
//		String after_xpath ="]/td[3]";
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.cssSelector("#side-menu>li:nth-child(3)")).click();
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/ul/li[2]/a")).click();
		
		List<WebElement> lists = driver.findElements(By.xpath("//tbody/tr"));
		ArrayList<String> names = new ArrayList<String>();
		
		//fetch the record from lists to put in namelists1 then add to the empty array names of first page, 
		//so we have to go second page and repeat same steps, for this click on next buttton
		for (WebElement namelist1 : lists) 
		{
			names.add(namelist1.getText());
		}
		String nextbtn =driver.findElement(By.xpath("//a[@data-page='next']/parent::li")).getAttribute("class");
		while(!nextbtn.contains("disabled"))
		{
			driver.findElement(By.xpath("//a[@data-page='next']")).click();
			lists=driver.findElements(By.xpath("//tbody/tr"));
			for (WebElement namelist1 : lists) 
			{
				names.add(namelist1.getText());
			}
			
			nextbtn=driver.findElement(By.xpath("//a[@data-page='next']/parent::li")).getAttribute("class");
		}
		
		for (String nm : names) {
			System.out.println(nm);
		}		
		
		for(int i=0;i<=lists.size();i++)
		{
			String nep = names.get(i);
			
			System.out.println(nep.toString());
		}		  
	}
	
	@AfterTest
	public void teardwon()
	{
		//driver.close();
	}

}

//footable-page-arrow
//a[@data-page='next']
//a[@data-page='next']/parent::li