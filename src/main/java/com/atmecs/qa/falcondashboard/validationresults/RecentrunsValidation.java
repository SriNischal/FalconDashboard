package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class RecentrunsValidation {
	Browser browser = null;
	ValidationHelper helper;
	Pageactions page;
	public RecentrunsValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}

	public void validateText() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Text");
		helper.getdata(expectedData, "validate.text.txt");
	}
	public void validatePanelTitle() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Panel Text");
		helper.getdata(expectedData, "validate.recentrunspaneltitle.txt");
	}
	public void validateProductName() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Product");
		helper.getdata(expectedData, "validate.productnamme.txt");
	}
	public void validateComponent() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Component");
		helper.getdata(expectedData, "validate.component.txt");
	}
	public void validateTestCase() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Testcase");
		helper.getdata(expectedData, "validate.testcases.txt");
	}
	public void validatePassPercent() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Pass Percent");
		helper.getdata(expectedData, "validate.passpercent.txt");
	}
	public void validateLastRun() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Last Run");
		helper.getdata(expectedData, "validate.lastrun.txt");
	}
	public void validatePercentageCompleted() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Percentage Completed");
		helper.getdata(expectedData, "validate.percentagecompleted.txt");
	}
	public void validateSortingPassPercent() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Sorting percentage");
		helper.getdata(expectedData, "validate.percentagecompleted.txt");
	}
	public void validateSortingPoductName() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Sorting percentage");
		helper.getdata(expectedData, "validate.productname.txt");
	}
}