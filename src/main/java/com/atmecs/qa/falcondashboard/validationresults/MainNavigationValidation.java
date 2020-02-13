package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class MainNavigationValidation {
	Browser browser = null;
	ReadLocators read=new  ReadLocators();
	ValidationHelper helper = new ValidationHelper(browser);
	public MainNavigationValidation(Browser browser) {
		this.browser = browser;
	}

	@SuppressWarnings("static-access")
	public void validateDashboard() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		System.out.println("productname: "+product);
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Dashboard");
		helper.getdata(expectedData, "validate.dashboardpage.txt");
	}
	public void validateRecentruns() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String product=helper.getData();
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Recentruns Page title");
		helper.getdata(expectedData, "validate.recentruns.txt");
	}
	public void validateView() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "View option");
		helper.getdata(expectedData, "validate.view.txt");
	}
	@SuppressWarnings("static-access")
	public void validateProductSnapshot() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Product Snapshot Text");
		helper.getdata(expectedData, "validate.productsnapshot.txt");
	}
	public void validateRecentRunsText() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Recentruns Page");
		helper.getdata(expectedData, "validate.recentrunstext.txt");
	}
	public void validateRecentRunsPanelTitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC07_Main Navigation", "Validation Text", "Panel Title");
		helper.getdata(expectedData, "validate.recentrunspaneltitle.txt");
	}
	@SuppressWarnings("static-access")
	public void validateViewPanelTitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "View Panel Title");
		helper.getdata(expectedData, "validate.productpaneltitle.txt");
	}
}
