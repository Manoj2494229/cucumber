Feature: Discount Management

  Background: User is Logged In
    Given Open the website "https://webserver-vil-uatnew.lfr.cloud"
    When Enter "vitechadmin2@liferay.com" into enter email mobile and click on OTP
    And Enter four time "1" into OTP section
    Then Click on the verify & login button

@discount @smoke
  Scenario: Create and Submit a New Percentage Discount
    When I click on Discount Management
    And I click on Discount List
    And I click on New
    And I enter "Percentage Discount" into Name Required
    And I select Discount from Type Required
    And I select Total from Apply To Required
    And I select "Percentage" from Click on Type
    And I Click on Submit
    And I select Type from Percentage
    And I enter Percentage Discount into Description Required
    And I enter "100" into Amount Required
    And I click on the coupon toggle switch
    And I enter "Percentage" into Coupon Code
    And I click and enter "12" into Maximum Total Uses
    And I click and enter "12" into Maximum Uses Per Account
    And I click on Active
    And I click on Submit for Workflow
    Then I click on Active to set it to In-active
    And I click on Submit for Workflow
    
@discount @smoke
  Scenario: Create and Submit a New Fixed Amount Discount
    When I click on Discount Management
    And I click on Discount List
    And I click on New
    And I enter "Fixed Amount" into Name Required
    And I select Discount from Type Required
    And I select Total from Apply To Required
    And I select "Percentage" from Click on Type
    And I Click on Submit
    And I select Type from Fixed Amount
    And I enter Fixed Amount into Description Required
    And I enter "100" into Amount Required
    And I click on the coupon toggle switch
    And I enter "Fixed_Amount" into Coupon Code
    And I click and enter "12" into Maximum Total Uses
    And I click and enter "12" into Maximum Uses Per Account
    And I click on Active
    And I click on Submit for Workflow
    Then I click on Active to set it to In-active
    And I click on Submit for Workflow
    
@discount1 @smoke
  Scenario: Create and Submit a New BuyX-GetY Discount
    When I click on Discount Management
    And I click on Discount List
    And I click on New
    And I enter BuyX-GetY into Name Required
    And I select Discount from Type Required
    And I select BuyX-GetY from Apply To Required
    And I enter "BuyX-GetY" into Description Required
    And I click on the coupon toggle switch
    And I enter "BuyX-GetY" into Coupon Code
    And I click and enter "12" into Maximum Total Uses
    And I click and enter "12" into Maximum Uses Per Account
    And I enter buy X and Y value
    And I enter "1126726" into Find a SKU and select the SKU
    And I click on Active
    And I click on Submit for Workflow
    Then I click on Active to set it to In-active
    And I click on Submit for Workflow
