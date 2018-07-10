package fileReaders;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import browsers.BrowserType;

public class ConfigFileReader {
	
	
	private Properties prop;
	
	public ConfigFileReader()
	{
		prop = new Properties();
		try {
			prop.load(new FileReader(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		Map<String,String> getenv = System.getenv();
		Set<String> keySet = getenv.keySet();
		for(String key : keySet)
		{
			if(key.contains("JENKINS"))
			{
				prop.setProperty("browser",getenv.get("BROWSER"));
				break;
			}
		}
		*/
	}
	
	
	public BrowserType getBrowser()
	{
		return BrowserType.valueOf(prop.getProperty("browser"));
	}
	
	public String getURL()
	{
	return prop.getProperty("url");	
	}
	
	public String getName()
	{
		return prop.getProperty("name");	
	}
	
	public String getPlace()
	{
		return prop.getProperty("place");
	}
	
	public String getAnimal()
	{
		return prop.getProperty("animal");
	}
	
	public String getThing()
	{
		return prop.getProperty("thing");
	}
	
	public String getMale()
	{
		return prop.getProperty("male");
	}
	
	public String getFemale()
	{
		return prop.getProperty("female");
	}
	
	public String getOthers()
	{
		return prop.getProperty("other");
	}
	
	public String getSelect()
	{
		return prop.getProperty("select");
	}
	
	
	public String getImplicitWait()
	{
		return prop.getProperty("implicitWait");
	}
	
	
	public String getExplicitWait()
	{
		return prop.getProperty("ExplicitWait");
	}
	
	
	public String getPageLoadTimeout()
	{
		return prop.getProperty("pageLoadTimeout");
	}
}
