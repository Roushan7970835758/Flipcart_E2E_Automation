package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
    private final WebDriver driver;
    
    public  ExcelUtility(WebDriver driver) {
        // Constructor to initialize the class if needed
        this.driver = driver;
    }
	
	
	public String readExcelcolumn(String sheet,int rowNumber, int cellNumber) throws IOException {
		DataFormatter formatter = new DataFormatter();
		String filePath = System.getProperty("user.dir")+"\\testData\\flipkartTestData.xlsx";
		File Path = new File(filePath);
		FileInputStream fis = new FileInputStream(Path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheet(sheet);
		XSSFRow row = sheet1.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		
		String cellValue = formatter.formatCellValue(cell);
//		workbook.close(); // Close the workbook to release resources
		
		return cellValue;
	}
	
	public void writeExcelcolumn(String sheet,int rowNumber,int cellNumber,String text) throws IOException {
		String filePath =  System.getProperty("user.dir")+"\\testData\\flipkartTestData.xlsx";
		File Path = new File(filePath);
		FileInputStream fis = new FileInputStream(Path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheet(sheet);
		XSSFRow row = sheet1.getRow(rowNumber);
		XSSFCell cell = row.createCell(cellNumber);
		cell.setCellValue(text);
		FileOutputStream fos = new FileOutputStream(Path);
		
		workbook.write(fos);
		
	}
	
	public void writeExcelcolumn2(String sheet, int rowNumber, int cellNumber, String text) throws IOException {
	    String filePath = System.getProperty("user.dir") + "\\testData\\flipkartTestData.xlsx";
	    File file = new File(filePath);

	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet1 = workbook.getSheet(sheet);

	    if (sheet1 == null) {
	        sheet1 = workbook.createSheet(sheet); // If sheet doesn't exist
	    }

	    XSSFRow row = sheet1.getRow(rowNumber);
	    if (row == null) {
	        row = sheet1.createRow(rowNumber);
	    }

	    XSSFCell cell = row.createCell(cellNumber);
	    cell.setCellValue(text);

	    fis.close(); // Always close input stream

	    FileOutputStream fos = new FileOutputStream(file);
	    workbook.write(fos);
	    fos.close();
	    workbook.close();
	}


	
	
	
	
	public void readExcel(String sheet,int rowNumber, int cellNumber) throws IOException {
		DataFormatter formatter = new DataFormatter();


		String filePath = System.getProperty("user.dir")+"\\testData\\flipkartTestData.xlsx";
		File Path = new File(filePath);
		FileInputStream fis = new FileInputStream(Path);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheet(sheet);
		
		int rowCount = sheet1.getPhysicalNumberOfRows();
		XSSFRow row = sheet1.getRow(0);
		
		int colCount = row.getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i=0; i<rowCount-1; i++) {
			XSSFRow currentRow = sheet1.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				System.out.println(currentRow.getCell(j)+"");
				
				XSSFCell cell = currentRow.getCell(j);
				
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		
	}

}
