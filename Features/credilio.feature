Feature: check the lead journey

  Scenario Outline: Check response from credilio for successfully issued credit card
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes
    And fetch the lead from response

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       |
      | XYZ        | V BHOLE     | 100000 |  401304 |    8878675645 | PAINTION       |
