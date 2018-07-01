package browsers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions()
	{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("start-maximized");
	
	//below code is setting default download path for files in Chrome
	
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", "D:\\Workspace\\Sel_Cucumber\\src\\test\\resources");
	options.setExperimentalOption("prefs", chromePrefs);
	
	

	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
	/* Below code is for changing the proxy settings for Chrome 
	Proxy proxy = new Proxy();
	proxy.setHttpProxy("myhttpproxy:3337");
    capabilities.setCapability("proxy",proxy);*/
	
	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
	capabilities.setJavascriptEnabled(true);
	
	options.merge(capabilities);
	return options;
	}

	public WebDriver getChromeDriver()
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
	return new ChromeDriver(getChromeOptions());
	}

}
