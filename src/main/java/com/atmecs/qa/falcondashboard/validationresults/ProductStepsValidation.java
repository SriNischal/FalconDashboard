package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductStepsValidation {
	Browser browser = null;
	ReadLocators read = new ReadLocators();
	ValidationHelper helper;
	Pageactions page;

	public ProductStepsValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
	}
	public void validateStatusOption() throws Exception {
		String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Status option");
		helper.getDataofRow(expectedData, "validate.productstatus.txt",50);
	}
    public void validateDetailsOption() throws Exception {
		String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Details option");
		helper.getDataofRow(expectedData, "validate.details.txt",51);
	}
	public void validateTestCase() throws Exception {
		String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Test Case");
		helper.getDataofRow(expectedData, "validate.testcase.txt",52);
	}
	public void validateRequestBody() throws Exception {
		String expectedData = page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Request Body");
		helper.getDataofRow(expectedData, "validate.request.txt",53);
	}

}
