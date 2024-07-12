Feature: Login

  Background: 
    Given Open website "https://webserver-vil-uatnew.lfr.cloud"
    When Enter "vitechadmin2@liferay.com" into enter email mobile
    And Click on OTP
    And Enter "1" into "OTP expired.
    And Enter "1" into "OTP expired.
    And Enter "1" into "OTP expired.
    And Enter "1" into "OTP expired.
    Then Click on verify & login

  @pageload
  Scenario: check page load
    Given check page title
    And read('ScenarioCall.feature@Sanity')
