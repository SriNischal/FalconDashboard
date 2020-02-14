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
		helper.getdata(expectedData, "validate.view.txt");
	}
	public void validateTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Test Cases");
		helper.getdata(expectedData, "validate.viewtests.txt");
	}
	public void validateTime() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Time");
		helper.getdata(expectedData, "validate.time.txt");
	}
	public void validatePassTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Passed Test Cases");
		helper.getdata(expectedData, "validate.passtestcases.txt");
	}
	public void validatePassPercent() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Pass Percent");
		helper.getdata(expectedData, "validate.viewpasspercent.txt");
	}
	public void validateFailTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Failed Test Cases");
		helper.getdata(expectedData, "validate.failtestcases.txt");
	}
	public void validateFailMessage() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Fail message");
		helper.getdata(expectedData, "validate.failmessage.txt");
	}
	public void validateSkipTestCases() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skipped Test Cases");
		helper.getdata(expectedData, "validate.skiptestcases.txt");
	}
	public void validateSkipMessage() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skip message");
		helper.getdata(expectedData, "validate.skipmessage.txt");
	}
}
