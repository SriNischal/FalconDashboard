package com.atmecs.qa.falcondashboard.validationresults;

import java.util.Map;

import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadDataFromExcel;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class DashboardPageValidation {
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ReadDataFromExcel readingData=new ReadDataFromExcel();
	ReadLocators read=new ReadLocators();
	Pageactions page=new Pageactions(browser);
	ValidationHelper helper = new ValidationHelper(browser);
	public DashboardPageValidation(Browser browser) {
		this.browser = browser;
	}
	public void validatefalconlogo() throws Exception {
		String product=helper.getData();
		String expectedData= page.getdata_fromExcel(product, "Validation Text", "Atmecs Logo");
		helper.getdata(expectedData, "validate.logo.txt");
		
	}
	public void validateproductsnapshot() throws Exception {
		String product=helper.getData();
		String expectedData= page.getdata_fromExcel(product, "Validation Text", "Product Snapshot Text");
		helper.getdata(expectedData, "validated.productsnapshotbar.txt");
		
	}
	public void validateListOfProducts() throws Exception {
		String product=helper.getData();
		String expectedData= page.getdata_fromExcel(product, "Validation Text", "Products Texts");
		helper.getdata(expectedData, "validate.product.txt");
	}
	public void validateDashboard() throws Exception {
		String product=helper.getData();
		String data=page.getdata_fromExcel(product,"Validation Text", "Dashboard Text");
	    helper.getdata(data, "validate.dashboardpage.txt");	
	}
	public void validateRecentExecutionTime() throws Exception {
		String product=helper.getData();
		String expectedData= page.getdata_fromExcel(product, "Validation Text", "Products Recent Execution time");
		helper.getdata(expectedData, "loc.executiontime.txt");
		
	}

}