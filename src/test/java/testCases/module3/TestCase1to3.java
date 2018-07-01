package testCases.module3;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;


public class TestCase1to3 extends TestBase {
	
	public static final Logger log = LoggerHelper.getLogger(TestCase1to3.class);
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase1(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase1 has started");
		UIOperations uiOperations = new UIOperations(driver,"testcase1",testData,prop);
		uiOperations.perform();
	}
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase2(Map<String,String> testData)
	{

		log.info("Execution of testCase: testcase2 has started");
		UIOperations uiOperations = new UIOperations(driver,"testcase2",testData,prop);
		uiOperations.perform();
	}
	
	
	@Test(dataProvider="provideData",dataProviderClass=dataProviders.DataProviderClass.class)
	public void testcase3(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase3 has started");
		UIOperations uiOperations = new UIOperations(driver,"testcase3",testData,prop);
		uiOperations.perform();
	}

}
