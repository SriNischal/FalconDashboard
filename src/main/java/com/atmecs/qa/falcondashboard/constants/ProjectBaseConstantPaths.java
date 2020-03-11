package com.atmecs.qa.falcondashboard.constants;

import java.io.File;

public class ProjectBaseConstantPaths {

	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String CHROME_FILE = USER_HOME + "lib" + File.separator + "chromedriver.exe";
	
	public final static String IE_FILE = USER_HOME + "lib" + File.separator + "IEDriverServer.exe";

	public final static String FIREFOX_FILE = USER_HOME + "lib" + File.separator + "geckodriver.exe";
	
	public final static String CONFIG_FILE = USER_HOME + "src/main/resources" + File.separator + "config.properties";

	public final static String LOCATORS_FILE = USER_HOME + "src/main/resources" + File.separator + "locators"
			+ File.separator + "falcondashboard.properties";

	public final static String LOG$J_FILE = USER_HOME + "src/test/resources" + File.separator + "log4j.properties";
	
	public final static String EXCEL_FILE=USER_HOME+"src/main/resources" +File.separator + "testdata" +File.separator+ "falcondashboard.xlsx";
	
	public static final String EXTENT_REPORTFILE =  USER_HOME + "ExtentReport.html";
	
	public static final String EXTENT_CONFIGFILE =  USER_HOME + "extent-config.xml";

}
