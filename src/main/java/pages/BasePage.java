
/**
 * This module for initializing elements over pages instead of initializing elements in every page
 * To be inherited later in the classes of package pages.
 */


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	
	protected WebDriver driver;
	
	/**
	 * This method is used to initiate the elements for the pages. 
	 * To be inherited and used in the modules(HomePage.java, ResultPage.java) later.
	 * 
	 * @param driver the webDriver used in execution(may be Chrome, Edge, Firefox... etc)
	 */
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}