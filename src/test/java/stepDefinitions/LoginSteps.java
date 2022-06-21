package stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPageObjects;
import utilities.Constants;
import utilities.DriverManager;

public class LoginSteps {
	
	private static Logger logger = Logger.getLogger(LoginSteps.class);

	@Given("Enter the application url")
	public void enter_the_application_url() {

		logger.info("Launch the application URL");
		DriverManager.getDriver().get(Constants.APP_Url);
	}

	@Given("Enter username and password")
	public void enter_email_and_password() {

		logger.info("Enter the login credentials");
		LoginPageObjects.getInstance().enterUsername(Constants.Username);
		LoginPageObjects.getInstance().enterPassword(Constants.Password);

	}
	
	@Given("Enter username as {string} and password as {string}")
	public void enter_email_and_password(String username, String password) {

		logger.info("Enter the login credentials");
		LoginPageObjects.getInstance().enterUsername(username);
		LoginPageObjects.getInstance().enterPassword(password);

	}

	@When("Click on login button")
	public void click_on_login_button() {

		logger.info("Click Login button");
		LoginPageObjects.getInstance().clickLoginBtn();
	}

	@Then("Verify the title of the page {string}")
	public void verify_the_title_of_the_page(String pageTitle) {

		if(DriverManager.getDriver().getPageSource().contains("Invalid credentials")) {
			DriverManager.getDriver().close();
			
			logger.info("Login failed due to Invalid Credentials");
			Assert.assertTrue(false);
		}
		else {
			logger.info("Verified the title and it is matched");
			Assert.assertEquals(pageTitle, DriverManager.getDriver().getTitle());
		}    
	}

	@When("Click on Logout link")
	public void click_on_logout_link() {

		logger.info("Click Menu to access the Logout link");
		LoginPageObjects.getInstance().clickMenu();
		
		logger.info("Click on Logout link to logout from the application");
		LoginPageObjects.getInstance().clickLogoutLink();
	}

	@And("Close the browser")
	public void close_the_browser() {

		logger.info("Close the browser");
		DriverManager.getDriver().quit();  
	}
}