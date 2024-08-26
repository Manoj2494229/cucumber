Feature: Login

  Scenario: Login with VI user
    Given Open the website "https://webserver-vil-uatnew.lfr.cloud"
    When Enter "vitechadmin2@liferay.com" into enter email mobile and click on OTP
    And Enter four time "1" into OTP section
    Then Click on the verify & login button
