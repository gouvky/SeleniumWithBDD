package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPageObjects;
import pageObjects.UserManagementPageObjects;

public class CommonFunctions {
	
	private static Logger logger = Logger.getLogger(CommonFunctions.class);
	
	private static CommonFunctions cutilsInstance; //Applied Lazy initialization Singleton design pattern concept

	private CommonFunctions() {}

	public static CommonFunctions getInstance() {
		if(cutilsInstance == null) {
			cutilsInstance = new CommonFunctions();
		}
		return cutilsInstance;
	}
	
	public void initWebElements() {
		
		logger.info("Initiate the WebElements");
		PageFactory.initElements(DriverManager.getDriver(), LoginPageObjects.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), UserManagementPageObjects.getInstance());
	}
	
	public void waitForElement(long timeout, WebElement element) {
		WebElement result = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
		        .until(ExpectedConditions.visibilityOf(element));
		System.out.println(result.getText());
	}
	
	public void moveToWebElement(WebElement element) {
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(element).perform();
	}
	
	public void clickAndHoldElement(WebElement element) {
		Actions action = new Actions(DriverManager.getDriver());
		action.clickAndHold(element).perform();
	}
	
	public void clickTABKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void waitForElementToBeClickable(long timeout, WebElement element) {
		WebElement result = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
		        .until(ExpectedConditions.elementToBeClickable(element));
		System.out.println(result.getText());
	}
	
	public void clickElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", element);
	}
	
	public void moveToWebElementCoordinates(WebElement element) {
		Actions action = new Actions(DriverManager.getDriver());
		
		int x = element.getLocation().getX();
		System.out.println("X Coordinate : " + x);
		int y = element.getLocation().getY();
		System.out.println("Y Coordinate : " + y);
		
		action.moveByOffset(x+1, y+1).click();
		action.build().perform();
	}
}