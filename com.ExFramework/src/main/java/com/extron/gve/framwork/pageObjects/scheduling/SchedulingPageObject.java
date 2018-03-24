package com.extron.gve.framwork.pageObjects.scheduling;

Sheduling


package com.extron.gve.framework.pageobjects.scheduling;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class SchedulingPageObject extends BasePageObject {

	@Autowired
	public SchedulingPageObject(WebDriver driver) {
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

