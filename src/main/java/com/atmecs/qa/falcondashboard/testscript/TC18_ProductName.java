package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;
//In this  class the product name is validated
public class TC18_ProductName extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	//In this method the browser is invoked and url is opened
	@SuppressWarnings("static-access")
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	/*
	 * In this method the recent runs option is clicked and the list is created to
	 * display the product names and clicked on the product names to sort the values
	 * and created another list to display the sorted names and compared both the
	 * values to see that both the lists are different
	 */	
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void productName() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Validating the product names");
	    validate.validateProductName();
	    report.info("Successfully validated the product name");
	log.info("STEP#3: Creating a list to display the names of the product");
	    String productnames=propReader.getValue("loc.productnames.txt");
		List<WebElement> productnameslist = browser.getFindFromBrowser().findElementsByXpath(productnames);
		log.dateinfo(productnameslist.size());
		List<String> productnamestext = productnameslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(productnamestext);
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#5: Clicking on the product name");
	    page.clickOnElement(read.getPropertyvalue("loc.productnamestext.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Succesfully clicked on the product");
	log.info("STEP#6: Creating the list to display the product names after sorting");
	    String productnamesaftersorting=propReader.getValue("loc.productnames.txt");
	    List<WebElement> productnamelist = browser.getFindFromBrowser().findElementsByXpath(productnamesaftersorting);
	    log.dateinfo(productnamelist.size());
	    List<String> productnametext = productnamelist.stream().map(WebElement::getText).collect(Collectors.toList());
	    log.info(productnametext);
	log.info("STEP#7: Comparing the product names before and after sorting");
	    boolean compare=productnametext.equals(productnamestext);
	    System.out.println(compare);
	}

}