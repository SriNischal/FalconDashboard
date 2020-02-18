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

	Pageactions page;
	ValidationHelper helper;

	public DashboardPageValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
	}
	public void validatefalconlogo() throws Exception {
		String expectedData= page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Atmecs Logo");
		helper.getDataofRow(expectedData, "validate.logo.txt",3);

	}
	public void validateproductsnapshot() throws Exception {
		String expectedData= page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Product Snapshot Text");
		helper.getDataofRow(expectedData, "validated.productsnapshotbar.txt",9);

	}
	public void validateListOfProducts() throws Exception {
		String expectedData= page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Products Texts");
		helper.getDataofRow(expectedData, "validate.product.txt",11);
	}
	public void validateDashboard() throws Exception {
		String data=page.getdata_fromExcel("REST API TEST RESULT","Validation Text", "Dashboard Text");
		helper.getDataofRow(data, "validate.dashboardpage.txt",2);	
	}
	public void validateRecentExecutionTime() throws Exception {
		String expectedData= page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Products Recent Execution time");
		helper.getDataofRow(expectedData, "loc.executiontime.txt",12);

	}

}