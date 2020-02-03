package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
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
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC12_ComponentOfProduct extends SampleTestSuiteBase{
	ReadLocators read =new ReadLocators();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings({ "deprecation", "static-access" })
	@Test
	public void componentofproduct() throws Exception {
		RecentrunsValidation validate=new  RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		List<WebElement> list = browser.getFindFromBrowser()
				.findElementsByXpath("//a/div/small[@class='text-muted ng-binding']");
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getWait().safeWait(2000);
		String value=browser.getTextField().readTextByXPath(LocatorType.XPATH, "//h3[@class='ng-binding ng-scope']");
		 String[] arrOfStr = value.split(":", 3);
		 System.out.println(arrOfStr[1]);
		 report.info("Successfully displayed component of product");
		 page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		 report.info("Successfully clicked on recent runs");
		 browser.getWait().safeWait(2000);
		 validate.validatetext();
		 report.info("Successfully validated recent runs");
		 List<WebElement> componentlist = browser.getFindFromBrowser()
					.findElementsByXpath("//td[@data-title=\"'Component'\"]");
		log.dateinfo(componentlist.size());
		List<String> componenttext = componentlist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(componenttext);
		page.clickOnElement(read.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
		validate.validatecomponent();
		report.info("Successfully validated component text");
		page.clickOnElement(read.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
		List<WebElement> componentslist = browser.getFindFromBrowser()
		 			.findElementsByXpath("//td[@data-title=\"'Component'\"]");
		log.dateinfo(componentslist.size());
		List<String> componentstext = componentslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(componentstext);
		boolean compare=componenttext.equals(componentstext);
		System.out.println(compare);
	}

}
