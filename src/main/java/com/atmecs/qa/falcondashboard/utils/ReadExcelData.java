package com.atmecs.qa.falcondashboard.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
 
public class ReadExcelData
{
    public static void main(String args[]) throws Exception
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\srinischal.thiparani\\FalconDashboardAutomation\\falcondashboard\\src\\main\\resources\\testdata\\falcondashboard.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Products");
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(1);
 
        String userName = String.valueOf(cell.getStringCellValue());
        System.out.println("Value from the Excel sheet :"+ userName);
    }
}
