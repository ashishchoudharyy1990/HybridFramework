package testCases.module1;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;

public class Test01 extends TestBase {

	
	public static final Logger log = LoggerHelper.getLogger(Test01.class);
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase1(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase1 has started");
		UIOperations uiOperations = new UIOperations(getDriver(),"testcase1",testData);
		uiOperations.perform();
	}
	
}
