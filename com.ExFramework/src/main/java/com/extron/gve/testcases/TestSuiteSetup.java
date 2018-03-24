package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterSuite;

import com.extron.gve.framework.pageobjects.HomePageObject;

public class TestSuiteSetup {
	@Autowired
	HomePageObject homePageObject;

	@AfterSuite
	public void tearDown() {
		homePageObject.closeBrowser();
	}
}

