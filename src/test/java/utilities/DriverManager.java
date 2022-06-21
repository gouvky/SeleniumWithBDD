package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static Logger logger = Logger.getLogger(DriverManager.class);
	private static WebDriver driver = null;
	
	public static void launchBrowser() {
		
		String Browser = Constants.Browser;
		PropertyConfigurator.configure(Constants.log4jPath);
		
		switch (Browser) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			logger.info("Launch the browser");
			driver = new ChromeDriver();
			
			logger.info("Maximize the browser window");
			driver.manage().window().maximize();
			break;
			
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			logger.info("Launch the browser");
			driver = new FirefoxDriver();
			
			logger.info("Maximize the browser window");
			driver.manage().window().maximize();
			break;
			
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			logger.info("Launch the browser");
			driver = new EdgeDriver();
			
			logger.info("Maximize the browser window");
			driver.manage().window().maximize();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			logger.info("Launch the browser");
			driver = new ChromeDriver();
			
			logger.info("Maximize the browser window");
			driver.manage().window().maximize();
			break;
		}
	}
	
	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}
}