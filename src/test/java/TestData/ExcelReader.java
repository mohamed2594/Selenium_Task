package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null ; 
	
	public FileInputStream getFileInputStream(String filename) 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/TestData/"+filename+".xlsx"; 
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found.");
			System.exit(0);
		}
		return fis ; 
	}
	
	public Object[][] getExcelData(String filename, int ColNum) throws IOException
	{
		fis = getFileInputStream(filename); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = ColNum ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}
}
