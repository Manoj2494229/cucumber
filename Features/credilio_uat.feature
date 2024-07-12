Feature: check the lead journey for  in UAT

  @AXIS_008
  Scenario Outline: Check response from credilio for successfully issued credit card in UAT for AXIS_008
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes IN UAT
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with card as a "AXIS_008" and  "<status>" and "<subStatus>" IN UAT

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status                 | subStatus                                                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted         |                                                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Fetched                                                                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | More Details Required                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Not Fetched                                                                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Closed            |                                                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Expired           |                                                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Cards Offered          |                                                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Personal Info screen                                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Address Details                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Additional Info screen                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer to Complete OTP verification                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Submitted  | Approval In Principle Pending From Bank                                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | VKYC Link Triggered To The Customer                                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | VKYC + Income Verification Link Triggered To The Customer                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Pending for Physical KYC + Income Verification                                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Link For KYC To Be Triggered To Customer                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC Rejected                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Approved                                                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Pending For Physical KYC                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Pending For Physical KYC + Income Document Pickup                                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Account Created                                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC In Progress. VKYC Pending                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC In Progress                                                            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC - Awaiting Approval                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Approved                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC Pending                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC In Progress                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC Approved                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC Rejected                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC + VKYC Rejected. Physical KYC Pending                                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC + VKYC Rejected. Physical KYC In Process                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC + VKYC Rejected. Physical KYC Approved                                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC + Physical KYC Rejected                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC in Progress. VKYC + Income Verification Pending                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC In Progress. Income Verification Pending                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC - Awaiting Approval. Income Verification Pending                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC - Awaiting Approval. Income Verification In Progress                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Approved. Income Verification In Progress                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC + Income Verification Approved                                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Approved. Online Income Verification Rejected                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Approved. Physical Income Verification In Process                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Approved. Physical Income Verification Approved                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Approved. Income Verification Rejected                                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC In Process. Income Verification Pending                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC In Process. Income Verification Approved                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC + Income Verification In Process                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC + Income Verification Approved                                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Physical KYC Approved. Income Verification Rejected                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income Verification Approved. Physical KYC Rejected                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Link Expired. Pending For Physical KYC                                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Link Expired. Pending For Physical KYC + Income Verification                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Link Expired. Newgen Link Sent To The Customer                                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected                                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC + VKYC Rejected                                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Rejected. Income Verification Pending                                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Rejected. Income Verification Approved                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC + Income Verification Rejected                                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC + VKYC Approved. Online Income Verification Pending                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Online Income Verification Pending                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC + Online Income Verification Pending            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Physical KYC In Progress. Online Income Verification Pending |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Online Income Verification In Process                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Online Income Verification Approved                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | E-KYC Approved. VKYC Rejected. Online Income Verification Rejected                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Complete KYC + Income Doc                                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Complete KYC                                                                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Underwriting                                                                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer Not Interested                                                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer Not Contactable                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Not Eligible - Policy decline                                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Duplicate Application                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Customer Not Interested                                                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Customer Not Contactable                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Interested                                                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Contactable                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Duplicate Application                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Incomplete Documents                                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Verification Failed                                                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - CIBIL Decline                                                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Policy Decline                                                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Details Mismatch                                                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Doable                                                                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Interested                                                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Contactable                                                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Information Pending                                                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Product Not Confirmed                                                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Card Issued            |                                                                                             |

  @SBI_007
  Scenario Outline: Check response from credilio for successfully issued credit card in UAT for SBI_007
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes IN UAT
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with card as a "SBI_007" and  "<status>" and "<subStatus>" IN UAT

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status                 | subStatus                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted         |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted         |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Fetched                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | More Details Required                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Not Fetched                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Closed            |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Expired           |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Cards Offered          |                                                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Personal Info Screen                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Address Details                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Additional Info Screen                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer to Complete OTP Verification             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Submitted  | Approval In Principle Pending From Bank (default) |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Not eligible - Policy decline                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Customer not interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Duplicate / Existing Bank Customer                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Duplicate-in cooling period                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved in Principle  | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved in Principle  | Customer not interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Pending                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Document Pending                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Customer not interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Customer to complete KYC/Income Verification      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Underwriting                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer not interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Document Submitted                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Details Mismatch                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Policy Decline                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Duplicate Application                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Existing customer - Upgrade/Downgrade             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Verification failed                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Interested                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Contactable                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Documents Pending                                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Product Not Confirmed                             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Card Issued            |                                                   |

  @HDFC_026
  Scenario Outline: Check response from credilio for successfully issued credit card in UAT for HDFC_026
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes IN UAT
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with card as a "HDFC_026" and  "<status>" and "<subStatus>" IN UAT

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status                 | subStatus                                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted         |                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Fetched                                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | More Details Required                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Verified          | Bureau Not Fetched                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Closed            |                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Expired           |                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Cards Offered          |                                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | HDFC Card Selected - OTP Link sent to customer         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Personal Info Screen                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Current Address Screen                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer To Confirm Address                            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Permanent Address Screen                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Office Address Screen                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Dropped @Additional Info Screen                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer To Verify Application Details                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer to provide declaration                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | OTP Session Expired - Customer to retry                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Incomplete | Customer Declaration Done                              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Submitted  | Approval In Principle Pending From Bank (default)      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | Application Submission is in progress                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | Card Variants to be received from bank                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | Application details being sent to bank                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | Final Application Submission is in progress            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | PAN verification is in progress                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP - in Progress      | Updated application details being sent to bank         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Not eligible - Policy decline                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Duplicate Application                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Verification Failed                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Not Eligible - CIBIL Decline                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Not Eligible - Details Mismatch                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Customer not interested                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | AIP Rejected           | Customer Not Contactable                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Upload Documents                                       |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Document verification pending                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Select Card Variant                                    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Upload Income Documents                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Income Verification Pending                            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Approved In Principle  | Document Verified - Complete Netbanking                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Failed - Customer to retry                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | HDFC Card Selected - EKYC Pending                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Document Verified - Complete EKYC                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Failed - Customer to retry                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Success - Final Status awaited from bank          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Failed - Final Status awaited from bank           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Success - Final Status awaited from bank    |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Failed - Final Status awaited from bank     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Sent for Physical KYC - Final Status awaited from bank |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Failed - Sent for Biometric KYC                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Successful - VKYC Pending                         |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | EKYC Expired - Sent for Biometric KYC                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Expired - Sent for Biometric KYC                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Completed - Final Status awaited                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | VKYC Failed - Sent for Biometric KYC                   |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Docs Verified - Sent for Biometric KYC                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Card selected - Sent for Biometric KYC                 |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Expired - Sent for Biometric KYC            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Failed - Sent for Biometric KYC             |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Netbanking Success - Sent for Biometric KYC            |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | HDFC Card Selected - Complete Netbanking               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Document Verified - Complete Netbanking                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income E-verification                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Perfios Income Verified - Select Card Variant          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income E-verfication - Account Agrregation pending     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income E-verfication - Netbanking pending              |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income E-verfication - Retry                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | KYC Stage              | Income E-verification - Completed                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Pending For Underwriting                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Pending for Physical Verification                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer Not Contactable                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Credit Review          | Customer Not Intereseted                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Curable Decline                                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Contactable                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Duplicate Application                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Customer Not Interested                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Verfication failed                                     |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Details Mismatch                        |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - CIBIL Decline                           |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | Not Eligible - Policy Decline                          |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Rejected   | BioKYC Non-Sourceable                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Interested                                |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Customer Not Contactable                               |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Documents Pending                                      |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Application Expired    | Product Not Confirmed                                  |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Card Issued            |                                                        |
