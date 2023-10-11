@Browser
Feature:  test moneycorp	


  
 Scenario: Verification for moneycorp 
     
    Given Open a new page in the browser.
    When Navigate to "https://www.moneycorp.com/en-gb/"
    Then Change the language and region to "USA (English)"
    Then Verify region page is opened
    Then Click Find out more for "Foreign exchange solutions"
    Then Validate find out more is opened
    Then Search for the word "international payments" using the search box
    Then Validate if you have arrived on the search result page "international payments"
    Then Validate that each article in the list displays a link that starts with "https://www.moneycorp.com/en-us/"
