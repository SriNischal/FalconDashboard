package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.springframework.data.domain.Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;

public class TC02_Products extends SampleTestSuiteBase {
	ReadLocators read=new ReadLocators();
	ReadingData data=new ReadingData();
	LoadProperties properties;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings("static-access")
	@Test
	public void numberrofproducts() throws Exception {
		Pageactions page=new Pageactions(browser);
		@SuppressWarnings("deprecation")
		List<WebElement> list = browser.getFindFromBrowser()
				.findElementsByXpath("//h4[@class='media-box-heading ng-binding']");
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
        //String locator=page.randomnumber("loc.product.btn");
		//page.clickOnElement(locator);
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
