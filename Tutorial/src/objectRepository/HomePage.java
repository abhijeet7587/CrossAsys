package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	public String SignInXpath="//a[contains(text(),'Sign in')]";
	public String Product1ImgXpath="//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]";
	public String WomanMenuXpath="//div[@id='block_top_menu']//a[contains(text(),'Women')]";
	public String Product1QuickViewXpath="//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]";
	
	//summary section
	public String ActualProductTotalPriceXpath="//span[@id='total_price']";
	public String ProceedToChekoutBtnWEXpath="//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]";
	
	//Address Section
	public String ProceedToChekoutBtn3WEXpath="//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]";
	
	//Shipping Section
	public String TermConditionchkboxWEXpath="//input[@id='cgv']";
	public String ProceedToChekoutBtn4WEXpath="//form[@id='form']//span[contains(text(),'Proceed to checkout')]";
	
	//Payment Section
	public String TotalProductPriceWeXpath="//span[@id='total_price']";
	public String PayBankByBankoptXpath="//a[contains(text(),'Pay by bank wire')]";
	
	public String ConfirmOrderBtnWeXpath="//span[contains(text(),'I confirm my order')]";
	
	//Order Confirmation Section
	public String ConfirmationMessageContextXpath="//*[@id=\"center_column\"]/div";
	public String ProfileMenuXpath="//nav//div[1]//a[@title='View my customer account']";
	
	//My Account Section
	public String OrderHistoryAndDetailsXpath="//span[contains(text(),'Order history and details')]";
	
	//Dynamic Xpath
	public String DyanicRowXpath1="//table[@id='order-list']/tbody/tr[";
	public String DyanicRowXpath2="]";
	public String RecordsRowXpath="//table[@id='order-list']/tbody/tr[*]";
	public String RecordsFirstColXpath="/td[1]";
	public String RecordsPriceColXpath="/td[1]";
	//Logout
	public String LogoutXpath="//header[@id='header']//div[2]//nav//div[2]//*[normalize-space(text()='Sign out')]";
	
}
