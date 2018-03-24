package com.extron.gve.framwork.pageObjects.helpdesk;

package com.extron.gve.framework.pageobjects.helpdesk;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class HelpDeskPageObject extends BasePageObject {

	@Autowired
	public HelpDeskPageObject(WebDriver driver) {
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
