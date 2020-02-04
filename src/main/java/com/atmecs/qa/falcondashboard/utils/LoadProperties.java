package com.atmecs.qa.falcondashboard.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class LoadProperties {
	public static  String readConfigfile(String elements, String configFile) throws IOException {
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


