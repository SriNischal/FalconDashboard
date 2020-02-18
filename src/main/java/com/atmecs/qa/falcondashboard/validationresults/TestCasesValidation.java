package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class TestCasesValidation {
		Browser browser = null;
		ReadLocators read=new ReadLocators();
		ValidationHelper helper;
		Pageactions page;
		public TestCasesValidation(Browser browser) {
			this.browser = browser;
			page=new Pageactions(browser);
			helper=new ValidationHelper(browser);
		}
		public void validateFailedTestCase() throws Exception {
			String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Failed Test Case");
			helper.getDataofRow(expectedData, "validate.failtestcase.txt",54);
		}
		public void validatePassedTestCase() throws Exception {
			String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Passed Test Case");
			helper.getDataofRow(expectedData, "validate.passtestcase.txt",55);
		}
}
