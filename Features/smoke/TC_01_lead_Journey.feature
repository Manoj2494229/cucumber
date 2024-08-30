Feature: Login

@leadform @smoke
  Scenario: Fill up the lead form and submit
    Given the user opens the website "https://webserver-vil-uatnew.lfr.cloud/"
    When the user clicks on Sign Up Button
    And the user enters "test" into company/legal entity name Required
    And the user enters "test" into business address 1 Required
    And the user enters "test" into business address 2 Required
    And the user enters "400604" into pin code Required
    And the user enters "test" into contact person name Required
    And the user enters "test@gmail.com" into official email id Required
    And the user enters "7000000000" into mobile number Required
    And the user selects "News"
    And the user enters Text into Text Verification Required
    And the user clicks on "Submit"
    And the user clicks on "YES"
    Then the form should be submitted successfully

@login @smoke
  Scenario: Approve the lead form
    Given Open the website "https://webserver-vil-uatnew.lfr.cloud"
    When Enter "vitechadmin2@liferay.com" into enter email mobile and click on OTP
    And Enter four time "1" into OTP section
    Then Click on the verify & login button
    Given the user Click on Partner Management tab
    And Click on Partner Leads Task tab
    And Click on Assigned To My Roles
    And Click on Assign To Me
    And Click on Approve/Reject
    And Click on Comments Require
    And Enter "approved" into Comments Require
    And Click on Submit
    Then Click on YES
