package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReading {

	public static void main(String[] args) {

		
		File file = new File("C:\\Users\\ashchoud\\Desktop\\Test Data.xlsx");
		FileInputStream fis =null;
		XSSFWorkbook wb =null;
		try
		{
			fis = new FileInputStream(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws = wb.getSheet("testdata");
		
		int rownum = ws.getLastRowNum()+1;
		int colnum = ws.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rownum][colnum];
		
		for(int i=0; i<rownum ; i++)
		{
			for(int j=0;j<colnum;j++)
			{
				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				obj[i][j] = stringCellValue;
			}
		}
		
		for(int i=0; i<rownum ; i++)
		{
			for(int j=0;j<colnum;j++)
			{
				System.out.print(obj[i][j]);
				System.out.print("--");
			}
			System.out.println();
		}
		
		try {
			wb.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
