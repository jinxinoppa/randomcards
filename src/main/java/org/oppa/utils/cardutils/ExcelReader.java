package org.oppa.utils.cardutils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(ClassLoader.getSystemResourceAsStream("牌型1.xlsx"));
		XSSFSheet sheet = workbook.getSheet("50");
		int physicalNumberOfRow = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRow);
		workbook.close();
	}
}
