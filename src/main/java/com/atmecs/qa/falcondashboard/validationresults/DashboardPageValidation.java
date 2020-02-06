package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;

import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class DashboardPageValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public DashboardPageValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateDashboardtext() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Dashboard Page");
		helper.getdata(expectedData, "validate.dashboardpage.txt");
	}
	public void validatefalconlogo() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Atmecs Logo");
		helper.getdata(expectedData, "validate.logo.txt");
		
	}
	public void validateproductsnapshot() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Product Snapshot");
		helper.getdata(expectedData, "validated.productsnapshotbar.txt");
		
	}
	public void validateListOfProducts() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Number of products");
		helper.getdata(expectedData, "loc.products.txt");
		
	}
	
	public void validateRecentExecutionTime() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Recent Execution time");
		helper.getdata(expectedData, "loc.executiontime.txt");
		
	}

}