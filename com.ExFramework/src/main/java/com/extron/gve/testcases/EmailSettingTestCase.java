package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.systemmenu.SystemMenuPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.emailmanager.EmailManagerPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.emailmanager.EmailSettingsPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.emailmanager.EmailTemplateManagerPageObject;
import com.extron.gve.properties.CommonStringProperties;
import com.extron.gve.properties.TestProperties;

public class EmailSettingsTestCase extends BaseTestCase {

	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private TestProperties testProperties;

	@Autowired
	private CommonStringProperties commonStringProperties;

	/**
	 * Adds the email settings in the email manager on the system menu tab and
	 * ensures the save message shows up correctly.
	 */
	@Test(description = "Add Email Settings")
	public void addEmailSettings() {
		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();
		systemMenuPageObject.waitForPageToLoad();
		EmailManagerPageObject emailManagerPageObject = systemMenuPageObject.clickEmailManagerButton();
		emailManagerPageObject.waitForPageToLoad();
		EmailSettingsPageObject emailSettingsPageObject = emailManagerPageObject.clickEmailSettingsTab();
		emailSettingsPageObject.enterFromEmailAddress(testProperties.tEmailSettingsSrcEmailAddress);
		emailSettingsPageObject.enterEmailServer(testProperties.tEmailSettingsEmailServer);
		emailSettingsPageObject.enterSMTPUserName(testProperties.tEmailSettingsSmtpUsername);
		emailSettingsPageObject.enterSMTPPassword(testProperties.tEmailSettingsSmtpPassword);
		emailSettingsPageObject.clickSaveButton();

		String saveMessageText = emailSettingsPageObject.getSaveMessageText();

		Assert.assertTrue(saveMessageText.contains(commonStringProperties.successfullySavedMessage),
				"Save message did not display as expected. Expected: \""
						+ commonStringProperties.successfullySavedMessage + "\". Actual: " + saveMessageText);
	}

	/**
	 * Creates a new email template and checks if it has been added
	 * by verifying the name of the template from the displayed list
	 * @throws InterruptedException
	 */
	@Test(description = "Create Email Template")
	public void createEmailTemplate () throws InterruptedException
	{
		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();
		systemMenuPageObject.waitForPageToLoad();
		EmailManagerPageObject emailManagerPageObject = systemMenuPageObject.clickEmailManagerButton();
		emailManagerPageObject.waitForPageToLoad();
		EmailTemplateManagerPageObject emailTemplateManagerPageObject = emailManagerPageObject.clickEmailTemplateManagerTab();
		emailTemplateManagerPageObject.clickCreateEmailTemplateLink();
		emailTemplateManagerPageObject.switchToFrame(emailTemplateManagerPageObject.getCreateTemplateFrame());
		Thread.sleep(1000);
		
		emailTemplateManagerPageObject.waitUntilVisible(emailTemplateManagerPageObject.getTxtEmailTemplateName());
		emailTemplateManagerPageObject.enterTemplateName(testProperties.tEmailTemplateName);
		emailTemplateManagerPageObject.enterTemplateDescription(testProperties.tEmailTemplateDescription);
		emailTemplateManagerPageObject.enterTemplateSubject(testProperties.tEmailTemplateSubject);
		emailTemplateManagerPageObject.enterTemplateBody(testProperties.tEmailTemplateBody);
		
		emailTemplateManagerPageObject.clickCreateTemplateButton();
		emailTemplateManagerPageObject.switchToDefaultContent();
		emailManagerPageObject.waitForPageToLoad();
		
		Assert.assertEquals(emailTemplateManagerPageObject.getSearchResultText(), "Controller offline");
	}

	@BeforeMethod
	@Override
	public void login() {
		super.login();
	}
	
	@AfterMethod
	@Override
	public void logout() {
		super.logout();
	}
	
}

