package testCases.module2;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileReaders.ExcelReader;
import helperPack.LoggerHelper;
import operations.UIOperations;
import testBase.TestBase;

public class Test05 extends TestBase {

	
	public static final Logger log = LoggerHelper.getLogger(Test05.class);
	@Test(dataProvider="provideData2")
	public void testcase5(Map<String,String> testData)
	{
		log.info("Execution of testCase: testcase5 has started");
		UIOperations uiOperations = new UIOperations(getDriver(),"testcase5",testData);
		uiOperations.perform();
			
	}
	

}