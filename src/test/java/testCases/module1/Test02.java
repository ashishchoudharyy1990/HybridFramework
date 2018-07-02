package testCases.module1;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;

public class Test02 extends TestBase {

	public static final Logger log = LoggerHelper.getLogger(Test02.class);
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase2(Map<String,String> testData)
	{

		log.info("Execution of testCase: testcase2 has started");
		UIOperations uiOperations = new UIOperations(driver,"testcase2",testData);
		uiOperations.perform();
	}
	
}