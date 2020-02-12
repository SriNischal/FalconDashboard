package com.atmecs.qa.falcondashboard.validationresults;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadExcelFile;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class ProductPageValidation {
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ReadExcelFile readData=new ReadExcelFile(ProjectBaseConstantPaths.EXCEL_FILE);
	ValidationHelper helper = new ValidationHelper(browser);
	public ProductPageValidation(Browser browser) {
		this.browser = browser;
	}
	
	
	/*
	 * @SuppressWarnings("deprecation") public String listofProducts() throws
	 * Exception{ Pageactions page=new Pageactions(browser); log.
	 * info("STEP#1: List to get all the products and size of elements  present on the dashboard page"
	 * ); String products=propReader.getValue("loc.products.txt"); List<WebElement>
	 * list = browser.getFindFromBrowser().findElementsByXpath(products);
	 * log.dateinfo(list.size()); List<String> texts =
	 * list.stream().map(WebElement::getText).collect(Collectors.toList());
	 * log.info(texts);
	 * log.info("STEP#2: Converting the list of products into string products");
	 * String separate = ","; StringBuilder sb = new StringBuilder(); int index = 0;
	 * while (index < list.size() - 1) { sb.append(list.get(index));
	 * sb.append(separate); index++; } sb.append(list.get(index)); String
	 * result=sb.toString(); System.out.println(result); //String
	 * data=page.getdata_fromExcel("Products", "ProductName",result );
	 * //System.out.println(data); return products;
	 * 
	 * }
	 */
	
	public void validateProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Product");
		helper.getdata(expectedData, "validate.product.txt");
	}
	public void validatePanelTitle() throws Exception {
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
		ValidationHelper helper = new ValidationHelper(browser);
		String expectedData=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Test Phase");
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