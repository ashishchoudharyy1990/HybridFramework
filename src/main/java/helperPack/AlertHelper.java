package helperPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper 
{

	private WebDriver driver;
	public AlertHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Alert getAlert()
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public void dismissAlert()
	{
		Alert alert = getAlert();
		alert.dismiss();
	}
	
	public void acceptAlert()
	{
		Alert alert = getAlert();
		alert.accept();
	}
	
	public String alertText()
	{
		Alert alert = getAlert();
		return alert.getText();
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		acceptAlert();
		}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		dismissAlert();
	}
	
}
