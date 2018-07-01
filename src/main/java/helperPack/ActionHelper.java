package helperPack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper 
{
	
private WebDriver driver;
private Actions act;

public ActionHelper(WebDriver driver)
{
	this.driver=driver;
	act=new Actions(driver);
}

public void hoveOverElement(WebElement element)
{
	act.moveToElement(element).build().perform();
}

public void dragAndDrop(WebElement src,WebElement tgt)
{
	act.dragAndDrop(src, tgt).build().perform();
}

public void rightClick(WebElement element)
{
	act.contextClick(element).build().perform();
}

public void rightClickAndSelectOption(WebElement element,int indexOfOption) throws Exception
{
	rightClick(element);
	Robot robo = new Robot();
	
	for(int i = 0; i < indexOfOption ; i++)
	{
	robo.keyPress(KeyEvent.VK_DOWN);
	robo.keyRelease(KeyEvent.VK_DOWN);
	}
	
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyRelease(KeyEvent.VK_ENTER);
}

public String getTooltip(WebElement pageElement, WebElement toolTipElement)
{
	hoveOverElement(pageElement);
	new WaitHelper(driver).waitForElementWithoutPolling(toolTipElement, 5);
	return toolTipElement.getText();
}

public void slider(WebElement element)
{
	act.clickAndHold(element);
	act.moveByOffset(40,0).build().perform();
}


}