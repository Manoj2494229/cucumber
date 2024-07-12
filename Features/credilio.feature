Feature: check the lead journey for AXIS_014 in SIT

  Scenario Outline: Check response from credilio for successfully issued credit card in SIT
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with "<status>" and "<subStatus>"

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status                  | subStatus                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted          |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified           | Bureau Not Fetched                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified           | Offer not Viewed                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified           |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Closed             |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Expired            |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Cards Offered           |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Not Started | Bank UTM - Link Sent                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Submitted   | Approval In Principle pending from Bank (default) |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage               | Complete KYC                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage               | Complete KYC + Income Doc                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage               | Customer Not Interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage               | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review           | Underwriting                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review           | Customer Not Interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review           | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Duplicate Application                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Verification Failed                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Not Eligible - Policy Decline                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Not Eligible - Details Mismatch                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Not Doable                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected            | Customer Not Interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected    |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired     |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Card Issued             |                                                   |
