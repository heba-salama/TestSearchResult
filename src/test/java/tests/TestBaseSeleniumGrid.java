package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;

public class TestBaseSeleniumGrid {
	
	public static String url = LoadProperties.userData.getProperty("URL");
	protected ThreadLocal<RemoteWebDriver> driver = null;
		

	
	@BeforeClass
	@Parameters({"BrowserType"})
	public void openDriver(@Optional("Chrome") String browserType ) throws MalformedURLException
	{
		driver= new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("browserName", browserType );
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(url);
		
	}
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	

	
	@AfterClass
	public void closeDriver()
	{
		getDriver().quit();
		driver.remove();
	}
	
}