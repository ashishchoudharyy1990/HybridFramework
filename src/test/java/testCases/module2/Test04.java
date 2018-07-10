package testCases.module2;


import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;
import testCases.module1.Test03;

public class Test04 extends TestBase {

	public static final Logger log = LoggerHelper.getLogger(Test04.class);
	
	@Test(dataProvider="provideData2",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase4(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase4 has started");
		UIOperations uiOperations = new UIOperations(getDriver(),"testcase4",testData);
		uiOperations.perform();
	}
	
}