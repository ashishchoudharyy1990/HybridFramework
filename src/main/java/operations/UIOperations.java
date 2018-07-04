package operations;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import appFunctions.AppTestBase;
import factory.FileReaderFactory;
import fileReaders.ConfigFileReader;
import fileReaders.ExcelReader;

public class UIOperations{
	
	String testCaseName;
	Map<String,String> testData;
	private ConfigFileReader prop = FileReaderFactory.getInstance().getConfigFileReader();;
	String[][] testCaseData;
	AppTestBase appBase;
	public UIOperations (WebDriver driver, String testCaseName , Map<String,String> testData)
	{
		appBase = new AppTestBase(driver);
		this.testCaseName=testCaseName;
		this.testData=testData;
		testCaseData = new ExcelReader().getTestCases(testCaseName);
		
	}
	
	
	public void perform()
	{
		for(int i=0;i<testCaseData.length;i++)
		{
			executeStep(testCaseData[i][0],testCaseData[i][1],testCaseData[i][2],testCaseData[i][3]);
		}

	}	
	
	public void executeStep(String keyWord, String object, String type,String testDataKey)
	{
		if (keyWord.equalsIgnoreCase("openapp"))
		{
			appBase.openApp(prop.getURL());
		}
		
		else if (keyWord.equalsIgnoreCase("addname"))
		{
			try {
				appBase.addName(getWebElement(object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addplace"))
		{
			try {
				appBase.addPlace(getWebElement(object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addanimal"))
		{
			try {
				appBase.addAnimal(getWebElement(object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("addthing"))
		{
			try {
				appBase.addThing(getWebElement(object,type), testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("selectradiobutton"))
		{
			try {
				appBase.selectRadioButton(getWebElement(object,type));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (keyWord.equalsIgnoreCase("selectdropdown"))
		{
			try {
				appBase.selectDropDown(getWebElement(object,type),testData.get(testDataKey));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	private By getWebElement(String objectName,String objectType) throws Exception
	{
			if(objectType.equalsIgnoreCase("XPATH"))
			{
				
				return By.xpath(getProperty(objectName));
			}

			else if(objectType.equalsIgnoreCase("CLASSNAME"))
	        {
				
				return By.className(getProperty(objectName));
			}
		
			
			else if(objectType.equalsIgnoreCase("NAME"))
	        {
				
				return By.name(getProperty(objectName));
			}		

			else if(objectType.equalsIgnoreCase("CSS"))
			 {
				
				return By.cssSelector(getProperty(objectName));
			 }
			 
			
			else if(objectType.equalsIgnoreCase("LINK"))
			 {	
				return By.linkText(getProperty(objectName));
			 }


			else if(objectType.equalsIgnoreCase("PARTIALLINK"))
			{	
				return By.partialLinkText(getProperty(objectName));
			}
			
	else if(objectType.equalsIgnoreCase("ID"))
				
	        {	
				return By.id(getProperty(objectName));
			}
			
			else
			{
				throw new Exception("Wrong object type");
			}
		}
	
	
	
	private String getProperty(String property)
	{
		if (property.equalsIgnoreCase("url"))
			return prop.getURL();
		else if (property.equalsIgnoreCase("name"))
			return prop.getName();
		else if (property.equalsIgnoreCase("place"))
			return prop.getPlace();
		else if (property.equalsIgnoreCase("animal"))
			return prop.getAnimal();
		else if (property.equalsIgnoreCase("Thing"))
			return prop.getThing();
		else if (property.equalsIgnoreCase("male"))
			return prop.getMale();
		else if (property.equalsIgnoreCase("female"))
			return prop.getFemale();
		else if (property.equalsIgnoreCase("other"))
			return prop.getOthers();
		else if (property.equalsIgnoreCase("select"))
			return prop.getSelect();
		else return null;
	}

}
