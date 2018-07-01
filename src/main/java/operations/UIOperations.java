package operations;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import appFunctions.AppTestBase;
import fileReaders.ExcelReader;

public class UIOperations{
	
	String testCaseName;
	Map<String,String> testData;
	Properties prop;
	String[][] testCaseData;
	AppTestBase appBase;
	public UIOperations (WebDriver driver, String testCaseName , Map<String,String> testData,Properties prop)
	{
		appBase = new AppTestBase(driver);
		this.testCaseName=testCaseName;
		this.testData=testData;
		this.prop=prop;
		testCaseData = new ExcelReader().getTestCases(testCaseName);
		
	}
	
	
	public void perform()
	{
		for(int i=0;i<testCaseData.length;i++)
		{
			executeStep(testCaseData[i][0],testCaseData[i][1],testCaseData[i][2],testCaseData[i][3],prop);
		}

	}	
	
	public void executeStep(String keyWord, String object, String type,String testDataKey,Properties prop)
	{
		if (keyWord.equalsIgnoreCase("openapp"))
		{
			appBase.openApp(prop.getProperty("url"));
		}
		
		else if (keyWord.equalsIgnoreCase("addname"))
		{
			try {
				appBase.addName(getWebElement(prop,object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addplace"))
		{
			try {
				appBase.addPlace(getWebElement(prop,object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addanimal"))
		{
			try {
				appBase.addAnimal(getWebElement(prop,object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addthing"))
		{
			try {
				appBase.addThing(getWebElement(prop,object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("selectradiobutton"))
		{
			try {
				appBase.selectRadioButton(getWebElement(prop,object,type));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("selectdropdown"))
		{
			try {
				appBase.selectDropDown(getWebElement(prop,object,type),testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	private By getWebElement(Properties p,String objectName,String objectType) throws Exception
	{
			if(objectType.equalsIgnoreCase("XPATH"))
			{
				
				return By.xpath(p.getProperty(objectName));
			}

			else if(objectType.equalsIgnoreCase("CLASSNAME"))
	        {
				
				return By.className(p.getProperty(objectName));
			}
		
			
			else if(objectType.equalsIgnoreCase("NAME"))
	        {
				
				return By.name(p.getProperty(objectName));
			}		

			else if(objectType.equalsIgnoreCase("CSS"))
			 {
				
				return By.cssSelector(p.getProperty(objectName));
			 }
			 
			
			else if(objectType.equalsIgnoreCase("LINK"))
			 {	
				return By.linkText(p.getProperty(objectName));
			 }


			else if(objectType.equalsIgnoreCase("PARTIALLINK"))
			{	
				return By.partialLinkText(p.getProperty(objectName));
			}
			
	else if(objectType.equalsIgnoreCase("ID"))
				
	        {	
				return By.id(p.getProperty(objectName));
			}
			
			else
			{
				throw new Exception("Wrong object type");
			}
		}

}
