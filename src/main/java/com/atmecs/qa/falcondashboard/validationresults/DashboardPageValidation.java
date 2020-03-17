package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadDataFromExcel;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class DashboardPageValidation {
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ReadDataFromExcel readingData=new ReadDataFromExcel();
	ReadLocators read=new ReadLocators();
    String sheetname="REST API TEST RESULT";
    String columnname="Validation Text";
	Pageactions page;
	ValidationHelper helper;

	public DashboardPageValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
		//reports=new ExtentReport(browser);
	}
	public void validatefalconlogo() throws Exception {
		helper.getDataofRow("Atmecs Logo", "validate.logo.txt",3);
	}
	public void validateproductsnapshot() throws Exception {
		helper.getDataofRow("Product Snapshot Text", "validated.productsnapshotbar.txt",9);
	}
	public void validateListOfProducts() throws Exception {
		helper.getDataofRow("Products Texts", "validate.product.txt",11);
	}
	public void validateDashboard() throws Exception {
		helper.getDataofRow("Dashboard Text", "validate.dashboardpage.txt",2);	
	}
	public void validateRecentExecutionTime() throws Exception {
		helper.getDataofRow("Products Recent Execution time", "loc.executiontime.txt",12);
	}

}