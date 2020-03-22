package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilties.data;


public class objectReader {
	
	public static WebDriver driver;
	
	public static void OpenBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Digital Point\\Automation\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://video.digitalpoint.tech/");
		driver.findElement(By.linkText("USER LOGIN")).click();
		Thread.sleep(3000);
		
	}
	
	public static void Login()
	{
		driver.findElement(By.name("email")).sendKeys(data.userName);
	}
	
	public static void Password() throws InterruptedException
	{
		driver.findElement(By.name("password")).sendKeys(data.password);
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(3000);
	}

	public static void Logout()
	{
		driver.findElement(By.xpath("//*[@id=\"navbar-right\"]/li/ul/li/a")).click();
		
	}
}
