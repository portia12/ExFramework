package com.extron.gve.framwork.pageObjects.reporting;

package com.extron.gve.framework.pageobjects.reporting;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class ReportingPageObject extends BasePageObject {

	@Autowired
	public ReportingPageObject(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		// TODO Auto-generated method stub

	}
}

