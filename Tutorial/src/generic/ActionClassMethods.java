package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMethods
{

	public void moveToElement(WebDriver driver, String xpath) throws Throwable
	{
		//Create Instaance of Action Class
		Actions act = new Actions(driver);
		
		//move the cursor on the first woman product
		WebElement Product1ImgWE=driver.findElement(By.xpath(xpath));
		act.moveToElement(Product1ImgWE);
	}
}
