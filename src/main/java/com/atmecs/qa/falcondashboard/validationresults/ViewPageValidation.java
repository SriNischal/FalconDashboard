package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class ViewPageValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public ViewPageValidation(Browser browser) {
		this.browser = browser;
	}
	public void validateText() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Text");
		helper.getdata(expectedData, "validate.view.txt");
	}
	public void validateTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Test Cases");
		helper.getdata(expectedData, "validate.viewtests.txt");
	}
	public void validateTime() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Time");
		helper.getdata(expectedData, "validate.time.txt");
	}
	public void validatePassTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Passed Test Cases");
		helper.getdata(expectedData, "validate.passtestcases.txt");
	}
	public void validatePassPercent() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Pass Percent");
		helper.getdata(expectedData, "validate.viewpasspercent.txt");
	}
	public void validateFailTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Failed Test Cases");
		helper.getdata(expectedData, "validate.failtestcases.txt");
	}
	public void validateFailMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Fail message");
		helper.getdata(expectedData, "validate.failmessage.txt");
	}
	public void validateSkipTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Skipped Test Cases");
		helper.getdata(expectedData, "validate.skiptestcases.txt");
	}
	public void validateSkipMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC08_Views", "Validation Text", "Skip message");
		helper.getdata(expectedData, "validate.skipmessage.txt");
	}
}
