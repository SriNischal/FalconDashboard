package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

public class TC39_DeleltingProduct extends TestSuiteBase {
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String values;
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	int index;
	int i;

	@SuppressWarnings("deprecation")
	@Test
	public void productDeletion() throws Exception {
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
		log.info("STEP#1: Clicking on the recent runs");
		page.clickOnElement(
				ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs option");
		Waits.isElementVisible(browser.getDriver(), "loc.nextoption.btn");
		log.info("STEP#2: Clicking on the last page");
		String locator = ReadLocators.getPropertyvalue("loc.nextoption.btn",ProjectBaseConstantPaths.LOCATORS_FILE);
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(locator);
		int length=list.size();
		for (int i = length; i > 1; i--) {
			String numbers = Integer.toString(i);
			String locatorvalue = ReadLocators.getPropertyvalue("loc.next.btn",ProjectBaseConstantPaths.LOCATORS_FILE);
			String values = locatorvalue.replace("*", numbers);
			page.clickOnElement(values);
		    Waits.isElementVisible(browser.getDriver(), "loc.trashbox.btn");
		log.info("STEP#3: Creating the list to display the components of the products");
		   String trashlocator = ReadLocators.getPropertyvalue("loc.trash.btn",ProjectBaseConstantPaths.LOCATORS_FILE);
		   List<WebElement> lists = browser.getFindFromBrowser().findElementsByXpath(trashlocator);
		   int trashlength=lists.size();
		   for (int index = trashlength;index >= 1; index--) {
			String number = Integer.toString(index);
			String locatorvalues = ReadLocators.getPropertyvalue("loc.trashbox.btn",ProjectBaseConstantPaths.LOCATORS_FILE);
			String value = locatorvalues.replace("*", number);
			page.clickOnElement(value);
			report.info("Successfully deleted the last item in the list");
			Waits.isElementVisible(browser.getDriver(), "loc.confirm.btn");
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.confirm.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
			Waits.isElementVisible(browser.getDriver(), "loc.next.btn");
			page.clickOnElement(values);
			report.info("Successfully clicked on the last page of the recent runs");
		}
	}
}
}