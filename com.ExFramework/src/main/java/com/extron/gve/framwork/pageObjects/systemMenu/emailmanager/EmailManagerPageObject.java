package com.extron.gve.framwork.pageObjects.systemMenu.emailmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class EmailManagerPageObject extends BasePageObject {

	@Autowired
	private EmailSettingsPageObject emailSettingsPageObject;

	@Autowired
	private EmailTemplateManagerPageObject emailTemplateManagerPageObject;

	@FindBy(linkText = "Email Settings")
	private WebElement emailSettingsTab;
	
	@FindBy(linkText = "Email Template Manager")
	private WebElement emailTemplateManagerTab;

	@Autowired
	public EmailManagerPageObject(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Clicks the Email Settings Tab
	 * 
	 * @return the EmailSettingsPageObject
	 */
	public EmailSettingsPageObject clickEmailSettingsTab() {
		emailSettingsTab.click();
		return emailSettingsPageObject;
	}
	
	/**
	 * Clicks the Email Template Manager Tab
	 * 
	 * @return the EmailTemplateManagerPageObject
	 */
	public EmailTemplateManagerPageObject clickEmailTemplateManagerTab ()
	{
		emailTemplateManagerTab.click();
		return emailTemplateManagerPageObject;
	}
	
	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(emailSettingsTab);
	}
}

