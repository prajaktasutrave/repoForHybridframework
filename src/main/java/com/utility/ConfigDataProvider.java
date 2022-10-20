package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;

	// here we load config.propertiesfile which we have created inside config folder
	// under project
	public ConfigDataProvider() throws Exception {

		String configfile_path = "D:\\eclipse workspace\\hybridframework\\Config\\config.Properties";
		FileInputStream file = new FileInputStream(configfile_path);
		pro = new Properties();
		pro.load(file);

	}

	public String getBaseURL() {
		return pro.getProperty("BaseURL");
	}
}
