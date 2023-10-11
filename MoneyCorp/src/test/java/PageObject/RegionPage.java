package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegionPage {

	WebDriver driver;

	public RegionPage(WebDriver driver)

	{
		this.driver = driver;

	}
	private By regionLink = By.xpath("//*[@id='language-dropdown-flag']/span/img");
	//private By regionPageHeader = By.xpath("//*[@class='h1-block__content']/h1");
	private By foreignExchangelinkFindoutmore = By.xpath("//a[contains(@href,'foreign-exchange-solutions')]/span");
	private By onetrustCloseButton = By.xpath("//button[contains(@class,'onetrust-close-btn-handler')]");
	
	

	public void verifyPageOpened() {
		
		
		WebElement regionLinkElement = driver.findElement(regionLink);
		String dataSrc = regionLinkElement.getAttribute("data-src");
		//WebElement regionLinkElement = driver.findElement(regionPageHeader);
		//String get=regionLinkElement.getText();
		System.out.println("dataSrc: " + dataSrc);
		boolean isRegionChanged = false;
		 
		
		if(dataSrc.contains("united-states-of-america")) {
			isRegionChanged = true;
		}
		Assert.assertEquals("Assert Error: Region is not succcessfully changed", true, isRegionChanged);
	}
	
	public void openFindOutMore(String findOutMorePage) throws InterruptedException {
		//WebElement foreignExchangelinkFindoutmoreElement = driver.findElement(foreignExchangelinkFindoutmore);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1900)", "");
		
		Thread.sleep(5000);
		WebElement onetrustCloseButtonElement = driver.findElement(onetrustCloseButton);
		onetrustCloseButtonElement.click();
		
		WebElement foreignExchangelinkFindoutmoreElement = driver.findElement(foreignExchangelinkFindoutmore);
		
        Actions action = new Actions(driver);
        action.moveToElement(foreignExchangelinkFindoutmoreElement).click().build().perform();
		
	}

}
