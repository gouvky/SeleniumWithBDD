package stepDefinitions;

import java.awt.AWTException;

import org.apache.log4j.Logger;

import io.cucumber.java.en.*;
import pageObjects.UserManagementPageObjects;

public class UserManagementSteps {
	
	private static Logger logger = Logger.getLogger(UserManagementSteps.class);

	@When("Navigate to Users screen from Admin Menu")
	public void navigate_to_users_screen_from_admin_menu() {
		
		logger.info("Mouse hover on the Admin link");
		UserManagementPageObjects.getInstance().clickAdmin();
		
		logger.info("Mouse hover on the User Management link");
		UserManagementPageObjects.getInstance().clickUserMgmt();
		
		logger.info("Click on Users link");
		UserManagementPageObjects.getInstance().clickUsers();
	}
	
	@When("Click Add button to add user")
	public void click_add_button_to_add_user() {
		
		logger.info("Click on Add button");
		UserManagementPageObjects.getInstance().clickAdd();
	}
	
	@When("Fill the User details")
	public void fill_the_user_details() throws AWTException {
	    
		logger.info("Fill the User details");
		UserManagementPageObjects.getInstance().selectRole();
		UserManagementPageObjects.getInstance().enterEmpName();
		UserManagementPageObjects.getInstance().enterUsername();
		UserManagementPageObjects.getInstance().selectStatus();
		UserManagementPageObjects.getInstance().enterPassword();
		UserManagementPageObjects.getInstance().enterConfirmPassword();
	}
	
	@When("Click Save button to save the user details")
	public void click_save_button_to_save_the_user_details() throws AWTException, InterruptedException {
		
		logger.info("Click Save button");
		UserManagementPageObjects.getInstance().clickSaveBtn();
	}
}