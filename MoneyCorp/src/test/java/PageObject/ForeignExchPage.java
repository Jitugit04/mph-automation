package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForeignExchPage {

	WebDriver driver;

	public ForeignExchPage(WebDriver driver)

	{
		this.driver = driver;

	}
	private By headerOfForeignExchangePage = By.xpath("//*[contains(@class,'h1-block__content')]/h1");
	private By usaEngSearchbox = By.xpath("//div[contains(@class,'u-flex-align-center')]/div/form/input[@id='nav_search']");
	private By searchButton = By.xpath("div[contains(@class,'u-flex-align-center')]/div/form/input[@type='submit']");
	

	public void validateForeingExchPageOpened() {
		
		WebElement headerOfForeignExchangePageElement = driver.findElement(headerOfForeignExchangePage);
		String headerOfForeignExchangeText = headerOfForeignExchangePageElement.getText();
		System.out.println("headerOfForeignExchangeText: " + headerOfForeignExchangeText);
		Assert.assertEquals("Foreign Exchange Solutions Page is not successfully opened", "Foreign exchange solutions for your business", headerOfForeignExchangeText);
	}

	public void search(String searchText) {
		WebElement usaEngSearchboxElement = driver.findElement(usaEngSearchbox);
		usaEngSearchboxElement.sendKeys(searchText);
		usaEngSearchboxElement.sendKeys(Keys.RETURN);
		
//		WebElement searchButtonElement = driver.findElement(searchButton);
//		searchButtonElement.click();
		
	}

}
