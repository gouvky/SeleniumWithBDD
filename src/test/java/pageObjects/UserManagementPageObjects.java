package pageObjects;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonFunctions;
import utilities.Constants;
import utilities.DriverManager;

public class UserManagementPageObjects {
	
	public Select select;
	
	private static UserManagementPageObjects UserPageInstance;
	
	private UserManagementPageObjects(){}
	
	public static UserManagementPageObjects getInstance() {
		
		 if(UserPageInstance == null) {
			 UserPageInstance = new UserManagementPageObjects();
		 }
		 return UserPageInstance;
	}
	
	  By adminLink = By.linkText("Admin");
	  By userMgmtLink = By.linkText("User Management");
	  By usersLink = By.linkText("Users");
	  By addButton = By.id("btnAdd");
	  By userRoleSelection = By.id("systemUser_userType");
	  By empName = By.id("systemUser_employeeName_empName");
	  By userName = By.id("systemUser_userName");
	  By status = By.id("systemUser_status");
	  By password = By.id("systemUser_password");
	  By confirmPassword = By.id("systemUser_confirmPassword");
	  @FindBy(id="btnSave")
	  WebElement saveBtn;
	  
	  public void clickAdmin() {
		  
		  CommonFunctions.getInstance().moveToWebElement(DriverManager.getDriver().findElement(adminLink));
		  CommonFunctions.getInstance().waitForElement(10,DriverManager.getDriver().findElement(userMgmtLink));
	  }
	  
	  public void clickUserMgmt() {
		  
		  CommonFunctions.getInstance().moveToWebElement(DriverManager.getDriver().findElement(userMgmtLink));
		  CommonFunctions.getInstance().waitForElement(10,DriverManager.getDriver().findElement(usersLink));
	  }
	  
	  public void clickUsers() {
		  
		  DriverManager.getDriver().findElement(usersLink).click();
	  }
	  
	  public void clickAdd() {
		  DriverManager.getDriver().findElement(addButton).click();
	  }
	  
	  public void selectRole() {
		  select = new Select(DriverManager.getDriver().findElement(userRoleSelection));
		  select.selectByVisibleText(Constants.UserRole);
	  }
	  
	  public void enterEmpName() throws AWTException {
		  DriverManager.getDriver().findElement(empName).sendKeys(Constants.EmpName);
		  CommonFunctions.getInstance().clickTABKey();  
	  }
	  
	  public void enterUsername() {
		  DriverManager.getDriver().findElement(userName).sendKeys(Constants.UserName);
	  }
	  
	  public void selectStatus() {
		  select = new Select(DriverManager.getDriver().findElement(status));
		  select.selectByVisibleText(Constants.Status);
	  }
	  
	  public void enterPassword() {
		  DriverManager.getDriver().findElement(password).sendKeys(Constants.EmpPassword);
	  }
	  
	  public void enterConfirmPassword() {
		  DriverManager.getDriver().findElement(confirmPassword).sendKeys(Constants.EmpConfirmPwd);
		  CommonFunctions.getInstance().waitForElement(10,saveBtn);
	  }
	  
	  public void clickSaveBtn() throws AWTException, InterruptedException {
		  
		  CommonFunctions.getInstance().clickTABKey();
		  
		  CommonFunctions.getInstance().waitForElementToBeClickable(30, saveBtn);
		  CommonFunctions.getInstance().clickElementJavaScript(saveBtn);
		  Thread.sleep(5000);
	  }
}