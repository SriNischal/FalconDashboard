package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ViewPageValidation {
	Browser browser = null;
	ReadLocators read=new ReadLocators();
	ValidationHelper helper;
	Pageactions page;
	public ViewPageValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}
	public void validateText() throws Exception {
		helper.getDataofRow("View option", "validate.view.txt",6);
	}
	public void validateTestCases() throws Exception {
		helper.getDataofRow("Test Cases", "validate.viewtests.txt",42);
	}
	public void validateTime() throws Exception {
		helper.getDataofRow("Time", "validate.time.txt",43);
	}
	public void validatePassTestCases() throws Exception {
		helper.getDataofRow("Passed Test Cases", "validate.passtestcases.txt",44);
	}
	public void validatePassPercent() throws Exception {
		helper.getDataofRow("Pass Percent", "validate.viewpasspercent.txt",45);
	}
	public void validateFailTestCases() throws Exception {
		helper.getDataofRow("Failed Test Cases", "validate.failtestcases.txt",46);
	}
	public void validateFailMessage() throws Exception {
		helper.getDataofRow("Fail message", "validate.failmessage.txt",47);
	}
	public void validateSkipTestCases() throws Exception {
		helper.getDataofRow("Skipped Test Cases", "validate.skiptestcases.txt",48);
	}
	public void validateSkipMessage() throws Exception {
		helper.getDataofRow("Skip message", "validate.skipmessage.txt",49);
	}
}
