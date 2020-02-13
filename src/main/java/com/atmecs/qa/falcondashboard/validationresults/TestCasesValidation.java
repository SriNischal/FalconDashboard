package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class TestCasesValidation {
		Browser browser = null;
		ReadLocators read=new ReadLocators();
		ValidationHelper helper = new ValidationHelper(browser);
		public TestCasesValidation(Browser browser) {
			this.browser = browser;
		}

		@SuppressWarnings("static-access")
		public void validateFailedTestCase() throws Exception {
			Pageactions page = new Pageactions(browser);
			ValidationHelper helper = new ValidationHelper(browser);
			String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
			System.out.println("productname: "+product);
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Failed Test Case");
			helper.getdata(expectedData, "validate.failtestcase.txt");
		}
		
		@SuppressWarnings("static-access")
		public void validatePassedTestCase() throws Exception {
			Pageactions page = new Pageactions(browser);
			ValidationHelper helper = new ValidationHelper(browser);
			String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
			System.out.println("productname: "+product);
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Passed Test Case");
			helper.getdata(expectedData, "validate.passtestcase.txt");
		}
		
		@SuppressWarnings("static-access")
		public void validatecolorOfTestCases() throws Exception {
			Pageactions page = new Pageactions(browser);
			ValidationHelper helper = new ValidationHelper(browser);
			String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
			System.out.println("productname: "+product);
			String expectedData = page.getdata_fromExcel(product, "Validation Text", "Color of total test cases");
			helper.getdata(expectedData, "validate.coloroftestcases.txt");
		}
}
