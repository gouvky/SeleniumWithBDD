package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonFunctions;

public class LoginPageObjects { //Below is the Java Lazy initialization Singleton pattern concept

	//--->Private static variable of the same class that is the only instance of the class.	
	private static LoginPageObjects loginPageInstance; 
	
	private LoginPageObjects(){} //Private constructor to restrict instantiation of the class from other classes

	/*	Public static method that returns the instance of the class, 
	this is the global access point for outer world to get the instance of the singleton class.*/	

	public static LoginPageObjects getInstance() {

		if(loginPageInstance == null) {
			loginPageInstance = new LoginPageObjects();
		}
		return loginPageInstance;
	}

	@FindBy(id="txtUsername")
	WebElement uname;

	@FindBy(id="txtPassword")
	WebElement pwd;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	@FindBy(xpath="//*[@id='welcome-menu']/ul/li/a[contains(text(),'Logout')]")
	WebElement logoutLink;

	@FindBy(id="welcome")
	WebElement dropDown;

	public void enterUsername(String username) {
		uname.sendKeys(username);
	}

	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.submit();
	}

	public void clickMenu() {
		CommonFunctions.getInstance().waitForElement(10, dropDown);
		dropDown.click();
	}

	public void clickLogoutLink() {
		CommonFunctions.getInstance().waitForElement(20, logoutLink);
		CommonFunctions.getInstance().clickElementJavaScript(logoutLink);
	}
}