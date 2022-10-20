package com.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	ExtentReports extent = ExtentReportGenerator.getReports();

	public void onTestStart(ITestResult result) {

		ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
		Library.test = extent.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
		extentTest.set(Library.test);
	}

	public void onTestSuccess(ITestResult result) {
		Library.test.log(Status.PASS, "test case executed successfully");

	}

	public void onTestFailure(ITestResult result) {
		Library.test.log(Status.FAIL, "execution failed");
		Library.test.addScreenCaptureFromBase64String(getCapture());

	}

	public void onTestSkipped(ITestResult result) {
		Library.test.log(Status.SKIP, "test case skipped");

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	public static String getCapture() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}

}
