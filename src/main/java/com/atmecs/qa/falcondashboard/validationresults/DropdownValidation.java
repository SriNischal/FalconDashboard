package com.atmecs.qa.falcondashboard.validationresults; 

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadDataFromExcel;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class DropdownValidation {
	ReadLocators read=new ReadLocators();
	Browser browser = null;
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	ValidationHelper helper = new ValidationHelper(browser);
	public DropdownValidation(Browser browser) {
		this.browser = browser;
	}
	@SuppressWarnings("static-access")
	public void validateCustomer() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Customer");
		helper.getdata(expectedData, "validate.customer.txt");
	}
	@SuppressWarnings("static-access")
	public void validateModule() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Module");
		helper.getdata(expectedData, "validate.module.txt");
	}
	@SuppressWarnings("static-access")
	public void validatePassStatus() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Pass Status");
		helper.getdata(expectedData, "validate.passselectstatus.btn");
	}
	@SuppressWarnings("static-access")
	public void validateFailStatus() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Fail Status");
		helper.getdata(expectedData, "validate.failselectstatus.btn");
	}
	@SuppressWarnings("static-access")
	public void validateSkipStatus() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skip Status");
		helper.getdata(expectedData, "validate.skipselectstatus.btn");
	}
	@SuppressWarnings("static-access")
	public void validateProductPanelTitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Status Title");
		helper.getdata(expectedData, "validate.paneltitle.txt");
	}
	@SuppressWarnings("static-access")
	public void validateErrorMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Error Message");
		helper.getdata(expectedData, "validate.errormessage.txt");
	}
}
