package helperPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHelper 
{

	private WebDriver driver;
	
	public WindowHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void goForward()
	{
		driver.navigate().forward();
	}
	
	public void goBack()
	{
		driver.navigate().back();
	}
	
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
	public String getParentWindowHandle()
	{
		return driver.getWindowHandle();
	}
	
	public Set<String> getAllWindowHandles()
	{
		return driver.getWindowHandles();
	}
	
	public void closeAllWindowsExceptParent()
	{
		Set<String> handles = getAllWindowHandles();
		List<String> list = new ArrayList<String>(handles);
		
		for (int i=1;i<list.size();i++)
		{
			driver.switchTo().window(list.get(i));
			driver.close();
		}
		
		driver.switchTo().window(list.get(0));
	}
	
}
