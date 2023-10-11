package PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPage {

	WebDriver driver;

	public SearchResultPage(WebDriver driver)

	{
		this.driver = driver;

	}
	private By serchResultHeader = By.xpath("//*[@class='chosen-select']");
	private By showMoreSearch = By.xpath("//a[contains(@class,'show-more-search')]");
	//private By showMoreSearch = By.xpath("/html/body/section/section/div[2]/div[4]/a");
	
	
	
	private By totalNumberOfSearchItems = By.xpath("//*[contains(@class,'pagination bottom')]//span[@class='total']");
	private By showingNumberOfSearchItems = By.xpath("//*[contains(@class,'pagination bottom')]//span[@class='showing']");
	//private By serchResultList = By.xpath("//*[@class='results-wrapper']//a");//href
	private By serchResultList = By.xpath("//*[@class='show-more show-more-search']//a");//href
	private By GettouchScrollup = By.xpath("/html/body/section/div[2]/div/div[2]/div[1]/h2");//href
	//private By GettouchScrollup = By.xpath("/html/body/section/div[3]/div/div[4]/div[1]/h3");//href
	
	private By totalNumberOfSearchItems2 = By.xpath("//*[contains(@class,'pagination bottom')]//span[@class='total']");
	
	//class="show-more show-more-search"
	
	//html/body/section/section/div[2]/div[4]/a
	
	
			
	public void entertextonsearchbox(String exchangekey) {
		driver.findElement(serchResultHeader).sendKeys(exchangekey);

	}

	public void clickonLoginButton() {
		driver.findElement(showMoreSearch).click();
	}

	public void validateIfResultsOpened(String searchText) {
		WebElement serchResultHeaderElement = driver.findElement(serchResultHeader);
		String serchResultHeaderElementText = serchResultHeaderElement.getAttribute("value");
		System.out.println("serchResultHeaderElementText: " + serchResultHeaderElementText);
		Assert.assertEquals("Search Result Page is not successfully opened", searchText, serchResultHeaderElementText);
		
	}

	public void validateCommonLinkPresentInAllResults(String commonLink) throws InterruptedException {
		// Identify number of results returned
		WebElement totalNumberOfSearchItemsElement = driver.findElement(totalNumberOfSearchItems);
		WebElement showingNumberOfSearchItemsElement = driver.findElement(showingNumberOfSearchItems);
		
		
		WebElement m = driver.findElement(GettouchScrollup);
	    JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].scrollIntoView({block: 'end'})", m);
		Thread.sleep(1000);
		j.executeScript("window.scrollBy(0,-80)", "");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,2900)", "");
		
		WebElement showMoreSearchElement = driver.findElement(showMoreSearch);
		int totalNumber = 1;
		int showingNumber = 0;
		if (showMoreSearchElement != null) {
			for (int x = 1; showingNumber < totalNumber; x++) {
				
				Thread.sleep(1000);
				try {
					showMoreSearchElement.click();
				} catch(Exception e) {
					System.out.println("skipped if not clickable");
				}
				Thread.sleep(5000);
				j.executeScript("arguments[0].scrollIntoView({block: 'end'})", m);
				Thread.sleep(2000);
				j.executeScript("window.scrollBy(0,-80)", "");
				
				
				String totalNumberOfSearchItems = totalNumberOfSearchItemsElement.getText();
				System.out.println("totalNumberOfSearchItems: " + totalNumberOfSearchItems);
				totalNumber = Integer.parseInt(totalNumberOfSearchItems);
				
				String showingNumberOfSearchItems = showingNumberOfSearchItemsElement.getText();
				System.out.println("showingNumberOfSearchItems: " + showingNumberOfSearchItems);
				showingNumber = Integer.parseInt(showingNumberOfSearchItems);
			}
		}
		
		List<WebElement> serchResultListElement = driver.findElements(serchResultList);
		for (WebElement serchItemElement : serchResultListElement) {
			String href = serchItemElement.getAttribute("href");
			boolean isValidLink = false;
			if (href.startsWith(commonLink)) {
				isValidLink = true;
			}
			Assert.assertEquals("Assert Error: Link \"" + href + "\" is not valid", true, isValidLink);
		}
		
		
	}

}
