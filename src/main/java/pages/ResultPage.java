
/**
 * Validation if the search result count for a keyword is a fixed number throughout pages
 * Beside Executing tests in different browsers(Edge, FireFox and Chrome).
 * Allocating all

 * @return the number of results on page 2 or page 3 
*/


package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {

	public ResultPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(id = "pnnext")
	WebElement pageNext;
	
	@FindBy(className = "g")
	List<WebElement> count;
	
	@FindBy(id = "result-stats")
	WebElement pageNom;

	
	public void nextPage() 
	{
		pageNext.click();
	}
	
	
	/**
	 * This method is used to count the whole elements with class"g" just for the normal result
	 * (ignore any maps, videos, or images.).
	 * so the result count could be calculated and enhance the comparison for validation test.
	 * 
	 * @return the number of results on page 2 or page 3 
	 */
	public int resultCount()
	{
		return count.size();
	}
	
	public boolean isPage2()
	{
		return pageNom.getText().contains("Page 2 of");
	}
	
	public boolean isPage3()
	{
		return pageNom.getText().contains("Page 3 of");
	}
	
}
