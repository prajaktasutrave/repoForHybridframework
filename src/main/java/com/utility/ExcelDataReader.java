package com.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	XSSFWorkbook wb;

	public ExcelDataReader() throws Exception { // constructor creation

		String path = "D:\\eclipse workspace\\hybridframework\\TestData\\Data.xlsx";
		FileInputStream fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

	}

	public String getStringData(String sheetname, int row, int cell) {

		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}

	public String getNumericData(String sheetname, int row, int cell) {
		double data = wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		return String.valueOf(data);
	}

}
