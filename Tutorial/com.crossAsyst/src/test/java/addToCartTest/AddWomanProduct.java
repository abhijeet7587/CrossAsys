package addToCartTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddWomanProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//Maximize the window
		driver.manage().window().maximize();
		
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
		
		//Click on Woman section
		WebElement WomanMenuWe=driver.findElement(By.xpath("//div[@id='block_top_menu']//a[contains(text(),'Women')]"));
		WomanMenuWe.click();
		
		//Create Instaance of Action Class
		
		Actions act = new Actions(driver);
		
		//move the cursor on the first woman product
		WebElement Product1ImgWE=driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]"));
		act.moveToElement(Product1ImgWE);
		
		//click on the first product Quick view option
		WebElement Product1QuickViewWE=driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]"));
		Product1QuickViewWE.click();
		
		Thread.sleep(6000);
		//switch to frame
		//WebElement We=driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[2]//span[1]//i[1]")).click();
		
		//Add first product quantity as 2
		//WebElement QuantityWe=driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]"));
		//QuantityWe.sendKeys("2");
		
		
		//Click on Add To Cart
		WebElement AddToCartBtnWe=driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		AddToCartBtnWe.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		String ExpectedProductTotalPrice="$35.02";
		
		//WebElement ActualProductTotalPriceWe=driver.findElement(By.xpath("//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]"));
		//String ActualProductTotalPrice=ActualProductTotalPriceWe.getText();
		//Assert.assertEquals(ActualProductTotalPrice, ExpectedProductTotalPrice);
		Thread.sleep(3000);
		//Click on the Proceed To Chekout Btn 
		WebElement ProceedToChekoutBtnWE=driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
		ProceedToChekoutBtnWE.click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		//summary Section 
		
		WebElement ActualProductTotalPriceWe=driver.findElement(By.xpath("//span[@id='total_price']"));
		String ActualProductTotalPrice=ActualProductTotalPriceWe.getText();
		Assert.assertEquals(ActualProductTotalPrice, ExpectedProductTotalPrice);
		
		
		//Click on Add To Cart
		WebElement ProceedToChekoutBtn2WE=driver.findElement(By.xpath("//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]"));
		ProceedToChekoutBtn2WE.click();
				
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)");
		
	    //Address Section 
		Thread.sleep(3000);
		//Click on Add To Cart
		WebElement ProceedToChekoutBtn3WE=driver.findElement(By.xpath("//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]"));
		ProceedToChekoutBtn3WE.click();
		
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,1000)");
		
		//select the check box of term and condition
		WebElement TermConditionchkboxWE=driver.findElement(By.xpath("//input[@id='cgv']"));
		
		TermConditionchkboxWE.click();
		
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		
		
		//Shipping  Section 
		
		//Click on the Proceed To Chekout Btn
		WebElement ProceedToChekoutBtn4WE=driver.findElement(By.xpath("//form[@id='form']//span[contains(text(),'Proceed to checkout')]"));
		ProceedToChekoutBtn4WE.click();
		
		Thread.sleep(3000);
		
		//Payment Section 
		
		WebElement TotalProductPriceWe=driver.findElement(By.xpath("//span[@id='total_price']"));
		String TotalProductPrice=TotalProductPriceWe.getText();
		Assert.assertEquals(ActualProductTotalPrice, TotalProductPrice);
		
		//Click on the Pay Bank By Bank option
		WebElement PayBankByBankoptWe=driver.findElement(By.xpath("//a[contains(text(),'Pay by bank wire')]"));
		PayBankByBankoptWe.click();
		
		Thread.sleep(3000);
		//Click on Add To Cart
		WebElement ConfirmOrderOptWe=driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
		ConfirmOrderOptWe.click();
		
		
		
		
		//Context of Confirmation message
		WebElement ConfirmationMessageContextWE=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div"));
		//System.out.println("Context :"+ConfirmationMessageContextWE.getText());
		String msg=ConfirmationMessageContextWE.getText();
		String[] s= msg.split(" "); 
//		for(int i=0;i<=s.length-1;i++)
//		{
//			System.out.println(i);
//		}
		
//		for (String sentence : s) {
//			System.out.println("word :"+sentence);
//		}
		String ActualOrderReference = null;
		System.out.println("ActualOrderReference : "+s[36]);
		String ExpectedConfirmationOrderMessage="Your order on My Store is complete.";
	
		
		String expectedActualOrderReference = null;
		//Profile 
		//Click on the profile menu
		WebElement ProfileMenu=driver.findElement(By.xpath("//nav//div[1]//a[@title='View my customer account']"));
		ProfileMenu.click();
		
		//My Account Section
		//Click on the Order History And Details Option
		WebElement OrderHistoryAndDetails=driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]"));
		OrderHistoryAndDetails.click();
	
		String DyanicRowXpath1="//table[@id='order-list']/tbody/tr[";
			int row =1;
		String DyanicRowXpath2="]";
		List<WebElement> RowWe=driver.findElements(By.xpath("//table[@id='order-list']/tbody/tr[*]"));
		
		for(int i=1;i<=RowWe.size();i++)
		{
			String DyanicRowXpath=DyanicRowXpath1+i+DyanicRowXpath2;
			String DynamicOrderReferenceXpath=DyanicRowXpath+"/td[1]";
			String OrderReference=driver.findElement(By.xpath(DynamicOrderReferenceXpath)).getText();
			System.out.println("OrderReference : "+OrderReference);
			if(OrderReference==s[36])
			{
				String DynamicPriceXpath=DyanicRowXpath+"/td[3]";
				String ActualPrice=driver.findElement(By.xpath(DynamicPriceXpath)).getText();
				Assert.assertEquals(ActualPrice, ExpectedProductTotalPrice);
				break;
			}
			
			//DynamicRowXpath=
		}
	
		
		//Logout
		//Click on Logout
		WebElement LogoutWe=driver.findElement(By.xpath("//header[@id='header']//div[2]//nav//div[2]//*[normalize-space(text()='Sign out')]"));
		LogoutWe.click();
		
		//close the browse
		driver.close();

	}

}
