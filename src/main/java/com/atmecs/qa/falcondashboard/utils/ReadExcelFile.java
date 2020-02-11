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
		String locatorvalue = ReadLocators.getPropertyvalue(data, ProjectBaseConstantPaths.LOCATORS_FILE);
		System.out.println(locatorvalue + ".....xpath");
		String Locator = locatorvalue.replace("*", number);
		System.out.println(Locator);
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
         System.out.println("Data in row is"+ref.getData(3, 3, 1));
         System.out.println("Data in row is"+ref.getData(3, 3, 2));
         System.out.println("Data in row is"+ref.getData(3, 3, 3));
         System.out.println("Data in row is"+ref.getData(3, 3, 4));
         System.out.println("Data in row is"+ref.getData(3, 3, 5));
         System.out.println("Data in row is"+ref.getData(3, 3, 6));
         System.out.println("Data in row is"+ref.getData(3, 3, 7));
		
	}
	
	
	
	public String randomnumber(String locator) throws Exception {
		int randomnumber = random.generateRandomNumber();
		System.out.println(randomnumber);
		String number = Integer.toString(randomnumber);
		System.out.println(number);
		String locatorvalue = ReadLocators.getPropertyvalue(locator, ProjectBaseConstantPaths.LOCATORS_FILE);
		System.out.println(locatorvalue + ".....xpath");
		String Locator = locatorvalue.replace("*", number);
		System.out.println(Locator);
		return Locator;
	}

}
