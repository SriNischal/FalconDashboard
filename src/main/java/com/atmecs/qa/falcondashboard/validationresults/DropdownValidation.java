package com.atmecs.qa.falcondashboard.validationresults; 

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadDataFromExcel;

public class DropdownValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	ReadDataFromExcel read=new ReadDataFromExcel();
	public DropdownValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateCustomer() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC05_Dropdowns", "Validation Text", "Customer");
		helper.getdata(expectedData, "validate.customer.txt");
	}
	public void validateModule() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC05_Dropdowns", "Validation Text", "Module");
		helper.getdata(expectedData, "validate.module.txt");
	}
	public void validateStatus() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC05_Dropdowns", "Validation Text", "Status");
		helper.getdata(expectedData, "validate.failselectstatus.btn");
	}
	public void validateProductPanelTitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC05_Dropdowns", "Validation Text", "Title");
		helper.getdata(expectedData, "validate.paneltitle.txt");
	}
	public void validateErrorMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC05_Dropdowns", "Validation Text", "Error Message");
		helper.getdata(expectedData, "validate.errormessage.txt");
	}
}
