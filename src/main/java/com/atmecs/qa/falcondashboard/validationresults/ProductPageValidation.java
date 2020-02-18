package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductPageValidation {
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ValidationHelper helper;
	Pageactions page;
	public ProductPageValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}
	public void validateProduct() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Product Name");
		helper.getDataofRow(expectedData, "validate.product.txt",10);
	}
	public void validatePanelTitle() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "View Panel Title");
		helper.getDataofRow(expectedData, "validate.productpaneltitle.txt",8);
	}
	public void validateEnvironment() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Environment");
		helper.getDataofRow(expectedData, "validate.environment.txt",17);
	}
	public void validateTestPhase() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Test Phase");
		helper.getDataofRow(expectedData, "validate.testphase.txt",18);
	}
}