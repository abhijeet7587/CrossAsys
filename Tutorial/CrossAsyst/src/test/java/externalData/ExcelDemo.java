package externalData;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * Excel java program to read data from excel sheet
 * @author Abhijeet
 *
 */
public class ExcelDemo {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("E:\\Abhijeet\\Data\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String data= cel.getStringCellValue();
		System.out.println();	
		
	}

}
