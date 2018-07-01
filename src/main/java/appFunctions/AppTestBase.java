package appFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helperPack.DropDownHelper;
import helperPack.WaitHelper;

public class AppTestBase {
	
	private WebDriver driver;
	private WaitHelper wait;
	
	public AppTestBase(WebDriver driver)
	{
		this.driver = driver;
		wait = new WaitHelper(driver);
	}

	public void openApp(String url)
	{
		driver.get(url);
	}
	
	
	//we should put all the assert statements and webElement waits here in the app functions because webelements will be validate and ready before we do any operation
	//also after we perform the operation assert statements will be able to assert that functions worked perfectly.
	//at the end if the entire testcase executed fine then we can say that it was a pass.
	
	public void addName(By webelement,String value)
	{
	    WebElement ele = driver.findElement(webelement);
		wait.waitForElementWithoutPolling(ele,5);
		ele.sendKeys(value);
	}
	
	public void addPlace(By webelement,String value)
	{
		driver.findElement(webelement).sendKeys(value);
	}
	
	public void addAnimal(By webelement,String value)
	{
		driver.findElement(webelement).sendKeys(value);
	}
	
	public void addThing(By webelement,String value)
	{
		driver.findElement(webelement).sendKeys(value);
	}
	
	public void selectDropDown(By webelement,String value)
	{
		new DropDownHelper().selectOptionByValue(driver.findElement(webelement), value);
	}
	
	public void selectRadioButton(By webelement)
	{
		driver.findElement(webelement).click();
	}
	
}
