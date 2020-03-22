package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utlities.browserEngine;
import utlities.userData;

public class T01_logInValidationExcel {
	
	public static WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	
	@BeforeMethod
	public void browserSetUp()
	{
		driver=browserEngine.getBrowser("chrome");
		driver.get(userData.appURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void userLogIn() throws IOException, InterruptedException
	{
		File src=new File(userData.excelData);
		FileInputStream fis=new FileInputStream(src);
		
		workbook=new XSSFWorkbook(fis);
		
		sheet=workbook.getSheetAt(0);
		
		for(int i=1; i<sheet.getLastRowNum(); i=i+1)
		{
			cell=sheet.getRow(1).getCell(0);
			driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
			
			cell=sheet.getRow(1).getCell(1);
			driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("password")).clear();
			Thread.sleep(1000);
			
			cell=sheet.getRow(2).getCell(0);
			driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
			
			 cell=sheet.getRow(2).getCell(1);
			driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}
	
	

}
