package helperPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private WebDriver driver;
	
	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setImplicitWait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void setPageLoadTimeout(long time)
	{
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	public WebDriverWait getWaitWithoutPolling(long time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait;
	}
	
	public WebDriverWait getWaitWithPolling(long time,long pollingTime)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(ElementNotVisibleException.class);
		return wait;
	}
	
	public void waitForElementWithoutPolling(WebElement element,long time)
	{
		WebDriverWait waitWithoutPolling = getWaitWithoutPolling(time);
		waitWithoutPolling.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPresenceOfElementWithoutPolling(By element,long time)
	{
		WebDriverWait waitWithoutPolling = getWaitWithoutPolling(time);
		waitWithoutPolling.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}
	
	public void waitForElementWithPolling(WebElement element,long time, long pollingTime)
	{
		WebDriverWait waitWithPolling = getWaitWithPolling(time,pollingTime);
		waitWithPolling.until(ExpectedConditions.visibilityOf(element));
	}

	
}
