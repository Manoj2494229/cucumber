Feature: Check the lead journey for SBI_002 in UAT

  Scenario Outline: Check response from credilio for successfully issued credit card in UAT Env
    Given fill lead form with "<pan>", "<name>", "<income>", "<pincode>", "<primaryMobile>", "<employmentType>" details in UAT
    And hit the clickOutWebhook_APPLICATION_STATUS_UPDATION with "<status>" and "<subStatus>" in UAT
    And with the help of unique lead ID fetch create order API response from DB
    And fetch orderID from response and hit getOrderDetails API and check leadDisplayStatus and orderStatus
    And store status, substatus, leadDisplayStatus, orderStatus in Excel

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status         | subStatus |
      | ΑΑΑΡΑ1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted |           |
