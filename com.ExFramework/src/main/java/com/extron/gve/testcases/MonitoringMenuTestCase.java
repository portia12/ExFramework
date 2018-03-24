package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.monitoring.MonitoringPageObject;
import com.extron.gve.framework.publicobjects.TestUserFactory;
import com.extron.gve.properties.CommonStringProperties;
import com.extron.gve.properties.TestProperties;

public class MonitoringMenuTestCase extends BaseTestCase
{
	
	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private TestUserFactory testUserFactory;

	@Autowired
	private TestProperties testProperties;
	
	@Autowired
	private CommonStringProperties commonStringProperties;
	
	@Test(description = "Add a new Monitor")
	public void addMonitor () throws InterruptedException
	{
		MonitoringPageObject monitoringPageObject = homePageObject.clickMonitoringTab();
		
		monitoringPageObject.waitForPageToLoad();
		
		monitoringPageObject.switchToFrame(monitoringPageObject.getManagerMonitorFrame());
		monitoringPageObject.clickAddMonitorLink();
		monitoringPageObject.switchToFrame(monitoringPageObject.getAddMonitorFrame());
		
		Thread.sleep(500);
		monitoringPageObject.enterMonitorName(testProperties.monitorName);
		monitoringPageObject.enterMonitorDescription(testProperties.monitorDescription);
		monitoringPageObject.selectDropdownDeviceType(testProperties.deviceType);
		monitoringPageObject.waitUntilClickable(monitoringPageObject.getSelectMonitorType());
		monitoringPageObject.selectMonitorType(testProperties.monitorType);
		monitoringPageObject.waitUntilClickable(monitoringPageObject.getSelectComparisonType());
		monitoringPageObject.selectComparisonType(testProperties.comparisonType);
		monitoringPageObject.enterThresholdValue("5");
		monitoringPageObject.clickNextButton();
		
		monitoringPageObject.checkRootLocation();
		monitoringPageObject.clickNextButton();
		
		monitoringPageObject.clickNextButton();
		
		monitoringPageObject.waitUntilClickable(monitoringPageObject.getSelectEmailTemplate());
		monitoringPageObject.selectEmailTemplate(testProperties.tEmailTemplateName);
		monitoringPageObject.selectToField("Users");
		monitoringPageObject.waitUntilClickable(monitoringPageObject.getSelectUsers());
		monitoringPageObject.selectUsersToNotify("BJohana");
		monitoringPageObject.clickAddNotificationButton();
		
		Assert.assertTrue(monitoringPageObject.getLblNotificationReceiverText().contains("BJohana"), "Notification receiver incorrect. Expected 'BJohana' but found " + monitoringPageObject.getLblNotificationReceiverText());
		Assert.assertFalse(monitoringPageObject.isDisplayed(monitoringPageObject.getLblValidationErrorMessage()), "Notification Receiver not added");
		
		monitoringPageObject.clickNextButton();
		
		monitoringPageObject.getMonitorInfo();
		monitoringPageObject.waitUntilVisible(monitoringPageObject.getBtnCreate());
		monitoringPageObject.clickCreateButton();
		monitoringPageObject.waitUntilVisible(monitoringPageObject.getLblErrorMessage());
		Assert.assertTrue(monitoringPageObject.isDisplayed(monitoringPageObject.getLblErrorMessage()) && monitoringPageObject.getLblErrorMessageText().equals(commonStringProperties.addMonitorSuccess));
		
		monitoringPageObject.clickCancelButton();
		
		monitoringPageObject.switchToDefaultContent();
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

