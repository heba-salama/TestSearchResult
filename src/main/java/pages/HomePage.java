
/**
 * Module for element location the home page only for doing the actions in each element to get the result page for test
 */

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(name = "q")
	WebElement searchInput;
	
	/**
	 * The method is used to entering a keyword to search for without return
	 * 
	 * @param keyword this the keyword to search for 
	 */
	public void searchKeyword(String keyword) 
	{
		searchInput.sendKeys(keyword);
		searchInput.submit(); 
	}

}