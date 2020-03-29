package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass
{

	public static WebDriver driver;
	
	@BeforeClass
	public void configureBC() throws Throwable
	{
		System.out.print("Launch the Browser");
		driver= new ChromeDriver();
		System.out.print("open the URL");
		driver.get("http://automationpractice.com/index.php");
	}
	
	@BeforeMethod
	public void configureBM() throws Throwable
	{
		System.out.print("Signin to Web Application");
		
		//click on sign in menu 
		WebElement SignIn=driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		SignIn.click();
		
		//Enter User name
		WebElement UserName=driver.findElement(By.xpath("//input[@id='email']"));
		UserName.sendKeys("abhijeet7587@gmail.com");
		
		//Enter Password
		WebElement Password=driver.findElement(By.xpath("//input[@id='passwd']"));
		Password.sendKeys("Anand13");

		//Click on SignIn
		WebElement SignInWe=driver.findElement(By.xpath("//div[@id='columns']//p//span[1]"));
		SignInWe.click();
		
		
	}
	
	@AfterMethod
	public void configureAM() throws Throwable
	{
		System.out.print("Logout to Web Application");
		//Click on Logout
		WebElement LogoutWe=driver.findElement(By.xpath("//header[@id='header']//div[2]//nav//div[2]//*[normalize-space(text()='Sign out')]"));
		LogoutWe.click();
		
	}
	
	
	@AfterClass
	public void configureAC() throws Throwable
	{
		System.out.print("Close the Browser");
		
		driver.close();
	}
	
	
}
