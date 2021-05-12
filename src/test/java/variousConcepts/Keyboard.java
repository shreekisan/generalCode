package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://techfios.com/test/billing/?ng=login/");
		
		// storing web element using by class
		
		//By username= By.xpath("//input[@id='username']");
		
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Keys.SHIFT + "a");
		 
		 WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		 WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		 WebElement submit = driver.findElement(By.xpath("//*[@name='login']"));
		 
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;');" ,username);
//		 js.executeScript("arguments[0].setAttribute('style','background:red; border: 2px solid red;');" ,password);
//		 js.executeScript("arguments[0].setAttribute('style','background:blue; border: 2px solid red;');" ,submit);
		 
		 Keyboard kw = new Keyboard();
		 kw.highlightElements(username);
		 kw.highlightElements(password);
		 kw.highlightElements(submit);
		 
		 
	} 
	public void highlightElements(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;');" ,element);
	}

}
