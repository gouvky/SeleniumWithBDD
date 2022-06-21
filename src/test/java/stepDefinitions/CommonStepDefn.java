package stepDefinitions;

import io.cucumber.java.Before;
import utilities.CommonFunctions;
import utilities.DriverManager;
import utilities.LoadProperties;

public class CommonStepDefn {
	
	@Before
	public void beforeScenario() {
		
		try {
			if(DriverManager.getDriver()==null) {
				
				LoadProperties.getInstance().loadProperties();
				
				DriverManager.launchBrowser();
			}
			CommonFunctions.getInstance().initWebElements();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}