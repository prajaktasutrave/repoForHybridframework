package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {
	public static ExtentTest test;

	public static void custom_sendkeys(WebElement element, String value, String fieldname) {
		try {
			element.sendKeys(value);
			test.log(Status.PASS, value + " sent successfully to " + fieldname);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	public static void custom_click(WebElement element, String fieldname) {
		try {
			element.click();
			test.log(Status.PASS, "clicked successfull on " + fieldname);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	public static void scrolltoElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void dropdownHandle(WebElement element, String text) {
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void mousehoverAndClick(WebDriver driver, WebElement element) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).click().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
