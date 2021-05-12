package variousConcepts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDropDownInExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.createSheet("Test");
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement country = driver.findElement(By.tagName("select")); 
		Select sel = new Select(country);
		List<WebElement> list = sel.getOptions();
		
		
		for(int i=0;i<list.size();i++)
		{
			ws.createRow(i).createCell(0).setCellValue(list.get(i).getText());
		}
		
		String path = "resources\\dropdown.xlsx";
		File f = new File(path);
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		
	}

}
