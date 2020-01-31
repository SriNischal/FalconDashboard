package com.atmecs.qa.falcondashboard.utils;

import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class ReadingData {
	  ReadDataFromExcel reader = getsheet(ProjectBaseConstantPaths.EXCEL_FILE);
	  
	  
		public ReadDataFromExcel getsheet(String sheetname) {
			ReadDataFromExcel read = new ReadDataFromExcel();
			try {
				read.setPath(sheetname);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return read;
		}
		 public String getdata_fromExcel(String sheetname, String columnname, String rowname) {
			 
			  String datavalue = reader.getCellDataByColumnName(sheetname, columnname, rowname); 
			  return datavalue;
			  }

}
