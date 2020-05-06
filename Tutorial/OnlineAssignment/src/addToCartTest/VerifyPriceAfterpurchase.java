package addToCartTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.ActionClassMethods;
import generic.BaseClass;
import generic.DropDownMethods;
import generic.FileLib;
import generic.JavascriptMethods;
import generic.WebDriverCommonLib;
import objectRepository.AlertPage;
import objectRepository.HomePage;

public class VerifyPriceAfterpurchase extends BaseClass {

	WebDriverCommonLib webDriverCommonLibInstance= new WebDriverCommonLib();
	ActionClassMethods actionClassMethodsInstance=new ActionClassMethods();
	DropDownMethods dropDownMethodsInstance= new DropDownMethods();
	JavascriptMethods javascriptMethodsInstance=new JavascriptMethods();
	AlertPage ap= new AlertPage();
	HomePage hp=new HomePage();
	FileLib fileLibInstance=new FileLib();
	@Test
	public void verifyPrice() throws Throwable
	{
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
		String actualOrderReference=s[36];
		System.out.println("ActualOrderReference : "+actualOrderReference);
		
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
			System.out.println("OrderReference : "+actualOrderReference);
			System.out.println("OrderReference "+OrderReference +"ActualOrderReference "+actualOrderReference);
			Assert.assertEquals(actualOrderReference, OrderReference);
			if(actualOrderReference.equalsIgnoreCase(OrderReference))
			{
				
				String DynamicPriceXpath=DyanicRowXpath+hp.RecordsPriceColXpath;
				String ActualPrice=driver.findElement(By.xpath(DynamicPriceXpath)).getText();
				Assert.assertEquals(ActualPrice, ExpectedProductTotalPrice);
				break;
			}
				
		}
	}
}
