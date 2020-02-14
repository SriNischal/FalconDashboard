package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Splitting;
//In this class download option is verified
public class TC11_DownloadOption extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	//In this method the download message is validated by mouse hovering and the checked if download option is clicked
	@SuppressWarnings("static-access")
	@Test
	public void downloadOption() throws Exception {
		Splitting split=new Splitting(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Clicking on the download option");
		page.clickOnElement(read.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");	
	log.info("STEP#3: Displaying the Download message for the products");	
	    String actualtooltipmessage=propReader.getValue("loc.downloadmessage.txt");
	    String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	   String productname=split.splitofarray(0).trim();
	    String expectedtooltipmessage=page.getdata_fromExcel(productname, "Validation Text", "Download Message");
	    Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	    System.out.println(expectedtooltipmessage);
	    report.info("Sucessfully validated the tooltip message");
	}

}
