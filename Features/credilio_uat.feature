Feature: check the lead journey for AXIS_008 in UAT

  @AXIS_008
  Scenario Outline: Check response from credilio for successfully issued credit card in UAT for AXIS_008
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes IN UAT
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with "<status>" and "<subStatus>" IN UAT

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

  @HDFC_026
  Scenario Outline: Check response from credilio for successfully issued credit card in UAT for HDFC_026
    Given fill the lead form with  "<pan>" ,  "<name>" ,"<income>" , "<pincode>" ,"<primaryMobile>" ,"<employmentType>" detailes IN UAT
    And hit clickOutWebhook_APPLICATION_STATUS_UPDATION with "<status>" and "<subStatus>" IN UAT

    Examples: 
      | pan        | name        | income | pincode | primaryMobile | employmentType | status         | subStatus |
      | AAAPA1046V | MANOJ BHOLE | 110000 |  400604 |    9373737606 | SALARIED       | Lead Submitted |           |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
