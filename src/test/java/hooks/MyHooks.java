package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Utilities;

public class MyHooks {

	WebDriver driver;
	Utilities utils = new Utilities();

	@Before
	public void setUp() throws IOException {
		Properties prop = utils.getProperty();
		DriverFactory.getBrowserName(prop.getProperty("browserName"));
		driver = DriverFactory.getDriver();

		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replace(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "img/png", scenarioName);
		}
		driver.quit();
	}

}
