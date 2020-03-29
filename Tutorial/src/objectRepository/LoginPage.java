package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClass;

public class LoginPage extends BaseClass
{
	public String EmailAddressXpath="//input[@id='email']";
	public String PasswordXpath="//input[@id='passwd']";
	public String SignInXpath="//div[@id='columns']//p//span[1]";
	
	@Test
	public void LogInToApplication()
	{
	//Enter User name
	System.out.println(" Enter User Name ");
	WebElement UserName=driver.findElement(By.xpath("//input[@id='email']"));
	UserName.sendKeys("abhijeet7587@gmail.com");
				
	//Enter Password
	System.out.println(" Enter  Password ");
	WebElement Password=driver.findElement(By.xpath("//input[@id='passwd']"));
	Password.sendKeys("Anand13");

	//Click on SignIn
	System.out.println("Click on SignIn Button");
	WebElement SignInWe=driver.findElement(By.xpath("//div[@id='columns']//p//span[1]"));
	SignInWe.click();	
		
	}
	
	

}
