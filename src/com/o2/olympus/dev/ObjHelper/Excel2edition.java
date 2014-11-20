package com.o2.olympus.dev.ObjHelper;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.o2.olympus.dev.BaseUtility.BaseClass;



    public class Excel2edition extends BaseClass {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                
            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
                   try {
                       // Open the Excel file
                	   //System.out.println(Path);
                	   //System.out.println(SheetName);
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    System.out.println(ExcelWSheet);
                    } catch (Exception e)
                    {
                    	System.out.println("Error in SetExcelFile");
                    	e.printStackTrace();
                    	throw (e);
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                      String CellData = Cell.getStringCellValue();
                      System.out.println(CellData);
                      return CellData;
                      }catch (Exception e)
                      {
                    	  e.printStackTrace();
                        return"";
                      }
            }
            
            public static int RowCount() throws Exception 
            {                
                   try
                   {
                	   int RowCount = ExcelWSheet.getLastRowNum();
                       
                       return RowCount;
                   }
                   catch (Exception e)
                   {
                	   
                   }
				return 0;
                                          
            }
            
            public static int ColCountofRow(int RowNum) throws Exception 
            {
               try
                   {
                	                      
                	   int colCount=ExcelWSheet.getRow(RowNum).getLastCellNum();
                			   
                       return colCount;
                   }
                   catch (Exception e)
                   {
                	   
                   }
				return 0;
                                          
            }
            
           
            //This method is to write in the Excel cell, Row num and Col num are the parameters
            
            public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception 
            
            {
                   try{
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                    if (Cell == null) {
                        Cell = Row.createCell(ColNum);
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
                    
                                        
            
          // Constant variables Test Data path and Test Data file name
                          //FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
                         /* 
                          ExcelWBook.write(fileOut);
                          fileOut.flush();
                         fileOut.close();*/
                        }catch(Exception e){
                            throw (e);
                    }
                }
    }
