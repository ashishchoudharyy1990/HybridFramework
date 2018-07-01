package helperPack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

	
	public static Logger log;
	private static boolean flag=false;

	public static Logger getLogger(@SuppressWarnings("rawtypes") Class className)
	{
	if (!flag)
	{
	log = Logger.getLogger(className);
	PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties");
	flag=true;
	return log;
	}
	else 
		log = Logger.getLogger(className);
	    return log;
	}
	
}
