package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;
//In this classes the last runs in the recent runs page is clicked and validated 
public class TC35_LastRun extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	WebDriver driver; 
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the recent runs is clicked and validated that user landed on
	 * to the page and validated the last runs text and created a list to display
	 * the content in the last runs and validated the content and clicked on the
	 * text for sorting and created a list to display the sorted list and compared
	 * both the lists
	 */
	@SuppressWarnings("static-access")
	@Test
	public void lastRun() throws Exception {
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Validating the last run");
	    validate.validateLastRun();
	    report.info("Successfully validated the last run");
	log.info("STEP#3: Creating a list to display the last run of the product");
	    String lastruns=propReader.getValue("loc.lastrun.txt");
		list.listofElements(lastruns);
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#4 Clicking on the last run");
	    page.clickOnElement(read.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(read.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the last runs");
	    browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#5: Creating the list to display the last runs after sorting");
	    String lastrunsaftersorting=propReader.getValue("loc.lastrun.txt");
	   list.listofElements(lastrunsaftersorting);
	log.info("STEP#6: Comparing the last runs before and after sorting");
	    boolean compare=lastrunsaftersorting.equals(lastruns);
	    System.out.println(compare);
	}
}
