package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils  {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	public void setExcelFile(String excelFilePath,String sheetName) throws IOException {

		File src =    new File(excelFilePath);

		FileInputStream fis = new FileInputStream(src);

		workbook=new XSSFWorkbook(fis);

		sheet=workbook.getSheet(sheetName);
	}

	public int getRowCountInSheet(){
		int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rowcount;
	}


	public String getCellData(int rowNumber,int cellNumber){
		//getting the cell value from rowNumber and cell Number
		cell =sheet.getRow(rowNumber).getCell(cellNumber);

		//returning the cell value as string
		return cell.getStringCellValue();
	}

	public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
		//creating a new cell in row and setting value to it      
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}
}
