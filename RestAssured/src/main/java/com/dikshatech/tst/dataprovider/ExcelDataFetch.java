package com.dikshatech.tst.dataprovider;

import com.dikshatech.tst.pagefatory.TestBase;

public class ExcelDataFetch extends TestBase {

	public static void main(String[] args) throws Exception {
		
//		Excel_Read_Data read = new Excel_Read_Data("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/Diksha_Portal (copy).xlsx");
//		String cell_Value= read.getData("Airtel_Portal_Login_Page", 8, 4);
//		System.out.println(cell_Value);
//    
//		Excel_Read_Data read1 = new Excel_Read_Data("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/Table_Data.xlsx");
//		String cell_Value1= read1.getData("abc", 4, 2).toString();
//		System.out.println(cell_Value1);
//		
//	
//		Excel_Read_Data read2 = new Excel_Read_Data("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/Login_Credentials_Sheet.xlsx");
//		String cell_Value2= read2.getData("Login_Credentials", 1, 1).toString();
//		System.out.println(cell_Value2);
//		
//		Excel_Read_Data read3 = new Excel_Read_Data("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/Leaves_Sheet1.xlsx");
//		String cell_Value3= read3.getData("Leaves_Sheet", 0, 2).toString();
//		System.out.println(cell_Value3);	
		
		//Excel_WriteData write= new Excel_WriteData("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/TestingSheet.xlsx", "abc", 12, 2, "qwerty");
		
		
//		 String[] valueToWrite = {"Mr. E","Noida"};
//
//	        //Create an object of current class
//
//	        Excel_WriteData objExcelFile = new Excel_WriteData();
//
//	        //Write the file using file name, sheet name and the data to be filled
//
//	       // objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);
//	        objExcelFile.writeExcel("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/TestingSheet.xlsx", "abc", valueToWrite);
      /*    ExcelWriteData write = new ExcelWriteData();
          String abc="Customer Name";
          write.Write_Data("Pipedrive", 0, 0, abc);*/
		
		int count= excelreaddata().rowCount("Login_Credentials");
System.out.println(count);		

int c= excelreaddata().cellCount("Login_Credentials", 1);
System.out.println(c);
	}

}