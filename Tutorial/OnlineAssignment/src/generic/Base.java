package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	public static WebDriver driver;
	@BeforeClass
	public void configureBC() throws Throwable
	{
		System.out.print("Launch the Browser");
		driver= new ChromeDriver();
		System.out.print("open the URL");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void configureAC() throws Throwable
	{
		System.out.print("Close the Browser");
		
		driver.close();
	}
}
