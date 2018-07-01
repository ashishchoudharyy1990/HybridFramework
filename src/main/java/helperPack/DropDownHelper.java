package helperPack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper 
{

public void selectOptionByVisibleText(WebElement element , String option)
{
Select sel = new Select (element);
sel.selectByVisibleText(option);
}

public void selectOptionsByVisibleText(WebElement element,String[] options)
{
	Select sel = new Select (element);
	
	if (sel.isMultiple())
	{
		for(int i=0;i<options.length;i++)
		{
			sel.selectByVisibleText(options[i]);
		}
	}
	else throw new IllegalArgumentException("PLease choose another method !!!");
}

public void selectOptionByValue(WebElement element, String value)
{
	Select sel = new Select (element);
	sel.selectByValue(value);
}

public void selectOptionByIndex(WebElement element, int index)
{
	Select sel = new Select (element);
	sel.selectByIndex(index);
}

public String selectDefaultSelectedOption(WebElement element)
{
	Select sel = new Select (element);
	WebElement firstSelectedOption = sel.getFirstSelectedOption();
	return firstSelectedOption.getText();
}

public List<String> getAllOptions(WebElement element)
{
	Select sel = new Select(element);
	List<WebElement> options = sel.getOptions();
	List<String> list = new ArrayList<String>();
	
	for(WebElement ele : options)
	{
		list.add(ele.getText());
	}
	
	return list;
}
}