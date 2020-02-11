package com.atmecs.qa.falcondashboard.helper;

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
        System.out.println(actualproduct);
		Assert.assertEquals(actualproduct, expectedString);
		log.info("Successfully validated " + expectedString);
		System.out.println(actualproduct);
		System.out.println(expectedString);
	}
}
