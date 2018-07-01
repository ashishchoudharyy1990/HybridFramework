package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public Object[][] getTestData(String testCaseName)
	{
		
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testDataFile.xlsx"));
		} catch (FileNotFoundException e) {
			System.out.println("file not found ya!");
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook=null;
		
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("TestData");
		
		int testCaseStartRowNum = 0;
		for(int i =0 ; i<sheet.getLastRowNum()+1;i++)
		{
			
			if(sheet.getRow(i).getCell(0).getStringCellValue().equals(testCaseName))
			{
				testCaseStartRowNum=i;
				break;
			}
		}
		
		int testCaseEndRowNum = 0;
		for(int i = testCaseStartRowNum ; i<sheet.getLastRowNum()+1;i++)
		{
			if(sheet.getRow(i).getCell(0).getStringCellValue().equals(""))
			{
				testCaseEndRowNum=i;
				break;
			}
		}
		
		
		int rowCount =  (testCaseEndRowNum - testCaseStartRowNum)-1;
 		int colCount =  sheet.getRow(testCaseStartRowNum+1).getLastCellNum();

 		
 		String[] testDataColumns = new String[colCount];
 		
 		for(int j = testCaseStartRowNum+1;j<testCaseStartRowNum+2;j++)
 		{
 			for(int i=0;i<colCount; i++)
 			{
  				testDataColumns[i]=sheet.getRow(j).getCell(i).getStringCellValue();
 			}
 			
 		}

 		
 		Object[][] finalData = new Object[rowCount-1][1];
 		int k = 0;
 		
 		for(int j = testCaseStartRowNum+2;j<testCaseEndRowNum;j++)
 		{
 			Map<String,String> dataSet = new HashMap<String,String>();
 			
 			for(int i=0;i<colCount; i++)
 			{
 				String cellValue = sheet.getRow(j).getCell(i).getStringCellValue();
 				dataSet.put(testDataColumns[i], cellValue);
 			}

 			finalData[k][0]=dataSet;
 			
 			k++;
 		}
 		
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return finalData;
	}
	
	
	
	public String[][] getTestCases(String testCaseName)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testDataFile.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("TestCases");
		
		int testCaseStartRowNum=0;

		outer:
			for(int i=1;i<sheet.getLastRowNum()+1;i++)
			{
			for(int j =0;j<1;j++)
			{
			if(sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
			testCaseStartRowNum=i;
			break outer;
			}
			}
			}

			int testCaseEndRowNum=0;

			outer:
			for(int i=testCaseStartRowNum+1;i<sheet.getLastRowNum()+1;i++)
			{
			for(int j =0;j<1;j++)
			{
			if(!sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
			testCaseEndRowNum=i;
			break outer;
			}
			}
			}
		
		
		String[][] testCaseKeyWords = new String[testCaseEndRowNum-testCaseStartRowNum][4];

		int k=0;
		int l=0;

		for(int i=testCaseStartRowNum;i<testCaseEndRowNum;i++)
		{
		l=0;
		for(int j =1;j<5;j++)
		{
		testCaseKeyWords[k][l]=sheet.getRow(i).getCell(j).getStringCellValue();
		l++;
		}
		k++;
		}


		return testCaseKeyWords;
	}

}
