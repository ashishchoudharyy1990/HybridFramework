package helperPack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

	private WebDriver driver;

	public JavaScriptHelper(WebDriver driver)
	{
	this.driver = driver;
	}

	public void executeScript(String script)
	{
	JavascriptExecutor je = (JavascriptExecutor)driver;
	je.executeScript(script);
	}

	public void executeScript(String script, Object... args)
	{
	JavascriptExecutor je = (JavascriptExecutor)driver;
	je.executeScript(script,args);
	}

	public void scrollToElement(WebElement element)
	{
	executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}

	public void scrollIntoView(WebElement element)
	{
	executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public void scrollUp()
	{
	executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	public void scrollDown()
	{
	executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollByPixel()
	{
	executeScript("window.scrollBy(400,0)");
	}

	public void zoomIn()
	{
	executeScript("document.body.style.zoom='40%'");
	}

	
}
