
/**
 * Running test and Validate if the search result count is fixed number throughout pages.
 * Executing tests in different browsers(Edge, FireFox and Chrome).
 * @param  URL  an absolute URL for the Website.
 * @param  INPUT the input keyword to searching for.
 */

package tests;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import data.LoadProperties;
import pages.HomePage;
import pages.ResultPage;


public class TestSearchResult {

	public static WebDriver driver;

	HomePage homeObj;
	ResultPage resultObj;

	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
	}


	/**
	 * Method to run test 
	 * Here are the test steps:
	 * #1 open the URL
	 * #2 Type and search for the keyword
	 * #3 Scroll down and go to next page
	 * #4 Count the number number of results displayed on the second page
	 * #5 Scroll down and go to the next page
	 * #6 Validate if the number of results on page 2 is equal to page 3 or not
	 * @param browserType the browser value from testng.xml file
	 * @throws InterruptedException 
	 */

	@Test
	@Parameters({"BrowserType"})
	public void validateResultCount(String browserType) throws InterruptedException
	{

		String url = LoadProperties.userData.getProperty("URL");
		String input = LoadProperties.userData.getProperty("INPUT");

		if (browserType.equalsIgnoreCase("Microsoft Edge"))
		{
			System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}


		driver.manage().window().maximize();
		driver.get(url);

		homeObj = new HomePage(driver);
		resultObj = new ResultPage(driver);


		homeObj.searchKeyword(input);

		scrollDown();

		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("input"));

		try {
			resultObj.nextPage();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Error occurred: "+ e.getMessage());
		}

		int page2 = resultObj.resultCount();

		scrollDown();

		Thread.sleep(1000);
		Assert.assertTrue(resultObj.isPage2());

		resultObj.nextPage();
		int page3 = resultObj.resultCount();

		Thread.sleep(1000);
		Assert.assertTrue(resultObj.isPage3());

		Assert.assertEquals(page2, page3);

	}

	/**
	 * Method for closing the browser after test execution
	 */
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}