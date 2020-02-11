package com.atmecs.qa.falcondashboard.validationresults;

import java.util.Map;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadDataFromExcel;
import com.atmecs.qa.falcondashboard.utils.ReadExcelFile;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class DashboardPageValidation {
	Browser browser = null;
	ReadExcelFile readingdata=new ReadExcelFile(ProjectBaseConstantPaths.EXCEL_FILE);
	ReadLocators read=new ReadLocators();
	ValidationHelper helper = new ValidationHelper(browser);
	public DashboardPageValidation(Browser browser) {
		this.browser = browser;
	}

	public void validateDashboardtext() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData = page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Dashboard Page");
		helper.getdata(expectedData, "validate.dashboardpage.txt");
	}
	public void validatefalconlogo() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Atmecs Logo");
		helper.getdata(expectedData, "validate.logo.txt");
		
	}
	public void validateproductsnapshot() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Product Snapshot");
		helper.getdata(expectedData, "validated.productsnapshotbar.txt");
		
	}
	public void validateListOfProducts() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Number of products");
		helper.getdata(expectedData, "validate.product.txt");
		
	}
	public void validateDashboard() throws Exception {
		String data=readingdata.getData(3, 1, 1);
		System.out.println(data);
	    helper.getdata(data, "loc.product.btn");	
	}
	
	public void validateRecentExecutionTime() throws Exception {
		Pageactions page = new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData= page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Recent Execution time");
		helper.getdata(expectedData, "loc.executiontime.txt");
		
	}

}