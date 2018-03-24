package com.extron.gve.framwork.pageObjects.systemMenu.emailmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class EmailSettingsPageObject extends BasePageObject {

	@FindBy(id = "ContentPlaceHolder1_txtSenderMail")
	private WebElement fromEmailAddress;

	@FindBy(id = "ContentPlaceHolder1_txtSmtpServer")
	private WebElement emailServer;

	@FindBy(id = "ContentPlaceHolder1_txtSmtpUser")
	private WebElement smtpUserName;

	@FindBy(id = "ContentPlaceHolder1_txtSmtpPassword")
	private WebElement smtpPassword;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	private WebElement saveButton;

	@FindBy(id = "ContentPlaceHolder1_lblSaveMsg")
	private WebElement saveMessage;

	@Autowired
	public EmailSettingsPageObject(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the Save Button.
	 */
	public void clickSaveButton() {
		saveButton.click();
	}

	/**
	 * Fills out the Email Server field.
	 */
	public void enterEmailServer(String emailServerIp) {
		enterText(emailServer, emailServerIp);
	}

	/**
	 * Fills out the From Email Address field.
	 */
	public void enterFromEmailAddress(String srcEmailAddress) {
		enterText(fromEmailAddress, srcEmailAddress);
	}

	/**
	 * Fills out the SMTP Password field.
	 */
	public void enterSMTPPassword(String password) {
		enterText(smtpPassword, password);
	}

	/**
	 * Fills out the SMTP UserName field.
	 */
	public void enterSMTPUserName(String userName) {
		enterText(smtpUserName, userName);
	}

	/**
	 * Gets the save message text.
	 * 
	 * @return String containing text of save message element.
	 */
	public String getSaveMessageText() {
		if (saveMessage.getText() != null) {
			return saveMessage.getText();
		}
		return "";
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(saveButton);
	}
}

