package com.extron.gve.framwork.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPageObject extends BasePageObject {

	@Autowired
	private HomePageObject homePageObject;

	@FindBy(id = "UserName")
	private WebElement userNameTextBox;

	@FindBy(id = "Password")
	private WebElement passwordTextBox;

	@FindBy(id = "LoginButton")
	private WebElement loginButton;

	@FindBy(id = "chkRememberMe")
	private WebElement rememberMeCheckInBox;

	@FindBy(id = "Forgot Password?")
	private WebElement forgotPasswordLink;

	@FindBy(id = "version")
	private WebElement versionNumber;

	@FindBy(id = "about")
	private WebElement aboutGve;

	@FindBy(id = "website")
	private WebElement extronWebSite;

	@FindBy(id = "ErrorMessages")
	private WebElement errorMessageLabel;
	
	@FindBy(id = "UserNameError")
	private WebElement lblUsernameErrorMessage;
	
	@FindBy(id = "PasswordError")
	private WebElement lblPasswordErrorMessage;
	
	@FindBy(xpath = "/html/body/span/h1")
	private WebElement dangerMessage;

	@Autowired
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method is to click on the Login Button
	 */
	public HomePageObject clickLoginButton() {
		loginButton.click();
		return homePageObject;
	}

	/**
	 * This method is to enter password in the Password Text Box
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		enterText(passwordTextBox, password);
	}

	/**
	 * This method is to enter user name in the User Name Text Box
	 * 
	 * @param userName
	 */
	public void enterUserName(String userName) {
		enterText(userNameTextBox, userName);
	}
	
	/**
	 * Returns the text of the title of the page when a warning is generated
	 * @return text of the dangerMessage WebElement
	 */
	public String getDangerMessageText ()
	{
		return dangerMessage.getText();
	}

	/**
	 * This method returns the error message text displayed when there is an issue
	 * logging in
	 * 
	 * @return String representing error message displayed on login page.
	 */
	public String getErrorMessageText() {
		if (errorMessageLabel.getText() == null) {
			return "";
		}
		return errorMessageLabel.getText();
	}
	
	/**
	 * This method returns the error message text displayed when there is no password
	 * entered
	 * @return String representing error message displayed on login page.
	 */
	public String getPasswordErrorMessageText() {
		if (lblPasswordErrorMessage.getText() == null) {
			return "";
		}
		return lblPasswordErrorMessage.getText();
	}
	
	/**
	 * This method returns the error message text displayed when there is no username
	 * entered
	 * @return String representing error message displayed on login page.
	 */
	public String getUsernameErrorMessageText() {
		if (lblUsernameErrorMessage.getText() == null) {
			return "";
		}
		return lblUsernameErrorMessage.getText();
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(loginButton, 30);
	}
}

