package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Demo {


	@Test
	public void DataRead() throws IOException {

		File file = new File("C:\\Users\\Amar\\eclipse-workspace\\test\\Cucumber\\testData\\testData.xlsx");

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook xsf=new XSSFWorkbook(fis);

		XSSFSheet sheet = xsf.getSheet("Sheet1"); //providing Sheet Name
		//XSSFSheet sheet = xsf.getSheetAt(0); //Providing sheet by index

		int rowCount = sheet.getLastRowNum();

		int columnCount = sheet.getRow(0).getLastCellNum();

		for(int i=0;i<rowCount;i++) {

			XSSFRow currentRow = sheet.getRow(i);
			
			for(int j=0;j<columnCount;j++) {
				
				String value = currentRow.getCell(j).toString();
				
				System.out.print(" " +value);
			}
		System.out.println();
		}
	}
}

//for(int i=0;i<=rowCount;i++) {
//
//	XSSFRow currentRow = sheet.getRow(i);
//
//	String FirstName=currentRow.getCell(0).getStringCellValue();
//	String LastName=currentRow.getCell(1).getStringCellValue();
//	String Email=currentRow.getCell(2).getStringCellValue();
//	String Gender=currentRow.getCell(3).getStringCellValue();
//
//
//}