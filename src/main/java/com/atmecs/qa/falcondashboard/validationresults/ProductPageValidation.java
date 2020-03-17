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
		helper.getDataofRow("Product Name", "validate.product.txt",10);
	}
	public void validatePanelTitle() throws Exception {
		helper.getDataofRow("View Panel Title", "validate.productpaneltitle.txt",8);
	}
	public void validateEnvironment() throws Exception {
		helper.getDataofRow("Environment", "validate.environment.txt",17);
	}
	public void validateTestPhase() throws Exception {
		helper.getDataofRow("Test Phase", "validate.testphase.txt",18);
	}
}