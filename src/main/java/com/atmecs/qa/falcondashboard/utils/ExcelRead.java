package com.atmecs.qa.falcondashboard.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class ExcelRead {
	int sheet;
	static int row;
	int column;
      public static void main(String[] args) throws Exception {
    	  File file=new File(ProjectBaseConstantPaths.EXCEL_FILE);
    	  FileInputStream fis=new FileInputStream(file);
    	  XSSFWorkbook book=new XSSFWorkbook(fis);
    	  XSSFSheet sheets=book.getSheetAt(1);
    	  String data=sheets.getRow(row).getCell(1).getStringCellValue();
    	  System.out.println("Data from excel is"+ data);
    	  book.close();
      }
      
}

