package com.atmecs.qa.falcondashboard.utils;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testscript.SampleTestScript;

public class Splitting{
	ReadLocators read=new ReadLocators();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser=null;
	
	public Splitting(Browser browser) {
		this.browser=browser;
	}
	public String splitofarray(int i) throws Exception {
		Pageactions page=new Pageactions(browser);
		String value = page.getText(ReadLocators.getPropertyvalue("loc.product.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = value.split(":", 3);
		String date=arrOfStr[i];
		report.info("Successfully displayed day and date of product");
		return date;
	}
	public String splitofdatetime(int i) throws Exception {
		Pageactions page=new Pageactions(browser);
		String product = page.getText(ReadLocators.getPropertyvalue("loc.product.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String[] arrOfStr = product.split(":", 3);
		String date=arrOfStr[i];
		System.out.println(date);
		report.info("Successfully displayed day and date of product");
		 String s1[]=date.split("[ ]");
		 String result=s1[1] + s1[2] + s1[3];
		 System.out.println(result);
		return result;
		
	}
	
}
