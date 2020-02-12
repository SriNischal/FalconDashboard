package com.atmecs.qa.falcondashboard.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
public class ReadExcelFile {
	RandomNumber random=new RandomNumber();
	XSSFWorkbook workbook;
	XSSFSheet sheet1;

	/**
	 * 
	 * @param filePath The constructor takes file path as the parameter, reads the
	 *                 file and initializes the workbook
	 */

	public ReadExcelFile(String filePath) {
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			try {
				workbook = new XSSFWorkbook(fileInput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getData(int index, int rowNum, int cellNum) throws Exception {
        
		sheet1 = workbook.getSheetAt(index);
		String number = Integer.toString(rowNum);
		System.out.println(number);
		String data = sheet1.getRow(rowNum).getCell(cellNum).getStringCellValue();
		System.out.println("data: "+data);
		return data;
	}
	public   int totalRowsinSheet(int sheet) {
		int rowCount = workbook.getSheetAt(sheet).getLastRowNum();
		//System.out.println("rowCount::"+rowCount);
		return rowCount;
	}
	
	public int totalColsinSheet(int sheetIndex,int rowCount) {
		int colCount = workbook.getSheetAt(sheetIndex).getRow(rowCount).getLastCellNum();
		
		return colCount;
	}
	public static void main(String[] args) throws Exception {
		ReadExcelFile ref= new ReadExcelFile(ProjectBaseConstantPaths.EXCEL_FILE);
		
		ref.totalRowsinSheet(8);
		System.out.println("total cols in rows "+ref.totalColsinSheet(0,8));
         System.out.println("Data in row is"+ref.getData(3, 42, 1));
         System.out.println("Data in row is"+ref.getData(3, 42, 2));
         System.out.println("Data in row is"+ref.getData(3, 42, 3));
         System.out.println("Data in row is"+ref.getData(3, 42, 4));
         System.out.println("Data in row is"+ref.getData(3, 42, 5));
         System.out.println("Data in row is"+ref.getData(3, 42, 6));
         System.out.println("Data in row is"+ref.getData(3, 42, 7));
         System.out.println("Data in row is"+ref.getData(3, 42, 8));
         System.out.println("Data in row is"+ref.getData(3, 42, 9));
         System.out.println("Data in row is"+ref.getData(3, 1, 1));
		
	}

}
