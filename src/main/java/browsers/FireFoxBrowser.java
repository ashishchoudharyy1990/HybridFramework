package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxBrowser {
	
	public FirefoxOptions getFirefoxProfile()
	{		
        FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		/* Below code is for changing default download path for Firefox
		 if the value above is set to 0 then it will download to desktop, and with 2 it will download to specified folder */	
		
		profile.setPreference("browser.download.folderList",2);
		profile.setPreference("browser.download.dir", "D:\\Workspace\\Sel_Cucumber\\src\\test\\resources");

		/* Below code is for changing the proxy settings for Firefox */
//		    profile.setPreference("network.proxy.type", 1);
//		    profile.setPreference("network.proxy.socks", "83.209.94.87");
//		    profile.setPreference("network.proxy.socks_port", 35923);
			
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		return option;
	}

	
	public WebDriver getFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
		return new FirefoxDriver(getFirefoxProfile());
	}

}
