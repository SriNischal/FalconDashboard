package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class RecentrunsValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public RecentrunsValidation(Browser browser) {
		this.browser = browser;
	}

	public void validatetext() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Text");
		helper.getdata(expectedData, "validate.text.txt");
	}
	public void validatepaneltitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Panel Text");
		helper.getdata(expectedData, "validate.recentrunspaneltitle.txt");
	}
	public void validatecomponent() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Component");
		helper.getdata(expectedData, "validate.component.txt");
	}
	public void validatetestcase() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Testcase");
		helper.getdata(expectedData, "validate.testcases.txt");
	}
	public void validatepasspercent() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Pass Percent");
		helper.getdata(expectedData, "validate.passpercent.txt");
	}
	public void validatelastrun() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Last Run");
		helper.getdata(expectedData, "validate.lastrun.txt");
	}
	public void validatepercentagecompleted() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Percentage Completed");
		helper.getdata(expectedData, "validate.percentagecompleted.txt");
	}
	public void validatesortingpasspercent() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Sorting percentage");
		helper.getdata(expectedData, "validate.percentagecompleted.txt");
	}
}
