package com.atmecs.qa.falcondashboard.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class LoadProperties {
	private static final ReportLogService report = new ReportLogServiceImpl(LoadProperties.class);

	public static  String readConfig(String elements, String configFile) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(ProjectBaseConstantPaths.CONFIG_FILE);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;

	}

}
