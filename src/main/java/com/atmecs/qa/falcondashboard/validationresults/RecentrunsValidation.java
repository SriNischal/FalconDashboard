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
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Recentruns Page title");
		helper.getDataofRow(expectedData, "validate.text.txt",5);
	}
	public void validatePanelTitle() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Recent Runs Panel Title");
		helper.getDataofRow(expectedData, "validate.recentrunspaneltitle.txt",7);
	}
	public void validateProductName() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Product Text");
		helper.getDataofRow(expectedData, "validate.productnamme.txt",37);
	}
	public void validateComponent() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Component Text");
		helper.getDataofRow(expectedData, "validate.component.txt",38);
	}
	public void validateTestCase() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Testcase Text");
		helper.getDataofRow(expectedData, "validate.testcases.txt",39);
	}
	public void validatePassPercent() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Pass Percent Text");
		helper.getDataofRow(expectedData, "validate.passpercent.txt",40);
	}
	public void validateLastRun() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Last Run Text");
		helper.getDataofRow(expectedData, "validate.lastrun.txt",41);
	}
	public void validatePercentageCompleted() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Percentage Completed ");
		helper.getDataofRow(expectedData, "validate.percentagecompleted.txt",57);
	}
	public void validateSortingPassPercent() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Sorting percentage");
		helper.getDataofRow(expectedData, "validate.percentagecompleted.txt",58);
	}
}