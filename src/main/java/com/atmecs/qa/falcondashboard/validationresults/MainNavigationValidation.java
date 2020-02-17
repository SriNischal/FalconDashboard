package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class MainNavigationValidation {
	Browser browser = null;
	ReadLocators read=new  ReadLocators();
	ValidationHelper helper;
	Pageactions page;
	public MainNavigationValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}
	public void validateDashboard() throws Exception {
		String product=helper.getData();
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Dashboard Text");
		helper.getDataofRow(expectedData, "validate.dashboardpage.txt",2);
	}
	public void validateRecentruns() throws Exception {
		String product=helper.getData();
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Recentruns Page title");
		helper.getDataofRow(expectedData, "validate.recentruns.txt",5);
	}
	public void validateView() throws Exception {
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "View option");
		helper.getdata(expectedData, "validate.view.txt");
	}
	public void validateProductSnapshot() throws Exception {
		String productname=helper.getData();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Product Snapshot Text");
		helper.getDataofRow(expectedData, "validate.productsnapshot.txt",9);
	}
	public void validateProductSnapshotText() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Product Snapshot Text");
		helper.getDataofRow(expectedData, "validate.productsnapshot.txt",9);
	}
	public void validateRecentRunsText() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Text");
		helper.getdata(expectedData, "validate.text.txt");
	}
	public void validateRecentRunsPanelTitle() throws Exception {
		String expectedData=page.getdata_fromExcel("TC06_Recent Runs", "Validation Text", "Panel Text");
		helper.getdata(expectedData, "validate.recentrunspaneltitle.txt");
	}
	public void validateViewPanelTitle() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "View Panel Title");
		helper.getDataofRow(expectedData, "validate.productpaneltitle.txt",8);
	}
}
