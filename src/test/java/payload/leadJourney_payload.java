package payload;

import com.github.javafaker.Faker;

public class leadJourney_payload {

	
	public static String payload_LEAD_CREATION(String leadId , String pan, String name, String income, String pincode, String primaryMobile)
	{
		String data = "{\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"pan\": \""+pan+"\",\r\n"
				+ "        \"city\": \"THANE\",\r\n"
				+ "        \"name\": \""+name+"\",\r\n"
				+ "        \"state\": \"MAHARASHTRA\",\r\n"
				+ "        \"income\": "+income+",\r\n"
				+ "        \"leadId\": "+leadId+",\r\n"
				+ "        \"agentId\": \"DUMMY001\",\r\n"
				+ "        \"pincode\": "+pincode+",\r\n"
				+ "        \"product\": \"CREDIT_CARD\",\r\n"
				+ "        \"createdAt\": \"2024-06-07 04:36:01\",\r\n"
				+ "        \"customerId\": \"1000064209\",\r\n"
				+ "        \"journeyType\": \"CUSTOMER\",\r\n"
				+ "        \"bureauProfile\": \"EXCELLENT\",\r\n"
				+ "        \"primaryMobile\": "+primaryMobile+",\r\n"
				+ "        \"employmentType\": \"SALARIED\",\r\n"
				+ "        \"secondaryMobile\": \"\",\r\n"
				+ "        \"bureauScoreRange\": \"800-900\"\r\n"
				+ "    },\r\n"
				+ "    \"type\": \"LEAD_CREATION\"\r\n"
				+ "}";
		return data;
	}
	public static String payloadupdate_APPLICATION_STATUS_UPDATION(String leadId , String status , String subStatus)
	{
		String data = "{\r\n"
				+ "    \"type\": \"APPLICATION_STATUS_UPDATION\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"cardId\": \"AXIS_014\",\r\n"
				+ "        \"leadId\": "+leadId+",\r\n"
				+ "        \"status\": \""+status+"\",\r\n"
				+ "        \"agentId\": \"8411effe494be249f4e5\",\r\n"
				+ "        \"product\": \"CREDIT_CARD\",\r\n"
				+ "        \"remarks\": \"As per NSDL Its Valid PAN but Applicant name Mismatched\",\r\n"
				+ "        \"utmLink\": \"https://customer.easycardsloans.com/credit-card/resume-journey/1715733621924298\",\r\n"
				+ "        \"createdAt\": \"2024-05-15 06:10:21\",\r\n"
				+ "        \"subStatus\": \""+subStatus+"\",\r\n"
				+ "        \"bankLeadId\": 27136002176,\r\n"
				+ "        \"leadAgeing\": 2,\r\n"
				+ "        \"submitDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"journeyType\": \"CUSTOMER1\",\r\n"
				+ "        \"pendingWith\": \"No Action\",\r\n"
				+ "        \"approvedDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"cardSelected\": \"SimplySAVE SBI Credit Card\",\r\n"
				+ "        \"customerType\": \"VI\",\r\n"
				+ "        \"applicationId\": "+leadId.concat("1234")+",\r\n"
				+ "        \"hasMoreOffers\": true,\r\n"
				+ "        \"cardIssuedDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"selectedLender\": \"SBI Card\",\r\n"
				+ "        \"finalCardStatus\": \"Rejected\",\r\n"
				+ "        \"customerResumeLink\": \"https://customer.easycardsloans.com/credit-card/resume-journey/1715733621924298\",\r\n"
				+ "        \"isNextActionEnabled\": false,\r\n"
				+ "        \"lastStatusUpdatedDate\": \"20/May/2024 17:09:38\",\r\n"
				+ "        \"nextActionDescription\": \"Lead Closed\",\r\n"
				+ "        \"applicationInitiatedDate\": \"15-May-2024 06:11:14\",\r\n"
				+ "        \"applicationReferenceNumber\": \"23456723349\"\r\n"
				+ "    }\r\n"
				+ "}";
		return data;
	}


}
