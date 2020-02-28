package com.atmecs.qa.falcondashboard.utils;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class SeleniumGrid {
	private WebDriver driver;
	protected Browser browser;
	String BaseURL, NodeURL;
	LoadProperties load=new LoadProperties();
	
	@SuppressWarnings("static-access")
	@BeforeMethod
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void before(String os, String osVersion, String br, String browserVersion) throws Exception {
		browser=new Browser();
		BaseURL = "http://www.google.com";
		NodeURL = "http://localhost:4444/wd/hub";
		File file = new File(ProjectBaseConstantPaths.CHROME_FILE);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("chrome");
			System.out.println(capability.toString());
		driver = new RemoteWebDriver(new URL(NodeURL), capability);
		String url=load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
