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
			String product=helper.getData();
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Failed Test Case");
			helper.getdata(expectedData, "validate.failtestcase.txt");
		}
		public void validatePassedTestCase() throws Exception {
			String product=helper.getData();
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Passed Test Case");
			helper.getdata(expectedData, "validate.passtestcase.txt");
		}
		public void validatecolorOfTestCases() throws Exception {
			String product=helper.getData();
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Color of total test cases");
			helper.getdata(expectedData, "validate.coloroftestcases.txt");
		}
}
