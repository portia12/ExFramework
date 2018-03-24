package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.LoginPageObject;
import com.extron.gve.framework.pageobjects.importproject.ImportProjectPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.SystemMenuPageObject;
import com.extron.gve.framework.publicobjects.TestUserFactory;
import com.extron.gve.properties.CommonStringProperties;
import com.extron.gve.properties.ProjectInfo;
import com.extron.gve.properties.TestProperties;





public class ImportProjectTestCase extends BaseTestCase {

	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private SystemMenuPageObject systemMenuPageObject;
	
	@Autowired
	private TestUserFactory testUserFactory;

	@Autowired
	private TestProperties testProperties;
	
	@Autowired
	private CommonStringProperties commonStringProperties;
	
	@Autowired
	private ProjectInfo projectInfo;
	
	@Autowired
	private ImportProjectPageObject importProjectPageObject;
	
	
	/**
	 * When: Import the right projects
	 * Should: Projects should be imported.
	 * @throws Exception 
	 */
	@Test(description = "Import multiple Projects")
	public void importProjectTest() throws Exception 
	{
		//waiting to load help Desk page
		homePageObject.waitForPageToLoad();
		
		//clicking on system Menu tab
		homePageObject.clickSystemMenuTab();
		
		//waiting to load system menu page
		systemMenuPageObject.waitForPageToLoad();
		
		
		//clicking on import project link
		importProjectPageObject.clickImportButton();
		
		
		//waiting to load import configuration 
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getImportNewConfigurations());
		
		
		//clicking on import new configuration
		importProjectPageObject.clickImportConfiguration();
	
			
		for(int i=0;i<projectInfo.GetAllProjectInfo().size();i++)
		{
		
			
		if(projectInfo.GetAllProjectInfo().get(i).ProjectType.matches("IP Link Pro"))
		{
			
		//waiting to visible ControllerTypeDropdown	
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getControllerTypeDropdown().get(i));	
			
		//clicking on controller drop down 
		importProjectPageObject.clickControllerTypeDropdown(i);
		
		//waiting to visible Controller type
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getIPLinkProController().get(i));
		
		//selecting the controller type
		importProjectPageObject.selectIPLinkProController(i);
		
		
		//waiting to visible project name
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getProjectName().get(i));
		
		//entering project name
		importProjectPageObject.enterProjectName(projectInfo.GetAllProjectInfo().get(i).ProjectName,i);
	
		//waiting to visible host/IP
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getHostName().get(i));
						
		//entering gv host name
		importProjectPageObject.enterHostName(projectInfo.GetAllProjectInfo().get(i).ProjectIPAddress,i);
		
		//waiting to visible controller user
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getControllerUserName().get(i));
		
		//entering user name
		importProjectPageObject.enterControllerUserName(projectInfo.GetAllProjectInfo().get(i).ControllerName,i);
	    
		//waiting to visible controller password text box
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getControllerPassword().get(i));
				
		
		//entering password
		importProjectPageObject.enterControllerPassword(projectInfo.GetAllProjectInfo().get(i).ControllerPassword, i);
		
		}
		else
		{
			
			//waiting to visible project name
			importProjectPageObject.waitUntilClickable(importProjectPageObject.getProjectName().get(i));
			
			//entering project name
			importProjectPageObject.enterProjectName(projectInfo.GetAllProjectInfo().get(i).ProjectName,i);
	
			//waiting to visible host/IP
			importProjectPageObject.waitUntilClickable(importProjectPageObject.getHostName().get(i));
			
			//entering gv host name
			importProjectPageObject.enterHostName(projectInfo.GetAllProjectInfo().get(i).ProjectIPAddress,i);
			
			//waiting to visible controller password text box
			importProjectPageObject.waitUntilClickable(importProjectPageObject.getControllerPassword().get(i));
					
			//entering password
			importProjectPageObject.enterControllerPassword(projectInfo.GetAllProjectInfo().get(i).ControllerPassword,i);
			
			
		}
		
		
		 if(i<projectInfo.GetAllProjectInfo().size()-1)
		 {
			 
			//waiting to visible plus sign
			importProjectPageObject.waitUntilClickable(importProjectPageObject.getAddMoreProjects());
						
			//clicking on plus sign
			 importProjectPageObject.clickAddMoreProjects();
			
				
			   
		   }
		}
		
		//waiting to visible import button
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getImport());
						
		
		//clicking on import button
		importProjectPageObject.clickImport();
		Thread.sleep(3000);
		
		//waiting until import frame is visible
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getImportProjectFrame());
		
		//switching to import frame
		importProjectPageObject.switchToFramebyName("ImportProcess");
		
		//waiting until import is done
		importProjectPageObject.waitUntilClickable(importProjectPageObject.getImportDone(),5000);
		
		//Verifying that project got imported and sucessfull message is displaying
		  for(int i=0; i<=projectInfo.GetAllProjectInfo().size()-1;i++)
			 {
			   Assert.assertTrue(importProjectPageObject.isDisplayed(importProjectPageObject.getImportSuccessMessage().get(i)));
			     {
				    System.out.println("project got imported successfully");
			      }
			 } 
		
		//clicking on close button
		importProjectPageObject.clickImportDone();
	
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


