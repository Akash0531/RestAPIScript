package com.dikshatech.tst.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	public ExcelReadData(String Excelname) {

		String path = ConfigDataProvider.getProp().getProperty("commonsheetpath");
		String path1 = path.concat(Excelname);

		File src = new File(path1);
		FileInputStream fis;

		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getData(String sheetname, int rownum, int columnnum) {
		sheet = wb.getSheet(sheetname);

		row = sheet.getRow(rownum);

		cell = row.getCell(columnnum);
		

		if (cell.getCellType() == cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			return NumberToTextConverter.toText(cell.getNumericCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}
		if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
			return "";
		}
		return null;

	}

	public int rowCount(String sheetname) {
		int row = wb.getSheet(sheetname).getLastRowNum();
		row = row + 1;
		return row;

	}

	public int cellCount(String sheetname, int row) {
		int cell = wb.getSheet(sheetname).getRow(row).getLastCellNum();
		return cell;
	}
}