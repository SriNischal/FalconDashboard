package com.atmecs.qa.falcondashboard.utils;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;

public class SeleniumGrid extends SampleTestSuiteBase{
	@BeforeSuite
    private static DesiredCapabilities getBrowserCapabilities(String browsertype) {
   	 System.out.println("bnoeih");
   	 switch (browsertype) {

   	 case "WIN_10_firefox_0.26.0":
   	 DesiredCapabilities descapability = new DesiredCapabilities();
   	 descapability.setCapability(CapabilityType.BROWSER_NAME, "firefox");
   	 return descapability;

   	 case "WIN_10_chrome_77":
   		 System.out.println(browsertype);
   	 descapability = new DesiredCapabilities();
   	 descapability.setCapability(CapabilityType.BROWSER_NAME, "chrome");
   	 return descapability;
   	 default:
   	 descapability = new DesiredCapabilities();
   	 descapability.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
   	 return descapability;
   	 }
   	 }
   	 public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
   	 System.out.println("grid running");
   	 return new RemoteWebDriver(new URL("http://55.55.52.253:5555/wd/hub"), getBrowserCapabilities(browser));
   	 }
}