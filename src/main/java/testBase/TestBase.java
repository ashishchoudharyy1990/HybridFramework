package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import browsers.BrowserType;
import browsers.ChromeBrowser;
import browsers.FireFoxBrowser;
import factory.FileReaderFactory;
import helperPack.LoggerHelper;
import helperPack.WaitHelper;

public class TestBase {

	
	public WebDriver driver;
	private WaitHelper wait;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static final Logger log = LoggerHelper.getLogger(TestBase.class);
	
	static
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\reports\\report"+sdf.format(calendar.getTime())+".html");
	}
	

	// We should make sure that all the class should get an independent instance of driver.
	//If they have dependent @Test methods than we should club them in one class itself so that the driver can finish its job and come out from class in end.
		
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		setupBrowser(FileReaderFactory.getInstance().getConfigFileReader().getBrowser());
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName() +" has started its execution");
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		getResult(result);
		extent.endTest(test);
        driver.quit();	
	}
	
	

	@AfterClass
	public void afterClass()
	{
		extent.flush();
	}
	

	@AfterSuite
	public void aftersuite()
	{
		extent.close();
	}
	
	

	private void setupBrowser(BrowserType btype) 
	{
		
		driver = getBrowser(btype);
		wait = new WaitHelper(driver);
		wait.setImplicitWait(Integer.parseInt(FileReaderFactory.getInstance().getConfigFileReader().getImplicitWait()));
		wait.setPageLoadTimeout(Integer.parseInt(FileReaderFactory.getInstance().getConfigFileReader().getPageLoadTimeout()));
		
	}
	
	public WebDriver getBrowser(BrowserType btype)
	{
	 switch(btype)
	 {
	 case Chrome :
		 return new ChromeBrowser().getChromeDriver();
	 case Firefox :
		 return new FireFoxBrowser().getFirefoxBrowser();
	 default:
		 return null;
	 }
	}
	
	
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName()+ " has passed successfully");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
		test.log(LogStatus.FAIL, result.getName() +" Test has failed !!");
		String screenCapture = getScreenCapture(result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenCapture));
		}
		
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, result.getName()+" test case was skipped" + result.getThrowable());
		}
	}
	
	public String getScreenCapture(String testName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String target = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\"+testName+"_"+sdf.format(calendar.getTime())+".png";
		System.out.println("this is where you will find the screenshot : "+target);
		try {
			Files.copy(source, new File(target));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("screenshot was captured successfully....!!");
		
		return target;
		
	}
		
	
}
