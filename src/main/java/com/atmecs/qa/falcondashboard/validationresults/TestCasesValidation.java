package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class TestCasesValidation {
		Browser browser = null;
		ValidationHelper helper = new ValidationHelper(browser);
		public TestCasesValidation(Browser browser) {
			this.browser = browser;
		}

		public void validateFailedTestCase() throws Exception {
			Pageactions page = new Pageactions(browser);
			ValidationHelper helper = new ValidationHelper(browser);
			String expectedData = page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Failed Test Case");
			helper.getdata(expectedData, "validate.failtestcase.txt");
		}
		
		public void validatePassedTestCase() throws Exception {
			Pageactions page = new Pageactions(browser);
			ValidationHelper helper = new ValidationHelper(browser);
			String expectedData = page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Passed Test Case");
			helper.getdata(expectedData, "validate.passtestcase.txt");
		}
}
