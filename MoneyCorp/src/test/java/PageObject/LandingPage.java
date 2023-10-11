package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver)

	{
		this.driver = driver;

	}
	// OwnerSite
	private By regionLink = By.xpath("//*[@id='language-dropdown-flag']/span/img");
	private By usaEnglishLink = By.xpath("//*[@id='nav-languages-overlay']/div[2]/ul/li[9]/a/div/span[1]");
	
	
	public void openRegionPage(String region) {
		
		WebElement regionLinkElement = driver.findElement(regionLink);
		regionLinkElement.click();
		
		WebElement usaEnglishLinkElement = driver.findElement(usaEnglishLink);
		usaEnglishLinkElement.click();
	}

}
