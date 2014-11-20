package com.o2.olympus.dev.ObjHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelInput 
{

	public void readExcel(String filePath,String fileName,String sheetName) throws IOException
	
	{
		 
	    //Create a object of File class to open xlsx file
	 
	    File file = new File(filePath);
	 
	    //Create an object of FileInputStream class to read excel file
	 
	    FileInputStream inputStream = new FileInputStream(file);
	 
	    Workbook olympusDev = null;
	 
	    //Find the file extension by spliting file name in substring and getting only extension name
	 
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	 
	    //Check condition if the file is xlsx file
	 
	    if(fileExtensionName.equals(".xlsx"))
	    {
	 
	    //If it is xlsx file then create object of XSSFWorkbook class
	 
	    	olympusDev = new XSSFWorkbook(inputStream);
	 
	    }
	 
	    //Check condition if the file is xls file
	 
	    else if(fileExtensionName.equals(".xls")){
	 
	        //If it is xls file then create object of XSSFWorkbook class
	 
	    	olympusDev = new HSSFWorkbook(inputStream);
	 
	    }
	 
	    //Read sheet inside the workbook by its name
	 
Sheet olympussheet = olympusDev.getSheet(sheetName);


	 
	    //Find number of rows in excel file
	 
	    int rowCount = olympussheet.getLastRowNum()-olympussheet.getFirstRowNum();
	 
	    //Create a loop over all the rows of excel file to read it
	 
	    for (int i = 0; i < rowCount+1; i++) {
	 
	        Row row = olympussheet.getRow(i);
	 
	        //Create a loop to print cell values in a row
	 
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	 
	            //Print excel data in console
	 
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	 
	        }
	 
	        System.out.println();
	 
	    }
	 
	     
	 
	    }
	 
/*	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
        try{
        	Sheet olympussheet = olympusDev.getSheet(sheetName);
           Cell = olympussheet.getRow(RowNum).getCell(ColNum);
           String CellData = Cell.getStringCellValue();
           System.out.println(CellData);
           return CellData;
           }
        catch (Exception e)
           {
         	  e.printStackTrace();
             return"";
           }
 }*/
	 
	    //Main function is calling readExcel function to read data from excel file
	 
	    public static void main(String[] args) throws IOException{
	 
	    //Create a object of ReadGuru99ExcelFile class
	 
	    	ExcelInput objExcelFile = new ExcelInput();
	 
	    //Prepare the path of excel file
	 
	    String filePath = System.getProperty("user.dir")+"\\olympus_input.xlsx";
	 
	    //Call read file method of the class to read data
	 
	    objExcelFile.readExcel(filePath,"olympus_input.xlsx","Login");
	    //objExcelFile.readExcel(filePath,"olympus_input.xlsx","Sheet2");
	 
	    }
	 
	}

