package com.atmecs.qa.falcondashboard.helper;

import java.io.IOException;

import org.testng.Assert;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;


public class ValidationHelper {
	Browser browser=null;
	
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	
	public ValidationHelper(Browser browser) {
		this.browser = browser;
	}
	
	@SuppressWarnings("static-access")
	public void getdata(String expectedString,String validationMessage) throws Exception
	{
		Pageactions page=new Pageactions(browser);
		String actualproduct;
        actualproduct=page.getText(read.getPropertyvalue(validationMessage,ProjectBaseConstantPaths.LOCATORS_FILE));
		Assert.assertEquals(actualproduct, expectedString);
		log.info("Successfully validated " + expectedString);
		System.out.println(actualproduct);
		System.out.println(expectedString);
	}
	
	@SuppressWarnings("static-access")
	public String getData() throws Exception {
		Pageactions page = new Pageactions(browser);
		String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		System.out.println("productname: "+product);
		return product;
	}
}
