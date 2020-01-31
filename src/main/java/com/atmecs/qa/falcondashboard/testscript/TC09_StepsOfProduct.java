package com.atmecs.qa.falcondashboard.testscript;

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
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.ProductStepsValidation;

public class TC09_StepsOfProduct extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void stepsofproduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		ProductStepsValidation validate=new ProductStepsValidation(browser);
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.passselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected pass option");
		List<WebElement> list = browser.getFindFromBrowser()
				.findElementsByXpath("//td[@class='ng-binding']");
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
		List<WebElement> statuslist = browser.getFindFromBrowser()
				.findElementsByXpath("//span[@class='label-pass ng-scope']");
		log.dateinfo(statuslist.size());
		List<String> statustexts = statuslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(statustexts);
		page.clickOnElement(read.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the testcase");
		browser.getWait().safeWait(2000);
		validate.validateStatusoption();
		report.info("Successfully validated Status option");
		validate.validateDetailsoption();
		report.info("Successfully validated Details option");
		validate.validateTestcase();
		report.info("Successfully validated the test case");
		validate.validateRequestBody();
		report.info("Successfully validated Request Body");
		
		
	}

}