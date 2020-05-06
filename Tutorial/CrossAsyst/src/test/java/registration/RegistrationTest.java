package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.ActionClassMethods;
import generic.DropDownMethods;
import generic.FileLib;
import generic.JavascriptMethods;
import generic.WebDriverCommonLib;
import objectRepository.AlertPage;
import objectRepository.HomePage;
import objectRepository.RegistrationPage;

/**
 * Registarion Program
 * @author Abhijeet
 *
 */
public class RegistrationTest {

	public static void main(String[] args) throws Throwable {
		DropDownMethods dMInstance= new DropDownMethods();
		WebDriverCommonLib webDriverCommonLibInstance= new WebDriverCommonLib();
		ActionClassMethods actionClassMethodsInstance=new ActionClassMethods();
		DropDownMethods dropDownMethodsInstance= new DropDownMethods();
		JavascriptMethods javascriptMethodsInstance=new JavascriptMethods();
		AlertPage ap= new AlertPage();
		FileLib fileLibInstance=new FileLib();
		
	
		
		WebDriver driver= new ChromeDriver();
		RegistrationPage rp=new RegistrationPage();
		
		
		String url=fileLibInstance.getPropertyKeyValue("url");
		System.out.println("url : "+url);
		driver.get(url);
		
		System.out.println("Maximize the window");
		webDriverCommonLibInstance.maximizeTheWindow(driver);
		
		HomePage hp=new HomePage();
		WebElement SignIn=driver.findElement(By.xpath(hp.SignInXpath));
		System.out.println("Click on sign in menu ");
		SignIn.click();
		
		System.out.println("enter email id in Email Address text box");
		WebElement EmailAddressWe=driver.findElement(By.xpath(rp.EmailAddressXpath));
		String Email=fileLibInstance.getExcelData("Sheet1", 0, 1);
		System.out.println("Email :"+Email);
		EmailAddressWe.sendKeys(Email);
		//EmailAddressWe.sendKeys("abhijeet7587@gmail.com");
		
		System.out.println("Click on the Create an account button");
		driver.findElement(By.xpath(rp.CreateAnAccountXpath)).click();
		
		System.out.println("navigate to create an account page");
		Thread.sleep(3000);
		
		//Select the title as Mr
		driver.findElement(By.xpath(rp.SelectTitleXpath)).click();
		
		//Enter First Name
		String FirstName=fileLibInstance.getExcelData("Sheet1", 1, 1);
		System.out.println("First Name :"+FirstName);
		driver.findElement(By.xpath(rp.FirstNameXpath)).sendKeys(FirstName);
		
		//Enter Last Name
		String LastName=fileLibInstance.getExcelData("Sheet1", 1, 1);
		System.out.println("Last Name :"+LastName);
		driver.findElement(By.xpath(rp.LastNameXpath)).sendKeys(LastName);
		
		//Enter Password
		String Password=fileLibInstance.getExcelData("Sheet1", 2, 1);
		driver.findElement(By.xpath(rp.PasswordXpath)).sendKeys(Password);
		
		//select date for DOB
		WebElement Date=driver.findElement(By.xpath(rp.DateXpath));
		dMInstance.SelectByIndexNumber(Date, 8);
		
		//select date for DOB
		Thread.sleep(2000);
		WebElement Month=driver.findElement(By.xpath(rp.MonthXpath));
		dMInstance.SelectByIndexNumber(Month, 6);
		

		//select date for DOB
		WebElement Year=driver.findElement(By.xpath(rp.YearXpath));
		dMInstance.SelectByIndexNumber(Year, 21);
				
		//Enter Address
		String Pwd=fileLibInstance.getExcelData("Sheet1", 3, 1);
		WebElement AddressWe=driver.findElement(By.xpath(rp.AddressXpath));
		AddressWe.sendKeys(Pwd);
		
		
		//Enter City
		String City=fileLibInstance.getExcelData("Sheet1", 4, 1);
		WebElement CityWe=driver.findElement(By.xpath(rp.CityXpath));
		CityWe.sendKeys(City);
		
		
		//select State
		String STATE=fileLibInstance.getExcelData("Sheet1", 5, 1);
		WebElement State=driver.findElement(By.xpath(rp.StateXpath));
		dMInstance.SelectByText(State, STATE);		
		
		//Enter Pin code
//		String FirstName=fileLibInstance.getExcelData("Sheet1", 6, 1);
//		System.out.println("First Name :"+FirstName);
		
		
		WebElement PincodeWe=driver.findElement(By.xpath(rp.PincodeXpath));
		PincodeWe.sendKeys("12345");
		
		//select Country
		//WebElement Country=driver.findElement(By.xpath("//select[@id='id_country']"));
		//dMInstance.SelectByText(State, "United States");	
		
		javascriptMethodsInstance.scrollThePageDown(driver);
		
		//Enter Mobile phone
	
		WebElement PhoneWe=driver.findElement(By.xpath(rp.PhoneXpath));
		PhoneWe.sendKeys("987456787");
	
		//Click on Register
		WebElement RegisterWe=driver.findElement(By.xpath(rp.RegisterXpath));
		RegisterWe.click();
	}

}
