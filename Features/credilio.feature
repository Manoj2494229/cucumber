Feature: check the lead journey

  Scenario Outline: Check response from credilio for successfully issued credit card
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with "<status>" and "<subStatus>"
    

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status        | subStatus |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Card Issued   |           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified |           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Expired  |           |
