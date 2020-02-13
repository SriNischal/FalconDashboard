package com.atmecs.qa.falcondashboard.validationresults;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductPageValidation {
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public ProductPageValidation(Browser browser) {
		this.browser = browser;
	}
	@SuppressWarnings("static-access")
	public void validateProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		System.out.println("productname: "+product);
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Product Name");
		helper.getdata(expectedData, "validate.product.txt");
	}
	@SuppressWarnings("static-access")
	public void validatePanelTitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "View Panel Title");
		helper.getdata(expectedData, "validate.productpaneltitle.txt");
	}
	@SuppressWarnings("static-access")
	public void validateEnvironment() throws Exception {
		ReadLocators read=new ReadLocators();
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Environment");
		helper.getdata(expectedData, "validate.environment.txt");
	}
	@SuppressWarnings("static-access")
	public void validateTestPhase() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String pagetitle = page.getText(read.getPropertyvalue("loc.recentrunspagetitle.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = pagetitle.split(":", 3);
		String productname=arrOfStr[0].trim();
		System.out.println(productname);
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Test Phase");
		helper.getdata(expectedData, "validate.testphase.txt");
	}
}