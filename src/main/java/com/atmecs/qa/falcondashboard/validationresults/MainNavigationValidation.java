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
		helper.getDataofRow("Dashboard Text", "validate.dashboardpage.txt",2);
	}
	public void validateRecentruns() throws Exception {
		helper.getDataofRow("Recentruns Page title", "validate.recentruns.txt",5);
	}
	public void validateView() throws Exception {
		helper.getDataofRow("View option", "validate.view.txt",6);
	}
	public void validateProductSnapshot() throws Exception {
		helper.getDataofRow("Product Snapshot Text", "validate.productsnapshot.txt",9);
	}
	public void validateProductSnapshotText() throws Exception {
		helper.getDataofRow("Product Snapshot Text", "validate.productsnapshot.txt",9);
	}
	public void validateRecentRunsText() throws Exception {
		helper.getDataofRow("Recentruns Page title", "validate.text.txt",5);
	}
	public void validateRecentRunsPanelTitle() throws Exception {
		helper.getDataofRow("Recent Runs Panel Title", "validate.recentrunspaneltitle.txt",7);
	}
	public void validateViewPanelTitle() throws Exception {
		helper.getDataofRow("View Panel Title", "validate.productpaneltitle.txt",8);
	}
}
