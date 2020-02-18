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
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Customer");
		helper.getDataofRow(expectedData, "validate.customer.txt",24);
	}
	public void validateModule() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Module");
		helper.getDataofRow(expectedData, "validate.module.txt",25);
	}
	public void validatePassStatus() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Pass Status");
		helper.getDataofRow(expectedData, "validate.passselectstatus.btn",26);
	}
	public void validateFailStatus() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Fail Status");
		helper.getDataofRow(expectedData, "validate.failselectstatus.btn",27);
	}
	public void validateSkipStatus() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Skip Status");
		helper.getDataofRow(expectedData, "validate.skipselectstatus.btn",28);
	}
	public void validateProductPanelTitle() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Status Title");
		helper.getDataofRow(expectedData, "validate.paneltitle.txt",29);
	}
	public void validateErrorMessage() throws Exception {
		String expectedData=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Error Message");
		helper.getDataofRow(expectedData, "validate.errormessage.txt",30);
	}
}
