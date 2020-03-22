package utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	
	public static void excelsheetReader() throws IOException
	{
		FileInputStream fis=new FileInputStream(data.excelFile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet2");
		
	}
	
	public static String cellReader(int rowNum, int colNum)
	{
		cell=sheet.getRow(rowNum).getCell(colNum);
		String cellValue=cell.getStringCellValue();
		return cellValue;
	}

}
