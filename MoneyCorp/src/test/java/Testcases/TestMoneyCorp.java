
package Testcases;

import java.net.MalformedURLException;

import Helper.Base;
import PageObject.ForeignExchPage;
import PageObject.LandingPage;
import PageObject.RegionPage;
import PageObject.SearchResultPage;
//import helper.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestMoneyCorp extends Base {

	LandingPage landingPage;
	RegionPage regionPage;
	ForeignExchPage foreignExchPage;
	SearchResultPage searchResultPage;
	

	 
	@Given("Open a new page in the browser.")
	public void open_a_new_page_in_the_browser() {
		super.setup();
		landingPage = new LandingPage(driver);
		regionPage = new RegionPage(driver);
		foreignExchPage = new ForeignExchPage(driver);
		searchResultPage = new SearchResultPage(driver);
	}

	@When("Navigate to {string}")
	public void navigate_to(String url) throws MalformedURLException {
		super.openUrl(url);
		System.out.format("Url %s Thread ID - navigate_to - %2d.\n",
				url, Thread.currentThread().getId());
	}
	
	@Then("Change the language and region to {string}")
	public void change_the_language_and_region_from_to(String region) {
	    // Write code here that turns the phrase above into concrete actions
	    landingPage.openRegionPage(region);
	}

	@Then("Verify region page is opened")
	public void verify_region_page_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
	    regionPage.verifyPageOpened();
	}

	@Then("Click Find out more for {string}")
	public void click_Find_out_more_for(String findOutMorePage) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		regionPage.openFindOutMore(findOutMorePage);
	}

	@Then("Validate find out more is opened")
	public void validate_find_out_more_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
		foreignExchPage.validateForeingExchPageOpened();
	}

	@Then("Search for the word {string} using the search box")
	public void search_for_the_word_using_the_search_box(String searchText) {
	    // Write code here that turns the phrase above into concrete actions
	    foreignExchPage.search(searchText);
	}

	@Then("Validate if you have arrived on the search result page {string}")
	public void validate_if_you_have_arrived_on_the_search_result_page(String searchText) {
	    // Write code here that turns the phrase above into concrete actions
	    searchResultPage.validateIfResultsOpened(searchText);
	}

	@Then("Validate that each article in the list displays a link that starts with {string}")
	public void validate_that_each_article_in_the_list_displays_a_link_that_starts_with(String commonLink) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		searchResultPage.validateCommonLinkPresentInAllResults(commonLink);
	}
	
	


}
