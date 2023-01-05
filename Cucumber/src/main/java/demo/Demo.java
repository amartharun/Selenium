package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Demo {

	
		@Test
		public void DataRead() throws IOException {

		File file = new File("C:\\Users\\Amar\\eclipse-workspace\\Cucumber\\testData\\testData.xlsx");

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook xsf=new XSSFWorkbook(fis);
		
		
		XSSFSheet sheet = xsf.getSheetAt(0);
		
		String entry1 = sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(entry1);
	}
}

