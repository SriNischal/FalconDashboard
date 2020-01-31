package com.atmecs.qa.falcondashboard.validationresults;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.Pageactions;

public class ProductPageValidation {
	Browser browser = null;
	ValidationHelper helper = new ValidationHelper(browser);
	public ProductPageValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateproduct() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Product");
		helper.getdata(expectedData, "validate.product.txt");
	}
	public void validatepanelitle() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Panel title");
		helper.getdata(expectedData, "validate.productpaneltitle.txt");
	}
	public void validateEnvironment() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Environment");
		helper.getdata(expectedData, "validate.environment.txt");
	}
	public void validateTestPhase() throws Exception {
		Pageactions page = new Pageactions(browser);
		//String locator = page.randomnumber("loc.product.btn");
		ValidationHelper helper = new ValidationHelper(browser);
		//String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Test Phase");
		String expectedData=page.getdatabycellvalue("Products", 6, 1);
		helper.getdata(expectedData, "validate.testphase.txt");
	}
}

/*
 * String name=filters.setEnvironmentName("QA"); String
 * data=filters.setTestPhaseName("Regression"); System.out.println(name);
 * System.out.println(data);
 * 
 * String productName="(//h4[@class='media-box-heading ng-binding'])[1]";
	    Filters filters=page.getFiltersData(browser).get(productName);
		Filters filters=new Filters();
 */