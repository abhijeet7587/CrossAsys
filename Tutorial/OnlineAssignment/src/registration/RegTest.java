package registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.ActionClassMethods;
import generic.Base;
import generic.BaseClass;
import generic.DropDownMethods;
import generic.FileLib;
import generic.JavascriptMethods;
import generic.WebDriverCommonLib;
import objectRepository.AlertPage;
import objectRepository.HomePage;
import objectRepository.RegistrationPage;

public class RegTest extends Base{
	DropDownMethods dMInstance= new DropDownMethods();
	WebDriverCommonLib webDriverCommonLibInstance= new WebDriverCommonLib();
	ActionClassMethods actionClassMethodsInstance=new ActionClassMethods();
	DropDownMethods dropDownMethodsInstance= new DropDownMethods();
	JavascriptMethods javascriptMethodsInstance=new JavascriptMethods();
	AlertPage ap= new AlertPage();
	FileLib fileLibInstance=new FileLib();
	
	@Test
	public void registartion() throws Throwable
	{
//		System.out.println("one");
RegistrationPage rp=new RegistrationPage();
//		
//		
//		String url=fileLibInstance.getPropertyKeyValue("url");
//		System.out.println("url : "+url);
//		driver.get(url);
//		
//		System.out.println("Maximize the window");
//		webDriverCommonLibInstance.maximizeTheWindow(driver);
//		
		HomePage hp=new HomePage();
		WebElement SignIn=driver.findElement(By.xpath(hp.SignInXpath));
		System.out.println("Click on sign in menu ");
		SignIn.click();
		
		System.out.println("enter email id in Email Address text box");
		javascriptMethodsInstance.scrollThePageHalfDown(driver);
		
		WebElement EmailAddressWe=driver.findElement(By.xpath(rp.EmailAddressXpath));
		String Email=fileLibInstance.getExcelData("CommonData", 0, 1);
		System.out.println("Email :"+Email);
		EmailAddressWe.sendKeys(Email);
		
		
		System.out.println("Click on the Create an account button");
		driver.findElement(By.xpath(rp.CreateAnAccountXpath)).click();
		
		System.out.println("navigate to create an account page");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Select the title as Mr
		driver.findElement(By.xpath(rp.SelectTitleXpath)).click();
		
		//Enter First Name
		String FirstName=fileLibInstance.getExcelData("CommonData", 1, 1);
		System.out.println("First Name :"+FirstName);
		driver.findElement(By.xpath(rp.FirstNameXpath)).sendKeys(FirstName);
		
		//Enter Last Name
		String LastName=fileLibInstance.getExcelData("CommonData", 1, 1);
		System.out.println("Last Name :"+LastName);
		driver.findElement(By.xpath(rp.LastNameXpath)).sendKeys(LastName);
		
		//Enter Password
		String Password=fileLibInstance.getExcelData("CommonData", 2, 1);
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
		String Pwd=fileLibInstance.getExcelData("CommonData", 3, 1);
		WebElement AddressWe=driver.findElement(By.xpath(rp.AddressXpath));
		AddressWe.sendKeys(Pwd);
		
		
		//Enter City
		String City=fileLibInstance.getExcelData("CommonData", 4, 1);
		WebElement CityWe=driver.findElement(By.xpath(rp.CityXpath));
		CityWe.sendKeys(City);
		
		
		//select State
		String STATE=fileLibInstance.getExcelData("CommonData", 5, 1);
		WebElement State=driver.findElement(By.xpath(rp.StateXpath));
		dMInstance.SelectByText(State, STATE);		
		

		
		
		WebElement PincodeWe=driver.findElement(By.xpath(rp.PincodeXpath));
		long pincode=fileLibInstance.getExcelNumericData("CommonData", 6, 1);
		String pin = String.valueOf(pincode);
		PincodeWe.sendKeys(pin);
		
			
		
		
		
		//Enter Mobile phone
	
		javascriptMethodsInstance.scrollThePageHalfDown(driver);
		WebElement PhoneWe=driver.findElement(By.xpath(rp.PhoneXpath));
		long phone=fileLibInstance.getExcelNumericData("CommonData", 8, 1);
		String mobile = String.valueOf(phone);
		PhoneWe.sendKeys(mobile);
	
		//Click on Register
		WebElement RegisterWe=driver.findElement(By.xpath(rp.RegisterXpath));
		//RegisterWe.click();
	}
}
