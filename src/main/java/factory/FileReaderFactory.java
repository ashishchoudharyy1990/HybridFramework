package factory;

import fileReaders.ConfigFileReader;
import fileReaders.ExcelReader;
import fileReaders.JsonFileReader;
import fileReaders.XMLFileReader;

public class FileReaderFactory {
	
	
 private static FileReaderFactory fileReaderFactory;
 private static ConfigFileReader configFileReader;
 private static JsonFileReader jsonFileReader;
 private static ExcelReader excelReader;
 private static XMLFileReader xMLFileReader;
 
 
 private FileReaderFactory()
 {
	 
 }
 
 public static FileReaderFactory getInstance()
 {
	 if (fileReaderFactory==null)
	 {
		 fileReaderFactory = new FileReaderFactory();
		 return fileReaderFactory;
	 }
	 
	 else
		 return fileReaderFactory;
 }
 
 
 public ConfigFileReader getConfigFileReader()
 {
	 
	 if (configFileReader==null)
	 {
		 configFileReader = new ConfigFileReader();
		 return configFileReader;
	 }
	 
	 else
		 return configFileReader;
	 
 }
 
 
 public JsonFileReader getJsonFileReader()
 {
	 
	 if (jsonFileReader==null)
	 {
		 jsonFileReader = new JsonFileReader();
		 return jsonFileReader;
	 }
	 
	 else
		 return jsonFileReader;
	 
 }
 
 public ExcelReader getExcelReader()
 {
	 if (excelReader==null)
	 {
		 excelReader = new ExcelReader();
		 return excelReader;
	 }
	 
	 else
		 return excelReader;
 }

 
 public XMLFileReader getXMLFileReader()
 {
	 if (xMLFileReader==null)
	 {
		 xMLFileReader = new XMLFileReader();
		 return xMLFileReader;
	 }
	 
	 else
		 return xMLFileReader;
	 
 }
 
}
