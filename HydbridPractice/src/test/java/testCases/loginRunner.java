package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilties.Excelreader;

public class loginRunner {
	
	public static WebDriver driver;
	
	@Test
	public void objectRunner() throws IOException, InterruptedException
	{
		Excelreader.excelsheetReader();
		
		for (int iRow=1; iRow<4; iRow++)
		{
			String cellValue=Excelreader.cellReader(iRow, 6);
			
			if(cellValue.equals("OpenBrowser"))
			{
				objectReader.OpenBrowser();
			}
			else if(cellValue.equals("Login"))
			{
				objectReader.Login();
			}
			else if(cellValue.equals("Password"))
			{
				objectReader.Password();
			}
			else if(cellValue.equals("Logout"))
			{
				objectReader.Logout();
			}
		}
		
		System.out.println("This is a practice");
	}

}
