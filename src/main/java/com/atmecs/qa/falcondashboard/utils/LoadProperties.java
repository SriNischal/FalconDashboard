package com.atmecs.qa.falcondashboard.utils;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class LoadProperties {
	private static final ReportLogService report = new ReportLogServiceImpl(LoadProperties.class);

	public static Properties loadProperty(String propertiesFilePath) {
		Properties properties = new Properties();
		PropertyParser propertyParser = new PropertyParser();

		try {
			properties = propertyParser.loadProperty(propertiesFilePath);
		} catch (IOException ioException) {
			report.error("IOException occured as " + ioException.getMessage());
			return null;
		}

		return properties;
	}

}
