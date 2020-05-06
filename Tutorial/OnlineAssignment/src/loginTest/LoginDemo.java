package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.LoginPage;

public class LoginDemo
{

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//Maximize the window
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage();
		lp.LogInToApplication();
		
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

}
