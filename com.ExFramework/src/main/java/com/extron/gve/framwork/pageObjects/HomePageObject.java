package com.extron.gve.framwork.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.helpdesk.HelpDeskPageObject;
import com.extron.gve.framework.pageobjects.monitoring.MonitoringPageObject;
import com.extron.gve.framework.pageobjects.reporting.ReportingPageObject;
import com.extron.gve.framework.pageobjects.scheduling.SchedulingPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.SystemMenuPageObject;
import com.extron.gve.framework.pageobjects.userpreferences.UserPreferencesPageObject;

@Component
public class HomePageObject extends BasePageObject {
	
	@Autowired
	private HelpDeskPageObject helpDeskPageObject;

	@Autowired
	private SchedulingPageObject schedulingPageObject;

	@Autowired
	private MonitoringPageObject monitoringPageObject;

	@Autowired
	private ReportingPageObject reportingPageObject;

	@Autowired
	private SystemMenuPageObject systemMenuPageObject;

	@Autowired
	private UserPreferencesPageObject userPreferencesPageObject;

	@FindBy(linkText = "HELP DESK")
	private WebElement helpDeskTabLink;

	@FindBy(linkText = "SCHEDULING")
	private WebElement schedulingTabLink;

	@FindBy(linkText = "MONITORING")
	private WebElement monitoringTabLink;

	@FindBy(linkText = "REPORTING")
	private WebElement reportingTabLink;

	@FindBy(linkText = "SYSTEM MENU")
	private WebElement systemMenuLink;

	@FindBy(linkText = "USER PREFERENCES")
	private WebElement userPreferencesLink;

	@FindBy(id = "LogInOut")
	private WebElement logOutButton;

	@Autowired
	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the Help Desk tab
	 * 
	 * @return The HelpDeskPageObject
	 */
	public HelpDeskPageObject clickHelpDeskTab() {
		helpDeskTabLink.click();
		return helpDeskPageObject;
	}

	/**
	 * Logs out of GVE
	 */
	public void clickLogoutButton() {
		logOutButton.click();
	}

	/**
	 * Clicks the Monitoring tab
	 * 
	 * @return The MonitoringPageObject
	 */
	public MonitoringPageObject clickMonitoringTab() {
		monitoringTabLink.click();
		return monitoringPageObject;
	}

	/**
	 * Clicks the Reporting tab
	 * 
	 * @return The ReportingPageObject
	 */
	public ReportingPageObject clickReportingTab() {
		reportingTabLink.click();
		return reportingPageObject;
	}

	/**
	 * Clicks the Scheduling tab
	 * 
	 * @return The SchedulingPageObject
	 */
	public SchedulingPageObject clickSchedulingTab() {
		schedulingTabLink.click();
		return schedulingPageObject;
	}

	/**
	 * Clicks the System Menu tab
	 * 
	 * @return The SystemMenuPageObject
	 */
	public SystemMenuPageObject clickSystemMenuTab() {
		systemMenuLink.click();
		return systemMenuPageObject;
	}

	/**
	 * Clicks the User Preferences Tab
	 * 
	 * @return The UserPreferencesPageObject
	 */
	public UserPreferencesPageObject clickUserPreferencesTab() {
		userPreferencesLink.click();
		return userPreferencesPageObject;
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(helpDeskTabLink);
	}
}

