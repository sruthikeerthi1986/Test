package Browser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class BrowserUtilites{
	
	//move to a specific element in the webpage.
	public static void MoveMouse(WebDriver driver, WebElement element)
	{
		If(isElementPresent(element))
		{
			Action action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		else
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,element.getText()+"doesn't exist in this page");
			
		}
	}
	
	// Check if element present in the webpage
	public static Boolean isElementPresent(WebElement elementDesc)
	{
		Boolean elementStatus = false;
		int timeOutInSeconds = 20;
		boolean staleElement;
		do
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeOutInSeconds);
				Actions acions = new Actions(Basetest.driver);
				actions.moveToElement(elementDesc).perform();
				WebElement weObj = wait.until(ExpectedConditions.elementToBeClickable(elementDesc));
				if(!weObj.getSize())
			}
		}
	}
	
	
	
}
