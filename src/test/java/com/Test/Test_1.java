package com.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPom;
import com.utility.BaseClass;
import com.utility.Library;

public class Test_1 extends BaseClass {

	@Test
	public void verify_test1() throws InterruptedException {

		LoginPom login = PageFactory.initElements(driver, LoginPom.class);

		Library.custom_sendkeys(login.getTxt_username(), excel.getStringData("Sheet1", 0, 0), "email ID");
		Library.custom_sendkeys(login.getTxt_password(), excel.getNumericData("Sheet1", 0, 1), "password");
		Library.custom_click(login.getBtn_login(), "login button");
		Thread.sleep(2000);

		// verify title
		String expected = "Facebook";
		String actual = driver.getTitle();

		Assert.assertEquals(actual, expected);

	}

}
