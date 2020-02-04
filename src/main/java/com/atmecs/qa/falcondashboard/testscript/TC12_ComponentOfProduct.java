package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.enums.LocatorType;
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

public class TC12_ComponentOfProduct extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	@Test
	public void componentOfProduct() throws Exception {
		RecentrunsValidation validate = new RecentrunsValidation(browser);
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: Creating the list to display the components of the products ");
	    String componentslist=propReader.getValue("loc.componentofproduct.btn"); 
		List<WebElement> component = browser.getFindFromBrowser().findElementsByXpath(componentslist);
		log.dateinfo(component.size());
		List<String> componenttexts = component.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(componenttexts);
	log.info("STEP#2: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getWait().safeWait(2000);
	log.info("STEP#3: Splitting the array");
		String product = propReader.getValue("loc.product.txt");
		String value = browser.getTextField().readTextByXPath(LocatorType.XPATH, product);
		String[] arrOfStr = value.split(":", 3);
		System.out.println(arrOfStr[1]);
		report.info("Successfully displayed component of product");
	log.info("STEP#4: Clicking on the recent runs option");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		browser.getWait().safeWait(2000);
	log.info("STEP#5: Validating the title of the recent runs page");
		validate.validateText();
		report.info("Successfully validated recent runs");
	log.info("STEP#6: Creating the list to display the components of the products");
	    String components=propReader.getValue("loc.componentlist.txt"); 
		List<WebElement> componentlist = browser.getFindFromBrowser().findElementsByXpath(components);
		log.dateinfo(componentlist.size());
		List<String> componenttext = componentlist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(componenttext);
	log.info("STEP#7: Clicking on the component for sorting the data");
		page.clickOnElement(read.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
	log.info("STEP#8: Validating the component of the product");
		validate.validateComponent();
		report.info("Successfully validated component text");
	log.info("STEP#9: Clicking on the component of the project for sorting the data ");
		page.clickOnElement(read.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
	log.info("STEP#10: Creating the list to display the component of the products");
		List<WebElement> componentlists = browser.getFindFromBrowser().findElementsByXpath(components);
		log.dateinfo(componentlists.size());
		List<String> componentstext = componentlists.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(componentstext);
	log.info("STEP#11: Comparing the lists to see whether both the list are same or  not");
		boolean compare = componenttext.equals(componentstext);
		System.out.println(compare);
	}

}
