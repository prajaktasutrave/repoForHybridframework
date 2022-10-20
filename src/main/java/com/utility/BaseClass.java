package com.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExcelDataReader excel;
	public static ConfigDataProvider config;

	@BeforeSuite
	public void BS_initialization() throws Exception {

		excel = new ExcelDataReader();
		config = new ConfigDataProvider();

	}

	@Parameters({ "BrowserName" })
	@BeforeMethod

	public static void broswerOpen(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.get(config.getBaseURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public static void browserClose() {

		driver.quit();

	}

}
