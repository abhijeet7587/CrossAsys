package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * It contain Web Driver specific suitable control
 * @author Abhijeet 
 *
 */
public class WebDriverCommonLib 
{
	/**
	 *It is used foe entire page to load before performing action on element 
	 *It wait maximum till 20 seconds 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	/**
	 * It is used to wait for element to appear in GUI, for every 500ms it check the weather element is available or not
	 * Maximum timeout is 20seconds
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}


	
}
