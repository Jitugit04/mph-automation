# mph-automation

## Web Automation Project - MoneyCorp
### Overview
This project is a web automation for testing specific pages from https://www.moneycorp.com/en-gb/ 
<br>It is taking care of below scenario -
* Open the following URL: https://www.moneycorp.com/en-gb/  and verify.
* Change the language and region from the top right corner to USA (English) and verify See example snippet.
* Click Find out more for “Foreign exchange solutions” Validate if you have arrived on the page.
* Search for the word “international payments” using the search box.
* Validate if you have arrived on the result page.
* Validate that each article in the list displays a link that starts with https://www.moneycorp.com/en-us/
* This code should be a working code with all required libraries and relevant files.

### How to use
#### Few quick points -
* Used Cucumber framework with selenium to develop the automation project. 
* For generating the report, extent-report plugin is used.
* Project is built with maven.
* Project include one feature files (moneycorp.feature) which includes aforementioned scenario.
  
#### How to run -
* Prerequisites - replace ./MoneyCorp/chromedriver.exe with exe compatible with current chrome browser version. 
* Build the project with maven (run 'mvn install' command)
* Execute Runner Class: RunMoneyCorpTest.java
* Extent report would be generated at location: MoneyCorp/test-output/SparkReport/Spark1.html

#### Results -
This automation project has been run and the results also are included in Project folder MoneyCorp. Below is the location to the report -
* MoneyCorp/test-output/SparkReport/Spark1.html
