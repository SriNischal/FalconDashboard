package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ViewPageValidation {
	Browser browser = null;
	ReadLocators read=new ReadLocators();
	ValidationHelper helper = new ValidationHelper(browser);
	public ViewPageValidation(Browser browser) {
		this.browser = browser;
	}
	@SuppressWarnings("static-access")
	public void validateText() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		System.out.println("productname: "+product);
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "View option");
		helper.getdata(expectedData, "validate.view.txt");
	}
	@SuppressWarnings("static-access")
	public void validateTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Test Cases");
		helper.getdata(expectedData, "validate.viewtests.txt");
	}
	@SuppressWarnings("static-access")
	public void validateTime() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Time");
		helper.getdata(expectedData, "validate.time.txt");
	}
	@SuppressWarnings("static-access")
	public void validatePassTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Passed Test Cases");
		helper.getdata(expectedData, "validate.passtestcases.txt");
	}
	@SuppressWarnings("static-access")
	public void validatePassPercent() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Pass Percent");
		helper.getdata(expectedData, "validate.viewpasspercent.txt");
	}
	@SuppressWarnings("static-access")
	public void validateFailTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Failed Test Cases");
		helper.getdata(expectedData, "validate.failtestcases.txt");
	}
	@SuppressWarnings("static-access")
	public void validateFailMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Fail message");
		helper.getdata(expectedData, "validate.failmessage.txt");
	}
	@SuppressWarnings("static-access")
	public void validateSkipTestCases() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skipped Test Cases");
		helper.getdata(expectedData, "validate.skiptestcases.txt");
	}
	@SuppressWarnings("static-access")
	public void validateSkipMessage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Skip message");
		helper.getdata(expectedData, "validate.skipmessage.txt");
	}
}
