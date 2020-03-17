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
		helper.getDataofRow("Status option", "validate.productstatus.txt",50);
	}
    public void validateDetailsOption() throws Exception {
		helper.getDataofRow("Details option", "validate.details.txt",51);
	}
	public void validateTestCase() throws Exception {
		helper.getDataofRow("Test Case", "validate.testcase.txt",52);
	}
	public void validateRequestBody() throws Exception {
		helper.getDataofRow("Request Body", "validate.request.txt",53);
	}

}
