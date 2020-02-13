package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductStepsValidation {
	Browser browser = null;
	ReadLocators read=new ReadLocators();
	ValidationHelper helper = new ValidationHelper(browser);
	public ProductStepsValidation(Browser browser) {
		this.browser = browser;
	}

	@SuppressWarnings("static-access")
	public void validateStatusOption() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Status option");
		helper.getdata(expectedData, "validate.productstatus.txt");
	}
	
	@SuppressWarnings("static-access")
	public void validateDetailsOption() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Details option");
		helper.getdata(expectedData, "validate.details.txt");
	}
	
	@SuppressWarnings("static-access")
	public void validateTestCase() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Test Case");
		helper.getdata(expectedData, "validate.testcase.txt");
	}
	
	@SuppressWarnings("static-access")
	public void validateRequestBody() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData = page.getdata_fromExcel(productname, "Validation Text", "Request Body");
		helper.getdata(expectedData, "validate.request.txt");
	}

}


