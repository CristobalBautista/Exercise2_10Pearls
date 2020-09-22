package com.linkedin.util;

import static com.linkedin.util.Constants.DATA_DRIVEN_PATH;
import static com.linkedin.util.Constants.EMPTY_STRING;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] getLoginData() {

		XSSFWorkbook workbook = null;

		try {
			File dataFile = new File(DATA_DRIVEN_PATH);
			FileInputStream file = new FileInputStream(dataFile);
			workbook = new XSSFWorkbook(file);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		Sheet loginSheet = workbook.getSheetAt(0);
		String credentialsData[][] = new String[loginSheet.getLastRowNum()][2];

		for (int rowIndex = 1; rowIndex <= loginSheet.getLastRowNum(); rowIndex++) {
			Row row = loginSheet.getRow(rowIndex);
			credentialsData[rowIndex - 1][0] = row.getCell(0) != null ? row.getCell(0).getStringCellValue()
					: EMPTY_STRING;
			credentialsData[rowIndex - 1][1] = row.getCell(1) != null ? row.getCell(1).getStringCellValue()
					: EMPTY_STRING;
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return credentialsData;
	}
}
