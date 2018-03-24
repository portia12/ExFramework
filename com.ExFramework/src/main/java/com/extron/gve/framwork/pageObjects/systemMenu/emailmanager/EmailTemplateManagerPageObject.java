package com.extron.gve.framwork.pageObjects.systemMenu.emailmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;

@Component
public class EmailTemplateManagerPageObject extends BasePageObject
{

	@FindBy(id = "ctl00_ContentPlaceHolder1_EmailTemplateGrid_ctl00_ctl02_ctl00_LinkButton1")
	private WebElement createEmailTemplate;

	@FindBy(name = "TemplateListDialog")
	private WebElement createEmailTemplateFrame;
	
	@FindBy(id = "BodyTextBox_contentIframe")
	private WebElement bodyFrame;
	
	@FindBy(id = "NameTextBox")
	private WebElement txtEmailTemplateName;
	
	@FindBy(id = "DescriptionTextBox")
	private WebElement txtEmailTemplateDescription;
	
	@FindBy(id = "SubjectTextBox")
	private WebElement txtEmailTemplateSubject;
	
	@FindBy(xpath = "/html/body")
	private WebElement emailTemplateBody;
	
	@FindBy(id = "CreateTemplateButton")
	private WebElement createTemplateButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Controller offline')]")
	private WebElement searchResult;
	
	@FindBy(id = "emailTempLegend")
	private WebElement emailTemplateHeader;
	
	@Autowired
	public EmailTemplateManagerPageObject(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Clicks the Create Email Template Button in the Email Settings Page
	 */
	public void clickCreateEmailTemplateLink ()
	{
		createEmailTemplate.click();
	}
	
	/**
	 * Clicks the Create Template button inside the email template form
	 */
	public void clickCreateTemplateButton ()
	{
		createTemplateButton.click();
	}
	
	/**
	 * Enter input in the body field of the email template form
	 */
	public void enterTemplateBody (String templateBody)
	{
		switchToFrame(bodyFrame);
		emailTemplateBody.click();
		emailTemplateBody.sendKeys(templateBody);
		switchToDefaultContent();
		switchToFrame(getCreateTemplateFrame());
	}
	
	/**
	 * Enter description for the email template
	 */
	public void enterTemplateDescription (String templateDescription)
	{
		enterText(txtEmailTemplateDescription, templateDescription);
	}
	
	/**
	 * Enter the name of the email template
	 */
	public void enterTemplateName (String templateName)
	{
		enterText(txtEmailTemplateName, templateName);
	}
	
	/**
	 * Enter the subject of the email template
	 */
	public void enterTemplateSubject (String templateSubject)
	{
		enterText(txtEmailTemplateSubject, templateSubject);
	}
	
	/**
	 * Get the Web element for the Create Template Frame
	 * @return the Create Template Frame WebElement object;
	 */
	public WebElement getCreateTemplateFrame ()
	{
		return createEmailTemplateFrame;
	}
	
	/**
	 * Get the text of the search result
	 * @return
	 */
	public String getSearchResultText ()
	{
		return searchResult.getText();
	}
	
	/**
	 * Get the WebElement for the template name text box
	 * @return WebElement object for the template name text box
	 */
	public WebElement getTxtEmailTemplateName ()
	{
		return txtEmailTemplateName;
	}
	
	/**
	 * Wait for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(createEmailTemplate);
	}
	
}

