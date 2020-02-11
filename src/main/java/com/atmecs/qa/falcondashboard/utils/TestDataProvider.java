package com.atmecs.qa.falcondashboard.utils;

import org.testng.annotations.DataProvider;

import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class TestDataProvider {

	@DataProvider(name = "projectName")
	public Object[][] testData() throws Exception {
		ReadExcelFile file = new ReadExcelFile(ProjectBaseConstantPaths.EXCEL_FILE);
		int sheetIndex = 3;
		int rowNo= 1;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex,rowNo);

		System.out.println("In testData:: rowCount=" + rowCount);
		System.out.println("In testData:: colCount=" + colCount);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {

				data[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex + 1, colIndex);
			}
		}
		return data;
	}

	public static void main(String[] args) throws Exception {

		Object[][] data = new TestDataProvider().testData();
		for (Object[] objects : data) {
			String userName = (String) objects[0];
			System.out.println(userName);
			String password = (String) objects[1];
			System.out.println(password);
			String password1 = (String) objects[2];
			System.out.println(password1);
			String password2 = (String) objects[3];
			System.out.println(password2);
			String password3 = (String) objects[4];
			System.out.println(password3);
			String password4 = (String) objects[5];
			System.out.println(password4);
			String password5 = (String) objects[6];
			System.out.println(password5);
			//String url = (String) objects[2];
			System.out.println(" " + userName + " -- " + password);
		}

	}
}
