Feature: API Journey

  # This scenario validates the end-to-end purchase process via the traditional "Add to Cart" method.
  @AddtoCart @API
  Scenario: Verify Buy Journey of LR API via Add to Cart
    Given the user adds a product to the cart using the manageOrder API
    And the user updates or adds the delivery address using the manageOrder API
    And the user applies a discount to the cart total using the managePromotion API
    And the user selects the Checkout option using the manageOrder API
    And the user receives an updated order status from the partner using the updateOrder API
    Then the user verifies the order status using the getOrderDetails API
    And the user confirms the order is listed in their order history using the getOrders API

  # This scenario tests the streamlined purchase process using the "Buy Now" feature.
  @ExpressCheckout @API
  Scenario: Verify Buy Journey of LR API via Express Checkout
    Given the user adds a product to the cart using the Buy Now button through the manageOrder API
    And the user updates or adds the delivery address using the manageOrder API
    And the user applies a discount to the cart total using the managePromotion API
    And the user selects the Checkout option using the manageOrder API
    And the user receives an updated order status from the partner using the updateOrder API
    Then the user verifies the order status using the getOrderDetails API
    And the user confirms the order is listed in their order history using the getOrders API

  # This scenario checks the user's ability to add a product review.
  @reviewProduct @API
  Scenario: Verify User Can Add Review to a Product
    Given the user submits a review for a product using the reviewProduct API

  # This scenario outlines the customer registration journey in the VI_SHOP system.
  @validateCustomer @API
  Scenario: Verify Customer Registration Journey
    Given the user enters VI_SHOP and completes validation
    And the system determines if the user is new or existing and creates an entry for a new user using the validateCustomer API
    And the system ensures the user accepts the terms and conditions before entering VI_SHOP using the recordConsent API

  # This scenario tests the user's ability to view products in VI_SHOP.
  @getProductList @API
  Scenario: Verify User Can View Products in VI_SHOP
    Given the user views products available in VI_SHOP using the getProductList API

  # This scenario checks if the user can view their searched keyword history in VI_SHOP.
  @getSearchedKeywords @API
  Scenario: Verify User Can View Searched Keyword History in VI_SHOP
    Given the user searches for a term in VI_SHOP using the getProductList API
    Then the user can view this searched keyword the next time they access VI_SHOP using the getSearchedKeywords API

  # This scenario verifies the user's ability to view categories and subcategories within VI_SHOP.
  @getAllCategories @API
  Scenario: Verify User Can View Categories and Subcategories in VI_SHOP
    Given the user views all categories using the getAllCategories API
    And the user views subcategories within a main category using the getChildCategories API
    And the user views a specific category by name using the getVocabularyCategoriesByName API
    And the user views a specific category by ID using the getVocabularyCategoriesById API
