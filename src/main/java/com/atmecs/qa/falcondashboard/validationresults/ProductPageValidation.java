package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductPageValidation {
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ValidationHelper helper;
	Pageactions page;
	public ProductPageValidation(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
		helper=new ValidationHelper(browser);
	}
	public void validateProduct() throws Exception {
		String product=helper.getData();
		String expectedData=page.getdata_fromExcel(product, "Validation Text", "Product Name");
		helper.getdata(expectedData, "validate.product.txt");
	}
	public void validatePanelTitle() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "View Panel Title");
		helper.getdata(expectedData, "validate.productpaneltitle.txt");
	}
	public void validateEnvironment() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Environment");
		helper.getdata(expectedData, "validate.environment.txt");
	}
	public void validateTestPhase() throws Exception {
		String productname=helper.getDataFromUi();
		String expectedData=page.getdata_fromExcel(productname, "Validation Text", "Test Phase");
		helper.getdata(expectedData, "validate.testphase.txt");
	}
}