package testCases.module1;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;

public class Test03 extends TestBase {


	public static final Logger log = LoggerHelper.getLogger(Test03.class);
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase3(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase3 has started");
		UIOperations uiOperations = new UIOperations(getDriver(),"testcase3",testData);
		uiOperations.perform();
	}
	
}