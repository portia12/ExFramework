package com.extron.gve.framwork.pageObjects.monitoring;

package com.extron.gve.framework.pageobjects.monitoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.elements.CheckBox;
import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class MonitoringPageObject extends BasePageObject {

	@FindBy(css = "#RadWindowWrapper_UserListDialog > table > tbody > tr.rwContentRow > td.rwWindowContent.rwExternalContent > iframe")
	private WebElement addMonitorFrame;
	
	@FindBy(css = "#RadGrid1_ctl00_ctl02_ctl00_addRecordPanel > a")
	private WebElement btnAddNewMonitor;
	
	@FindBy(id = "butAddNotification")
	private WebElement btnAddNotification;
	
	@FindBy(id = "btnCancel")
	private WebElement btnCancel;
	
	@FindBy(id = "butUpdate")
	private WebElement btnCreate;
	
	@FindBy(id = "buttonNext")
	private WebElement btnNext;
	
	@FindBy(className = "rtChk")
	private CheckBox cboxRootLocation;
	
	@FindBy(id = "lblErr")
	private WebElement lblErrorMessage;
	
	@FindBy(className = "rtsTxt")
	private WebElement lblManageMonitors;
	
	@FindBy(id = "lblMonitorInfo")
	private WebElement lblMonitorInfo;
	
	@FindBy(id = "RadGrid1_ct100_ct104_lblMonitorName")
	private WebElement lblMonitorName;
	
	@FindBy(id = "lstMonitorNotifications_ctl00_ctl04_lblTo")
	private WebElement lblNotificationReceiver;
	
	@FindBy(id = "ValidationSummary2")
	private WebElement lblValidationErrorMessage;
	
	@FindBy(css = "#ContentPlaceHolder1_pgViewNewEdit > iframe")
	private WebElement manageMonitorFrame;
	
	@FindBy(id = "drpConditions")
	private WebElement selectComparisonType;
	
	@FindBy(id = "drpDeviceTypes")
	private WebElement selectDeviceType;
	
	@FindBy(id = "lstEmailTemplates")
	private WebElement selectEmailTemplate;
	
	@FindBy(id = "drpMonitorTypes")
	private WebElement selectMonitorType;
	
	@FindBy(id = "lstToFields")
	private WebElement selectToFields;
	
	@FindBy(id = "lstUsers")
	private WebElement selectUsers;
	
	@FindBy(id = "txtName")
	private WebElement txtMonitorName;
	
	@FindBy(id = "txtDescription")
	private WebElement txtMonitorDescription;

	@FindBy(id = "txtThresholdValue")
	private WebElement txtThresholdValue;
	
	@Autowired
	public MonitoringPageObject(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks the Root Location checkbox if it's unchecked
	 */
	public void checkRootLocation ()
	{
		try
		{
			Thread.sleep(250);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		cboxRootLocation.check();
	}
	
	/**
	 * Clicks the 'Add New Monitor' link
	 */
	public void clickAddMonitorLink ()
	{
		btnAddNewMonitor.click();
	}
	
	/**
	 * Clicks the Add button for notifications
	 */
	public void clickAddNotificationButton ()
	{
		btnAddNotification.click();
	}
	
	/**
	 * Clicks the Cancel button
	 */
	public void clickCancelButton ()
	{
		btnCancel.click();
	}
	
	/**
	 * Clicks the Create button to create monitor
	 */
	public void clickCreateButton ()
	{
		btnCreate.click();
	}
	
	/**
	 * Clicks the Next button
	 */
	public void clickNextButton ()
	{
		try
		{
			Thread.sleep(250);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		btnNext.click();
	}
	
	/**
	 * Enter the description of the monitor in the text box
	 * @param monitorDescription
	 */
	public void enterMonitorDescription (String monitorDescription)
	{
		enterText(txtMonitorDescription, monitorDescription);
	}
	
	/**
	 * Enter the name of monitor in the text box
	 * @param monitorName
	 */
	public void enterMonitorName (String monitorName)
	{
		enterText(txtMonitorName, monitorName);
	}
	
	/**
	 * Enter the threshold value in minutes
	 * @param minutes
	 */
	public void enterThresholdValue (String minutes)
	{
		enterText(txtThresholdValue, minutes);
	}
	
	/**
	 * Getter for the Add Monitor form iframe
	 * @return
	 */
	public WebElement getAddMonitorFrame ()
	{
		return addMonitorFrame;
	}
	
	/**
	 * Getter for the Create monitor button
	 * @return the WebElement btnCreate
	 */
	public WebElement getBtnCreate() {
		return btnCreate;
	}
	
	/**
	 * Getter for error message, or successful message when required
	 * @return the WebElement object of the error message label
	 */
	public WebElement getLblErrorMessage ()
	{
		return lblErrorMessage;
	}
	
	/**
	 * Return the Message of whether monitor was created successfully or not
	 * @return the text of the label
	 */
	public String getLblErrorMessageText ()
	{
		return lblErrorMessage.getText();
	}
	
	/**
	 * Return the name of the user in 'To' field in the Selected notifications
	 * block
	 * @return username of the receiver of the notification
	 */
	public String getLblNotificationReceiverText ()
	{
		return lblNotificationReceiver.getText();
	}
	
	/**
	 * Getter the Validation Error message WebElement
	 * @return WebElement
	 */
	public WebElement getLblValidationErrorMessage ()
	{
		return lblValidationErrorMessage;
	}
	
	/**
	 * Getter for the manage monitor iframe
	 * @return WebElement of the iframe
	 */
	public WebElement getManagerMonitorFrame ()
	{
		return manageMonitorFrame;
	}
	
	/**
	 * Return the Monitor Information from the summary page
	 * @return monitor info
	 */
	public String getMonitorInfo ()
	{
		return lblMonitorInfo.getText();
	}
	
	/**
	 * Getter for drop down to select comparison type
	 * @return the WebElement selectComparisonType
	 */
	public WebElement getSelectComparisonType() {
		return selectComparisonType;
	}
	
	/**
	 * Getter for drop down to select device type
	 * @return the WebElement selectDeviceType
	 */
	public WebElement getSelectDeviceType() {
		return selectDeviceType;
	}

	/**
	 * Getter for dropdown box to select Email Template
	 * @return the WebElement selectEmailTemplate
	 */
	public WebElement getSelectEmailTemplate() {
		return selectEmailTemplate;
	}
	
	/**
	 * Getter for drop down to select monitor type
	 * @return the WebElement selectMonitorType
	 */
	public WebElement getSelectMonitorType() {
		return selectMonitorType;
	}

	/**
	 * Getter for multi-select window to select users for notification
	 * @return the WebElement selectUsers
	 */
	public WebElement getSelectUsers() {
		return selectUsers;
	}

	/**
	 * Getter for Monitor Name textbox WebElement
	 * @return WebElement
	 */
	public WebElement getTxtMonitorName() {
		return txtMonitorName;
	}

	/**
	 * Getter for textbox to enter Threshold Value
	 * @return the WebElement
	 */
	public WebElement getTxtThresholdValue() {
		return txtThresholdValue;
	}

	/**
	 * Select from drop down the Comparison Type specified
	 * @param compareType The comparison type selected
	 */
	public void selectComparisonType (String compareType)
	{
		Select select = new Select(selectComparisonType);
		select.selectByVisibleText(compareType);
	}

	/**
	 * Select from drop down the Device Type specified
	 * @param deviceType The device type text used in selection
	 */
	public void selectDropdownDeviceType (String deviceType)
	{
		Select select = new Select(selectDeviceType);
		select.selectByVisibleText(deviceType);
	}

	/**
	 * Select from drop down the email template for notification
	 * @param emailTemplate
	 */
	public void selectEmailTemplate (String emailTemplate)
	{
		Select select = new Select(selectEmailTemplate);
		select.selectByVisibleText(emailTemplate);
	}
	
	/**
	 * Select from drop down the Monitor Type specified
	 * @param monitorType The monitor type text used in selection
	 */
	public void selectMonitorType (String monitorType)
	{
		Select select = new Select(selectMonitorType);
		select.selectByVisibleText(monitorType);
	}
	
	/**
	 * Select from drop down whom to send the notification.
	 * Can be one of two options: Distribution List, and Users
	 * @param toField
	 */
	public void selectToField (String toField)
	{
		Select select = new Select(selectToFields);
		select.selectByVisibleText(toField);
	}
	
	/**
	 * Select one or more users for notification
	 * @param userName
	 */
	public void selectUsersToNotify (String userName)
	{
		Select select = new Select(selectUsers);
		select.selectByVisibleText(userName);
	}
	
	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(lblManageMonitors);

	}
}

