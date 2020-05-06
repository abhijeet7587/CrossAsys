package addToCartTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import generic.ActionClassMethods;
import generic.DropDownMethods;
import generic.FileLib;
import generic.JavascriptMethods;
import generic.WebDriverCommonLib;
import objectRepository.AlertPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class VeifyPriceTest
{

	public static void main(String[] args) throws Throwable
	{
		WebDriverCommonLib webDriverCommonLibInstance= new WebDriverCommonLib();
		ActionClassMethods actionClassMethodsInstance=new ActionClassMethods();
		DropDownMethods dropDownMethodsInstance= new DropDownMethods();
		JavascriptMethods javascriptMethodsInstance=new JavascriptMethods();
		AlertPage ap= new AlertPage();
		FileLib fileLibInstance=new FileLib();
				
		WebDriver driver= new ChromeDriver();
		//Implicit Wait
		webDriverCommonLibInstance.waitForPageToLoad(driver);
		
		
		String url=fileLibInstance.getPropertyKeyValue("url");
		System.out.println("url : "+url);
		driver.get(url);
		
		System.out.println("Maximize the window");
		webDriverCommonLibInstance.maximizeTheWindow(driver);
		
		HomePage hp=new HomePage();
		WebElement SignIn=driver.findElement(By.xpath(hp.SignInXpath));
		System.out.println("Click on sign in menu ");
		SignIn.click();
		
		System.out.println("Login to Application : ");
		LoginPage lp=new LoginPage();
		
		System.out.println("Enter User name");
		WebElement UserName=driver.findElement(By.xpath(lp.EmailAddressXpath));
		String username=fileLibInstance.getPropertyKeyValue("username");
		UserName.sendKeys(username);
		
		System.out.println("Enter Password");
		WebElement Password=driver.findElement(By.xpath(lp.PasswordXpath));
		String password=fileLibInstance.getPropertyKeyValue("password");
		Password.sendKeys(password);
		
		System.out.println("Click on SignIn");
		WebElement SignInWe=driver.findElement(By.xpath(lp.SignInXpath));
		SignInWe.click();
		
		System.out.println("Click on the Woman Menu ");
		WebElement WomanMenuWe=driver.findElement(By.xpath(hp.WomanMenuXpath));
		WomanMenuWe.click();
		
		actionClassMethodsInstance.moveToElement(driver, hp.Product1ImgXpath);
		System.out.println("Click on the first product Quick view option");
		WebElement Product1QuickViewWE=driver.findElement(By.xpath(hp.Product1QuickViewXpath));
		Product1QuickViewWE.click();
		
		System.out.println("Switch to frame");
		driver.switchTo().frame(0);
		System.out.println("Add product quantity as 2");
		driver.findElement(By.xpath(ap.PlusIconXpath)).click();
		
		System.out.println("Click on Add To Cart");
		WebElement AddToCartBtnWe=driver.findElement(By.xpath(ap.AddToCartXpath));
		AddToCartBtnWe.click();
		
		javascriptMethodsInstance.scrollThePageDown(driver);
		String ExpectedProductTotalPrice="$35.02";
		Thread.sleep(3000);
		System.err.println("Click on the Proceed To Chekout Btn ");
		WebElement ProceedToChekoutBtnWE=driver.findElement(By.xpath(ap.ProceedToChekoutBtnXpath));
		webDriverCommonLibInstance.waitForElementToLoad(driver, ap.ProceedToChekoutBtnXpath);
		ProceedToChekoutBtnWE.click();
		Thread.sleep(3000);
		System.out.println("Summary Section:");
		WebElement ActualProductTotalPriceWe=driver.findElement(By.xpath(hp.ActualProductTotalPriceXpath));
		String ActualProductTotalPrice=ActualProductTotalPriceWe.getText();
		Assert.assertEquals(ActualProductTotalPrice, ExpectedProductTotalPrice);
		
		System.out.println("Click on Proceed to checkout");
		WebElement ProceedToChekoutBtn2WE=driver.findElement(By.xpath(hp.ProceedToChekoutBtnWEXpath));
		ProceedToChekoutBtn2WE.click();
		javascriptMethodsInstance.scrollThePageDown(driver);

		System.out.println("Address Section");
		WebElement ProceedToChekoutBtn3WE=driver.findElement(By.xpath(hp.ProceedToChekoutBtn3WEXpath));
		ProceedToChekoutBtn3WE.click();
		javascriptMethodsInstance.scrollThePageDown(driver);
		
		System.out.println("Shipping Section");
		//select the check box of term and condition
		WebElement TermConditionchkboxWE=driver.findElement(By.xpath(hp.TermConditionchkboxWEXpath));
		
		System.out.println("Accept term and conditions");
		TermConditionchkboxWE.click();
		javascriptMethodsInstance.scrollThePageDown(driver);
		
		System.out.println("Click on Proceed to checkout");
		WebElement ProceedToChekoutBtn4WE=driver.findElement(By.xpath(hp.ProceedToChekoutBtn4WEXpath));
		ProceedToChekoutBtn4WE.click();
		
		System.out.println("Payment Section");
		WebElement TotalProductPriceWe=driver.findElement(By.xpath(hp.TotalProductPriceWeXpath));
		String TotalProductPrice=TotalProductPriceWe.getText();
		Assert.assertEquals(ActualProductTotalPrice, TotalProductPrice);
		
		System.out.println("Click on the Pay Bank By Bank option");
		WebElement PayBankByBankoptWe=driver.findElement(By.xpath(hp.PayBankByBankoptXpath));
		PayBankByBankoptWe.click();
		
		System.out.println("Click on tconfirmation buton");
		WebElement ConfirmOrderBtnWe=driver.findElement(By.xpath(hp.ConfirmOrderBtnWeXpath));
		ConfirmOrderBtnWe.click();
		
		System.out.println("Context of Confirmation message");
		WebElement ConfirmationMessageContextWE=driver.findElement(By.xpath(hp.ConfirmationMessageContextXpath));
		String msg=ConfirmationMessageContextWE.getText();
		String[] s= msg.split(" "); 
		System.out.println("ActualOrderReference : "+s[36]);
		
		System.out.println("Click on the profile menu");
		WebElement ProfileMenu=driver.findElement(By.xpath(hp.ProfileMenuXpath));
		ProfileMenu.click();
		
		System.out.println("My Account Section");
		System.out.println("Click on the Order History And Details Option");
		WebElement OrderHistoryAndDetails=driver.findElement(By.xpath(hp.OrderHistoryAndDetailsXpath));
		OrderHistoryAndDetails.click();
	
		List<WebElement> RowWe=driver.findElements(By.xpath(hp.RecordsRowXpath));
		for(int i=1;i<=RowWe.size();i++)
		{
			String DyanicRowXpath=hp.DyanicRowXpath1+i+hp.DyanicRowXpath2;
			String DynamicOrderReferenceXpath=DyanicRowXpath+hp.RecordsFirstColXpath;
			String OrderReference=driver.findElement(By.xpath(DynamicOrderReferenceXpath)).getText();
			System.out.println("OrderReference : "+OrderReference);
			if(OrderReference==s[36])
			{
				String DynamicPriceXpath=DyanicRowXpath+hp.RecordsPriceColXpath;
				String ActualPrice=driver.findElement(By.xpath(DynamicPriceXpath)).getText();
				Assert.assertEquals(ActualPrice, ExpectedProductTotalPrice);
				break;
			}
				
		}
	
		System.out.println("Click on Logout");
		
		WebElement LogoutWe=driver.findElement(By.xpath(hp.LogoutXpath));
		LogoutWe.click();
		System.out.println("Close the browse");
		driver.close();

	}

}
