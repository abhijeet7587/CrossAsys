package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Abhijeet 
 *
 */
public class FileLib
{
	/**This method is used to fetch the data from external excel sheet
	 * 
	 * @param Sheet1
	 * @param rowNum
	 * @param cellNum
	 * @return data
	 * @throws Throwable
	 */
	public String getExcelData(String Sheet1,int rowNum, int cellNum) throws Throwable
	{
	//Create instance of Input File Stream
	FileInputStream fis= new FileInputStream(".\\TestData\\RegLoginTestData.xlsx");
	//Open Workbook in Read mode
	Workbook wb= WorkbookFactory.create(fis);
	//get the control of Sheet 1
	Sheet sh= wb.getSheet(Sheet1);
	//get the control of rowNumt row
	Row row=sh.getRow(rowNum);
	////get the control of cellNum column in rowNumt row
	Cell cel=row.getCell(cellNum);
	//Read the data
	String data= cel.getStringCellValue();
	System.out.println(data);
	//Close the workbook
	wb.close();
	return data;	
	}
	
	/**
	 * It is used to get the value of the passed key from the external properties file
	 * Properties file has common data which are common to each test script
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
	//Create instance of Input File Stream
	FileInputStream fis= new FileInputStream(".\\Data\\CommonData.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String value=pobj.getProperty(key);
	
	return value;	
	}
	
	
	/**
	 * This method is used to change the value of test data in 
	 * @param Sheet1
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void SetExcelData(String Sheet1,int rowNum, int cellNum, String data) throws Throwable
	{
	//Create instance of Input File Stream
	FileInputStream fis= new FileInputStream(".\\TestData.xlsx");
	//Open Workbook in Read mode
	Workbook wb= WorkbookFactory.create(fis);
	//get the control of Sheet 1
	Sheet sh= wb.getSheet("Sheet1");
	//get the control of rowNumt row
	Row row=sh.getRow(rowNum);
	//get the control of cellNum column in rowNumt row
	Cell cel=row.getCell(cellNum);
	//Write the data
	cel.setCellValue(data);
	
	//Create instance of Output File Stream
	FileOutputStream fos= new 	FileOutputStream(".\\TestData.xlsx");
	wb.write(fos);
	
	//Close the workbook
	wb.close();
	}
	
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
//		if(row.getCell(1).getCellType()==CellType.STRING)
//		{
//			// Data= cel.getStringCellValue();
//			 
//		}
		if(row.getCell(1).getCellType()==CellType.NUMERIC)
		{
			 num= (long) cel.getNumericCellValue();
			 
		}
		
		
		//System.out.println(Data+ " "+num);
		
		return num;
		
	}
}
