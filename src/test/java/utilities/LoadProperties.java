package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadProperties {
	
	private static Logger logger = Logger.getLogger(LoadProperties.class);
	
	private static LoadProperties loadProp; //Applied Lazy initialization Singleton design pattern concept

	private LoadProperties() {}

	public static LoadProperties getInstance() {
		if(loadProp == null) {
			loadProp = new LoadProperties();
		}
		return loadProp;
	}
	
	Properties prop;
	 
	public void loadProperties() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\viki3\\InterviewPreparation"
					+ "\\SeleniumWithBDD\\Config.properties");
			
			logger.info("Load the properties");
			prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to load the properties");
		}
		
		Constants.APP_Url = prop.getProperty("App_Url");
		Constants.Browser = prop.getProperty("Browser");
		Constants.Username = prop.getProperty("Username");
		Constants.Password = prop.getProperty("Password");
		Constants.log4jPath = prop.getProperty("log4jPath");
		Constants.UserRole = prop.getProperty("UserRole");
		Constants.EmpName = prop.getProperty("EmpName");
		Constants.UserName = prop.getProperty("UserName");
		Constants.Status = prop.getProperty("Status");
		Constants.EmpPassword = prop.getProperty("EmpPassword");
		Constants.EmpConfirmPwd = prop.getProperty("EmpConfirmPwd");
	}
}