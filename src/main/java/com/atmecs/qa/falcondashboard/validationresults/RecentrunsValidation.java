package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class RecentrunsValidation {
	Browser browser = null;
	ValidationHelper helper;
	Pageactions page;
	public RecentrunsValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}

	public void validateText() throws Exception {
		helper.getDataofRow("Recentruns Page title", "validate.text.txt",5);
	}
	public void validatePanelTitle() throws Exception {
		helper.getDataofRow("Recent Runs Panel Title", "validate.recentrunspaneltitle.txt",7);
	}
	public void validateProductName() throws Exception {
		helper.getDataofRow("Product Text", "validate.productnamme.txt",37);
	}
	public void validateComponent() throws Exception {
		helper.getDataofRow("Component Text", "validate.component.txt",38);
	}
	public void validateTestCase() throws Exception {
		helper.getDataofRow("Testcase Text", "validate.testcases.txt",39);
	}
	public void validatePassPercent() throws Exception {
		helper.getDataofRow("Pass Percent Text", "validate.passpercent.txt",40);
	}
	public void validateLastRun() throws Exception {
		helper.getDataofRow("Last Run Text", "validate.lastrun.txt",41);
	}
	public void validatePercentageCompleted() throws Exception {
		helper.getDataofRow("Percentage Completed ", "validate.percentagecompleted.txt",57);
	}
	public void validateSortingPassPercent() throws Exception {
		helper.getDataofRow("Sorting percentage", "validate.percentagecompleted.txt",58);
	}
}