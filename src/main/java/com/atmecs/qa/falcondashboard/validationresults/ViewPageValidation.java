package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ViewPageValidation {
	Browser browser = null;
	ReadLocators read=new ReadLocators();
	ValidationHelper helper;
	Pageactions page;
	public ViewPageValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}
	public void validateText() throws Exception {
		String product=helper.getData();
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "View option");
		helper.getDataofRow(expectedData, "validate.view.txt",39);
	}
	public void validateTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Testcase Text");
		helper.getDataofRow(expectedData, "validate.viewtests.txt",42);
	}
	public void validateTime() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Time");
		helper.getDataofRow(expectedData, "validate.time.txt",43);
	}
	public void validatePassTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Passed Test Cases");
		helper.getDataofRow(expectedData, "validate.passtestcases.txt",44);
	}
	public void validatePassPercent() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Pass Percent");
		helper.getDataofRow(expectedData, "validate.viewpasspercent.txt",45);
	}
	public void validateFailTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Failed Test Cases");
		helper.getDataofRow(expectedData, "validate.failtestcases.txt",46);
	}
	public void validateFailMessage() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Fail message");
		helper.getDataofRow(expectedData, "validate.failmessage.txt",47);
	}
	public void validateSkipTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skipped Test Cases");
		helper.getDataofRow(expectedData, "validate.skiptestcases.txt",48);
	}
	public void validateSkipMessage() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skip message");
		helper.getDataofRow(expectedData, "validate.skipmessage.txt",49);
	}
}
