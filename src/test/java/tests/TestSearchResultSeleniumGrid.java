package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import data.LoadProperties;
import pages.HomePage;
import pages.ResultPage;


public class TestSearchResultSeleniumGrid extends TestBaseSeleniumGrid {

	HomePage homeObj;
	ResultPage resultObj;

	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
	}


	@Test(priority=0)
	public void validateResultCount() throws InterruptedException
	{

		String input = LoadProperties.userData.getProperty("INPUT");


		homeObj = new HomePage(getDriver());
		resultObj = new ResultPage(getDriver());


		homeObj.searchKeyword(input);

		scrollDown();

		Thread.sleep(1000);

		resultObj.nextPage();
		int page2 = resultObj.resultCount();

		scrollDown();

		Thread.sleep(1000);

		resultObj.nextPage();
		int page3 = resultObj.resultCount();

		Assert.assertEquals(page2, page3);

	}


}