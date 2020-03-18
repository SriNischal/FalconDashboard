package com.atmecs.qa.falcondashboard.validationresults; 

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class DropdownValidation {
	ReadLocators read=new ReadLocators();
	Browser browser = null;
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	ValidationHelper helper;
	Pageactions page;
	public DropdownValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
	}
	public void validateCustomer() throws Exception {
		helper.getDataofRow("Customer", "validate.customer.txt",24);
	}
	public void validateModule() throws Exception {
		helper.getDataofRow("Module", "validate.module.txt",25);
	}
	public void validateOS() throws Exception {
		helper.getDataofRow("OS", "validate.os.txt",59);
	}
	public void validateBrowser() throws Exception {
		helper.getDataofRow("Browser", "validate.browsertext.txt",60);
	}
	public void validatePassStatus() throws Exception {
		helper.getDataofRow("Pass Status", "validate.passselectstatus.btn",26);
	}
	public void validateFailStatus() throws Exception {
		helper.getDataofRow("Fail Status", "validate.failselectstatus.btn",27);
	}
	public void validateSkipStatus() throws Exception {
		helper.getDataofRow("Skip Status", "validate.skipselectstatus.btn",28);
	}
	public void validateProductPanelTitle() throws Exception {
		helper.getDataofRow("Status Title", "validate.paneltitle.txt",29);
	}
	public void validateErrorMessage() throws Exception {
		helper.getDataofRow("Error Message", "validate.errormessage.txt",30);
	}
}
