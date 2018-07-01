package helperPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericHelper 
{

	public static boolean isDisplayed(WebElement element)
	{
		if(element==null)
		{
			throw new IllegalArgumentException ("the passed webelement is null");
		}
		
		try
		{
	    element.isDisplayed();
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}
	
	public static String getText(WebElement element)
	{
		if (isDisplayed(element))
		{
			return element.getText();
		}
		
		else 
			throw new IllegalArgumentException ("the passed webelement is not displayed!");
	}
	
	
	public static List<String> getAllTexts(List<WebElement> elements)
	{
		List<String> elementText = new ArrayList<String>();
	
		if(elements==null)
		{
			throw new IllegalArgumentException ("the passed webelement is null");
		}
		
		for(WebElement web : elements)
		{
			System.out.println(web.getText());
			elementText.add((web.getText()));
		}
		
		return elementText;
	}
	
	
	public boolean compareElementText(WebElement element1, WebElement element2)
	{
		if (isDisplayed(element1) && isDisplayed(element2))
		{
			String text1 = element1.getText();
			String text2 = element2.getText();
			
			if (text1.equals(text2))
				return true;
			else
				return false;
		}
		
		else
			throw new IllegalArgumentException ("the passed webelement is not displayed!");
	}
	
	public void uploadFile(String fileName) throws IOException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\myData\\"+fileName);
		
		    /*create a file like below and paste under the fileName :
			WinWaitActive("Open")
			send(put the file u want to upload)
			send("{Enter}")*/
	}
	
	public static void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public static void sendKeysToElement(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	
	public static void goToUrl(WebDriver driver , String value)
	{
		driver.get(value);
	}
}
