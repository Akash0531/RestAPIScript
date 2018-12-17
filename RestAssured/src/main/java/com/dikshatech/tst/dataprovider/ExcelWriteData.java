package com.dikshatech.tst.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//import java.io.File;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Excel_WriteData {
//	
//	XSSFWorkbook wb;
//	XSSFSheet sheet;
//	XSSFRow row;
//	XSSFCell cell;
//	
//	public Excel_WriteData(String excelpath, String sheetname, int rownum, int columnnum, String data)
//	{ 
//	     File src = new File(excelpath);
//	     FileInputStream fis;
//		try {
//			fis = new FileInputStream(src);
//			
//				XSSFWorkbook wb = new XSSFWorkbook(fis);
//			}
//		    catch (Exception e)
//		    {
//			
//				e.printStackTrace();
//			}
//		
//		 
//	
//     XSSFSheet sheet = wb.getSheet(sheetname);
//     sheet.getRow(rownum).createCell(columnnum).setCellValue(data);
//     
//     
//	 FileOutputStream fout;
//	try {
//		fout = new FileOutputStream(src);
//		
//			wb.write(fout);
//			wb.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     
//			
//		
//	
//     
//}}

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Excel_WriteData {
//	key
//	public static void main(String[] args) throws Exception
//	{ 
//	     File src = new File("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/TestingSheet.xlsx");
//	     FileInputStream fis = new FileInputStream(src);
//		 XSSFWorkbook wb = new XSSFWorkbook(fis);
//	
//	     XSSFSheet sheet = wb.getSheet("abc");
//	     sheet.getRow(3).createCell(2).setCellValue("Pass");
//	     
//	     FileOutputStream fout = new FileOutputStream(src);
//	     wb.write(fout);
//	     wb.close();
//	}
//	
//}

//import java.io.File;
//
//import java.io.FileInputStream;
//
//import java.io.FileOutputStream;
//
//import java.io.IOException;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkkeybook;
//
//import org.apache.poi.ss.usermodel.Cell;
//
//import org.apache.poi.ss.usermodel.Row;
//
//import org.apache.poi.ss.usermodel.Sheet;
//
//import org.apache.poi.ss.usermodel.Workbook;
//
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Excel_WriteData {
//
//    
//
//    public void writeExcel(String filePath,String sheetName,String[] dataToWrite) throws IOException{
//
//        //Create an object of File class to open xlsx file
//
//        File file =    new File(filePath);
//
//        //Create an object of FileInputStream class to read excel file
//
//        FileInputStream inputStream = new FileInputStream(file);
//
//        Workbook guru99Workbook = null;
//
//        //Find the file extension by splitting  file name in substring and getting only extension name
//
////        String fileExtensionName = fileName.substring(fileName.indexOf("."));
////
////        //Check condition if the file is xlsx file
////
////        if(fileExtensionName.equals(".xlsx")){
////
////        //If it is xlsx file then create object of XSSFWorkbook class
////
////        guru99Workbook = new XSSFWorkbook(inputStream);
////
////        }
////
////        //Check condition if the file is xls file
////
////        else if(fileExtensionName.equals(".xls")){
////
////            //If it is xls file then create object of XSSFWorkbook class
////
////            guru99Workbook = new HSSFWorkbook(inputStream);
////
////        }
//
//        
//
//    //Read excel sheet by sheet name    
//key
//    Sheet sheet = guru99Workbook.getSheet(sheetName);
//
//    //Get the current count of rows in excel file
//
//    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//
//    //Get the first row from the sheet
//
//    Row row = sheet.getRow(0);
//
//    //Create a new row and append it at last of sheet
//
//    Row newRow = sheet.createRow(rowCount+1);
//
//    //Create a loop over the cell of newly created Row
//
//    for(int j = 0; j < row.getLastCellNum(); j++){
//
//        //Fill data in row
//
//        Cell cell = newRow.createCell(j);
//
//        cell.setCellValue(dataToWrite[j]);
//
//    }
//
//    //Close input stream
//
//    inputStream.close();
//
//    //Create an object of FileOutputStream class to create write data in excel file
//
//    FileOutputStream outputStream = new FileOutputStream(file);
//
//    //write data in the excel file
//
//    guru99Workbook.write(outputStream);
//
//    //close output stream
//
//    outputStream.close();
//
//    
//
//    }
//
//    
//
//    public static void main(String...strings) throws IOException{
//
//        //Create an array with the data in the same order in which you expect to be filled in excel file
//
//        String[] valueToWrite = {"Mr. E","Noida"};
//
//        //Create an object of current class
//
//        Excel_WriteData objExcelFile = new Excel_WriteData();
//
//        //Write the file using file name, sheet name and the data to be filled
//
//       // objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);
//        objExcelFile.writeExcel("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/TestingSheet.xlsx", "abc", valueToWrite);
//
//    }

//}

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteData {
	public void Write_Data(String sheetname, int rownum, int colnum, String data) throws Exception {
		String path = (new File(ConfigDataProvider.getProp().getProperty("commonsheetpath")).getAbsolutePath());
		String path1 = path.concat("/"+ConfigDataProvider.getProp().getProperty("excelname"));

		FileInputStream fis = new FileInputStream(path1);
		FileOutputStream fos = null;
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style = workbook.createCellStyle();

		row = sheet.createRow(rownum);

		cell = row.createCell(colnum);

		font.setFontName("Comic Sans MS");
		font.setFontHeight(10.0);
		font.setBold(true);
		font.setColor(HSSFColor.GREEN.index);

		style.setFont(font);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		cell.setCellValue(data);

		fos = new FileOutputStream(path1);
		workbook.write(fos);
		fos.close();
	}
}