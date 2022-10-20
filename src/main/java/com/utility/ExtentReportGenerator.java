package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {

	// here we use 3 classes
	// 1.ExtentSparkReporter......to do decorative part like give report title, give
	// report name,set theme etc
	// 2.ExtendReports.......to set environmental setup like QA name,Os
	// name,automation Tool name etc
	// 3.ExtentTest..........to provide log of execution of test class

	public static ExtentReports extReports;

	public static ExtentReports getReports() {
		String pathreport = "D:\\eclipse workspace\\hybridframework\\Reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(pathreport);
		reporter.config().setDocumentTitle("Automation test report");
		reporter.config().setReportName("first report");
		reporter.config().setTheme(Theme.DARK);

		extReports = new ExtentReports();
		extReports.attachReporter(reporter);
		extReports.setSystemInfo("Automation tool", "Selenium");
		extReports.setSystemInfo("O.S", "Windows");
		extReports.setSystemInfo("QA", "Prajakta");
		return extReports;

	}

}
