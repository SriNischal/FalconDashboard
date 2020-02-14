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
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Customer");
		helper.getdata(expectedData, "validate.customer.txt");
	}
	public void validateModule() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Module");
		helper.getdata(expectedData, "validate.module.txt");
	}
	public void validatePassStatus() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Pass Status");
		helper.getdata(expectedData, "validate.passselectstatus.btn");
	}
	public void validateFailStatus() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Fail Status");
		helper.getdata(expectedData, "validate.failselectstatus.btn");
	}
	public void validateSkipStatus() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skip Status");
		helper.getdata(expectedData, "validate.skipselectstatus.btn");
	}
	public void validateProductPanelTitle() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Status Title");
		helper.getdata(expectedData, "validate.paneltitle.txt");
	}
	public void validateErrorMessage() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Error Message");
		helper.getdata(expectedData, "validate.errormessage.txt");
	}
}
