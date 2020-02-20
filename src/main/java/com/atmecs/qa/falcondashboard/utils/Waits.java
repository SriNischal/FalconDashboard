package com.atmecs.qa.falcondashboard.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class Waits {
	Browser browser=null;
	public Waits(Browser browser) {
		this.browser=browser;
	}
	public void implicitWait(){
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	public void safeWait() {
		browser.getWait().safeWait(2000);
	}
	public void pageLoadTimeout() {
		WebDriverWait wait=new WebDriverWait(browser.getDriver(), 20);
		System.out.println("Waiting time is: "+wait);
	}
}
