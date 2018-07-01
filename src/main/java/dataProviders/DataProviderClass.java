package dataProviders;



import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import fileReaders.ExcelReader;

public class DataProviderClass 
{

	@DataProvider(name="provideData")
	public static Object[][] provideData(Method method)
	{
		return new ExcelReader().getTestData(method.getName());
	}
	
	
	@DataProvider(name="provideData2")
	public static Object[][] provideData2(Method method1)
	{
		return new ExcelReader().getTestData(method1.getName());
	}
	
}
