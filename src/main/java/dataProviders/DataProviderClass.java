package dataProviders;



import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import factory.FileReaderFactory;


public class DataProviderClass 
{

	@DataProvider(name="provideData")
	public static Object[][] provideData(Method method)
	{
		return FileReaderFactory.getInstance().getExcelReader().getTestData(method.getName());
	}
	
	
	@DataProvider(name="provideData2")
	public static Object[][] provideData2(Method method1)
	{
		return FileReaderFactory.getInstance().getExcelReader().getTestData(method1.getName());
	}
	
}
