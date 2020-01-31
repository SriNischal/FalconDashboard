package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class MainNavigationValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public MainNavigationValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateDashboard() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Dashboard");
		helper.getdata(expectedData, "validate.dashboardpage.txt");
	}
	public void validateRecentruns() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Recentruns Page");
		helper.getdata(expectedData, "validate.recentruns.txt");
	}
	public void validateView() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "View option");
		helper.getdata(expectedData, "validate.view.txt");
	}
	public void validateProductSnapshot() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Productsnap");
		helper.getdata(expectedData, "validate.productsnapshot.txt");
	}
	public void validaterecentrunstext() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Recentruns Page");
		helper.getdata(expectedData, "validate.recentrunstext.txt");
	}
	public void validaterecentrunspaneltitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Panel Title");
		helper.getdata(expectedData, "validate.recentrunspaneltitle.txt");
	}
	public void validateviewpaneltitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Viewpanel");
		helper.getdata(expectedData, "validate.productpaneltitle.txt");
	}
}
