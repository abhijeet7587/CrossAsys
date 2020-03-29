package generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownMethods
{
	public void SelectByIndexNumber(WebElement we, int index)
	{
		Select sel = new Select(we);
		sel.selectByIndex(index);
		
	}
	
	public void SelectByText(WebElement we, String  text)
	{
		Select sel = new Select(we);
		sel.selectByVisibleText(text);
		
	}


}
