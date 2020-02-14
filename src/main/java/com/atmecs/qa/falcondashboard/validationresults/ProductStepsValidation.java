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
		String productname = helper.getDataFromUi();
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Status option");
		helper.getdata(expectedData, "validate.productstatus.txt");
	}
    public void validateDetailsOption() throws Exception {
		String productname = helper.getDataFromUi();
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Details option");
		helper.getdata(expectedData, "validate.details.txt");
	}
	public void validateTestCase() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Test Case");
		helper.getdata(expectedData, "validate.testcase.txt");
	}
	public void validateRequestBody() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Request Body");
		helper.getdata(expectedData, "validate.request.txt");
	}

}
