package com.extron.gve.framwork.pageObjects.systemMenu.userManager;

package com.extron.gve.framework.pageobjects.systemmenu.usermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.elements.CheckBox;
import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class UserManagerPageObject extends BasePageObject {

	@FindBy(linkText = "Add New User")
	private WebElement addNewUser;

	@FindBy(id = "allowCpwd")
	private CheckBox allowPasswordChangeCheckbox;

	@FindBy(id = "btnCancel")
	private WebElement btnCloseNewUserForm;

	@FindBy(id = "ContentPlaceHolder1_btnSearchUser")
	private WebElement btnSearchUser;

	@FindBy(id = "Button1")
	private WebElement createButton;

	@FindBy(xpath = ".//*[@id=\"RadWindowWrapper_ctl00_ContentPlaceHolder1_Radwindow1\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/em")
	private WebElement dangerMessage;

	@FindBy(xpath = "/html/body/form/div[1]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")
	private WebElement frameClose;

	@FindBy(id = "validEmail")
	private WebElement lblEmptyEmail;

	@FindBy(id = "RequiredFieldValidator2")
	private WebElement lblEmptyUserGroup;

	@FindBy(id = "RequiredFieldValidator1")
	private WebElement lblEmptyUsername;

	@FindBy(id = "Validator6")
	private WebElement lblInvalidUsernameMessage;

	@FindBy(id = "reqAuthEmail")
	private WebElement lblValidEmailFormat;

	@FindBy(id = "ContentPlaceHolder1_btnAll")
	private WebElement listAllUsersButton;

	@FindBy(name = "Radwindow1")
	private WebElement newUserFrame;

	@FindBy(xpath = "/html/body/form/div[6]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]")
	private WebElement searchResult;

	@FindBy(id = "dropGroup")
	private WebElement selectUserGroup;

	@FindBy(id = "EmailSetAcct")
	private CheckBox sendConfirmationCheckbox;

	@FindBy(id = "txtPassword2")
	private WebElement txtConfirmPassword;

	@FindBy(id = "txtEmail")
	private WebElement txtEmail;

	@FindBy(id = "txtFName")
	private WebElement txtFirstName;

	@FindBy(id = "txtLName")
	private WebElement txtLastName;

	@FindBy(id = "txtMobile")
	private WebElement txtMobile;

	@FindBy(id = "txtPassword")
	private WebElement txtPassword;

	@FindBy(id = "txtPhone")
	private WebElement txtPhone;

	@FindBy(id = "ContentPlaceHolder1_txtSearchUser")
	private WebElement txtSearchUser;

	@FindBy(id = "txtSms")
	private WebElement txtSms;

	@FindBy(id = "txtUserName")
	private WebElement txtUserName;

	@Autowired
	public UserManagerPageObject(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the Add New User button
	 */
	public void clickAddNewUserButton() {
		addNewUser.click();
	}

	/**
	 * Clicks the Close button in the New User form
	 */
	public void clickCloseNewUserFormButton() {
		btnCloseNewUserForm.click();
	}

	/**
	 * Clicks the Create button in the form
	 */
	public void clickCreateUserButton() {
		createButton.click();
	}

	/**
	 * Clicks the button to close the Frame for Add New User
	 */
	public void clickFrameClose() {
		frameClose.click();
	}

	/**
	 * Clicks the List All button, to list all the users in a tabular format
	 */
	public void clickListAllButton() {
		listAllUsersButton.click();
	}

	/**
	 * Click the Search button to search for user
	 */
	public void clickSearchUserButton() {
		btnSearchUser.click();
	}

	/**
	 * Enters the confirm password field
	 * 
	 * @param confirmPassword
	 */
	public void enterConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword);
	}

	/**
	 * Enters the email address of the user
	 * 
	 * @param email
	 */
	public void enterEmail(String email) {
		enterText(txtEmail, email);
	}

	/**
	 * Enters the first name of the user
	 * 
	 * @param firstName
	 */
	public void enterFirstName(String firstName) {
		enterText(txtFirstName, firstName);
	}

	/**
	 * Enters the last name of the user
	 * 
	 * @param lastName
	 */
	public void enterLastName(String lastName) {
		enterText(txtLastName, lastName);
	}

	/**
	 * Enters the mobile number of the user
	 * 
	 * @param mobile
	 */
	public void enterMobile(String mobile) {
		enterText(txtMobile, mobile);
	}

	/**
	 * Enters the password in the new user form
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		enterText(txtPassword, password);
	}

	/**
	 * Enters the phone number of the user
	 * 
	 * @param phone
	 */
	public void enterPhone(String phone) {
		enterText(txtPhone, phone);
	}

	/**
	 * Enter the username to be searched
	 * 
	 * @param searchUser
	 */
	public void enterSearchUser(String searchUser) {
		enterText(txtSearchUser, searchUser);
	}

	/**
	 * Enters the SMS number of the user
	 * 
	 * @param sms
	 */
	public void enterSms(String sms) {
		enterText(txtSms, sms);
	}

	/**
	 * Enters the user name in the form
	 * 
	 * @param userName
	 */
	public void enterUserName(String userName) {
		enterText(txtUserName, userName);
	}

	/**
	 * Get the Frame object for the Add New User form
	 * 
	 * @return newUserFrameWE WebElement
	 */
	public WebElement getAddUserFrame() {
		return newUserFrame;
	}

	/**
	 * This returns the text of the title of the frame when script is entered in the
	 * name field for create user form
	 * 
	 * @return the text in the dangerMessageWE WebElement
	 */
	public String getDangerMessageText() {
		return dangerMessage.getText();
	}

	/**
	 * Get the label object for empty email field error message in the form
	 * 
	 * @return lblEmptyEmailWE WebElement
	 */
	public WebElement getLblEmptyEmail() {
		return lblEmptyEmail;
	}

	/**
	 * Get the label object for empty user group error message in the form
	 * 
	 * @return lblEmptyUserGroupWE WebElement
	 */
	public WebElement getLblEmptyUserGroup() {
		return lblEmptyUserGroup;
	}

	/**
	 * Get the label object for empty username field error message in the form
	 * 
	 * @return lblEmptyUsernameWE WebElement
	 */
	public WebElement getLblEmptyUsername() {
		return lblEmptyUsername;
	}

	/**
	 * Get the label object for Invalid Username error message in the form
	 * 
	 * @return lblInvalidUsernameMessageWE WebElement
	 */
	public WebElement getLblInvalidUsername() {
		return lblInvalidUsernameMessage;
	}

	/**
	 * Get the label object for invalid email field error message in the form
	 * 
	 * @return lblValidEmailFormatWE WebElement
	 */
	public WebElement getLblValidEmailFormat() {
		return lblValidEmailFormat;
	}

	/**
	 * Getter for the List All button.
	 * 
	 * @return the List All users Web Element object
	 */
	public WebElement getListAllButton() {
		return listAllUsersButton;
	}

	/**
	 * Get the text of the row from search result
	 * 
	 * @return the String text.
	 */
	public String getSearchResultText() {
		return searchResult.getText();
	}

	/**
	 * Getter for the User Name textbox.
	 * 
	 * @return Returns the User Name text box WebElement
	 */
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	/**
	 * Selects user group from the dropdown list in the form
	 * 
	 * @param userGroup
	 */
	public void selectUserGroup(String userGroup) {
		Select selectGroup = new Select(selectUserGroup);
		selectGroup.selectByVisibleText(userGroup);
	}

	/**
	 * Checks if 'Send email confirmation' box is checked. If it is, unchecks it.
	 */
	public void uncheckSendConfirmation() throws InterruptedException {
		Thread.sleep(250);
		sendConfirmationCheckbox.uncheck();
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(addNewUser);
	}
}



