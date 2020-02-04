package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class ProductStepsValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public ProductStepsValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateStatusOption() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC09_StepsOfProduct", "Validation Text", "Status option");
		helper.getdata(expectedData, "validate.productstatus.txt");
	}
	
	public void validateDetailsOption() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC09_StepsOfProduct", "Validation Text", "Details option");
		helper.getdata(expectedData, "validate.details.txt");
	}
	
	public void validateTestCase() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC09_StepsOfProduct", "Validation Text", "Test Case");
		helper.getdata(expectedData, "validate.testcase.txt");
	}
	
	public void validateRequestBody() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC09_StepsOfProduct", "Validation Text", "Request Body");
		helper.getdata(expectedData, "validate.request.txt");
	}

}


