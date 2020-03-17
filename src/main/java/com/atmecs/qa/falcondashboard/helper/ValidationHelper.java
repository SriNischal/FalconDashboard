package com.atmecs.qa.falcondashboard.helper;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;


public class ValidationHelper {
	Browser browser=null;
	
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	Pageactions page;
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String actualproduct;
	String expectedData;
	public ValidationHelper(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
	}
	public void getDataofRow(String expectedString,String validationMessage,int i) throws Exception
	{
		actualproduct=page.getText(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		page.writedata_toExcel(sheetname, columnname, i, actualproduct);
	    expectedData=page.getdata_fromExcel(sheetname, columnname, expectedString);
		Verify.verifyString(actualproduct, expectedData, "Validating the text value");
	}
	
	public String getData() throws Exception {
		String product=page.getText(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		return product;
	}
	
	public String getDataFromUi() throws Exception {
		String pagetitle = page.getText(ReadLocators.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		return productname;
	}
}
