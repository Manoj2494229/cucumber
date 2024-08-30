Feature: Product Journey

  @smoke1
  Scenario: Fill up the simple product configuration page
    Given Open the website "https://webserver-vil-uatnew.lfr.cloud"
    When Enter "vitechadmin2@liferay.com" into enter email mobile and click on OTP
    And Enter four time "1" into OTP section
    Then Click on the verify & login button
    When the user clicks on the Product List tab
    And the user clicks on the New button to create a new product
    And the user clicks on the Simple button to select the product type
    And the user enters "Shoppers Stop (15101)" into the Type Here field and clicks on
    And the user clicks on Category Requir dropdown and selects "Entertainment > OTT" from the Category Requir dropdown
    And the user clicks on the "Submit" button
    Then the user should see the product details page
    When the user clicks on the Details button
    And the user enters "test" into the Name Required field
    And the user enters "test" into the Short Description field
    And the user enters "1" into the Validity Duration field
    And the user selects "Year" from the Validity Requir dropdown
    And the user enters "tata" into the Brand Name Requ field
    And the user enters "11111" into the HSN/SAC Code field
    And the user enters "terms & conditions" into the terms & conditions field
    And the user enters "How to Redeem " into the How to Redeem field
    And the user enters "display order" into the display order field
    And the user enters "product of type" into the product of type field
    And the user enters All "Specifications" into the Specifications field
    And the user Click on save draft Button 
    And the user clicks on the sku tab
    And the user Click on add SKU button
    And the user enters "SKU123" into the SKU NAME field
    And the user Click on Purchasable button
    And the user selects partner from the partner dropdown
    And the user enters inventory into the inventory field
    And the user enters base PRICE into the Base Price field like "100"
    And the user enters promo Price into the Promo Price field like "50"
    And the user Click on Submit For Publication button
    And the user Click on close button
    And the user Click on Details button
    And the user select checkbox on never expiry button
    And the user select checkbox on Publish button
    And the user Click on Submit button
    Then the product should be created successfully
