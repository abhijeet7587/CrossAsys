package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateExcelSheet 
{
	//@Test
	public void createExcel()
	{
		try {
			XSSFWorkbook wb=new XSSFWorkbook();
			FileOutputStream out=new FileOutputStream(new File(".\\TestData\\RegLoginTestData.xlsx"));
			XSSFSheet spreadsheet=wb.createSheet("CommonData");
			wb.write(out);
			out.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void getExcelData() throws Throwable
	{
		//Create instance of Input File Stream
		FileInputStream fis= new FileInputStream(".\\TestData\\RegLoginTestData.xlsx");
		//Open Workbook in Read mode
		Workbook wb= WorkbookFactory.create(fis);
		//get the control of Sheet 1
		Sheet sh= wb.getSheet("CommonData");
		//get the control of rowNumt row
		Row row=sh.getRow(0);
		////get the control of cellNum column in rowNumt row
		Cell cel=row.getCell(1);
		//Read the data
		String Data="";
		long num=0;
		if(row.getCell(1).getCellType()==CellType.STRING)
		{
			 Data= cel.getStringCellValue();
		}
		if(row.getCell(1).getCellType()==CellType.NUMERIC)
		{
			 num= (long) cel.getNumericCellValue();
		}
		
		//System.out.println(Data);
		//System.out.println(Data+ " "+num);
		//System.out.println(num);
		//Close the workbook
		wb.close();
		//return data;	
	}
	//@Test
	public Long getExcelNumericData(String SheetName, int Rownum, int ColNum) throws Throwable
	{
		
		//Create instance of Input File Stream
		FileInputStream fis= new FileInputStream(".\\TestData\\RegLoginTestData.xlsx");
		//Open Workbook in Read mode
		Workbook wb= WorkbookFactory.create(fis);
		//get the control of Sheet 1
		Sheet sh= wb.getSheet(SheetName);
		//get the control of rowNumt row
		Row row=sh.getRow(Rownum);
		////get the control of cellNum column in rowNumt row
		Cell cel=row.getCell(ColNum);
		//Read the data
		String Data="";
		long num=0;
		if(row.getCell(1).getCellType()==CellType.STRING)
		{
			// Data= cel.getStringCellValue();
			 
		}
		if(row.getCell(1).getCellType()==CellType.NUMERIC)
		{
			 num= (long) cel.getNumericCellValue();
			 
		}
		
		
		//System.out.println(Data+ " "+num);
		
		return num;
		
	}
	
		//@Test
		public String getExcelStringData(String SheetName, int Rownum, int ColNum) throws Throwable
		{
			
			//Create instance of Input File Stream
			FileInputStream fis= new FileInputStream(".\\TestData\\RegLoginTestData.xlsx");
			//Open Workbook in Read mode
			Workbook wb= WorkbookFactory.create(fis);
			//get the control of Sheet 1
			Sheet sh= wb.getSheet(SheetName);
			//get the control of rowNumt row
			Row row=sh.getRow(Rownum);
			////get the control of cellNum column in rowNumt row
			Cell cel=row.getCell(ColNum);
			//Read the data
			String Data="";
			long num=0;
//			if(row.getCell(1).getCellType()==CellType.STRING)
//			{
//				 Data= cel.getStringCellValue();
//				 
//			}
			if(row.getCell(1).getCellType()==CellType.NUMERIC)
			{
				 num= (long) cel.getNumericCellValue();
				 
			}
			
			
			//System.out.println(Data+ " "+num);
			
			return Data;
			
		}
		
		
}
