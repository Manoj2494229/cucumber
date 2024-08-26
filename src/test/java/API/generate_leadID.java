package API;

import org.testng.annotations.Test;

import Utitlities.ReadConfig;
import Utitlities.TokenListner;
import Utitlities.readExcelConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class generate_leadID {

	String BaseURI = "https://webserver-vil-uatnew.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
	int i = 1;
	static String leadId = "";
	static String AppleadId = "";
	@Test
	public  void leadcreation() throws Exception
	{	
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.tcs.com");
		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
		String customerId = "";
		String query = "select CUSTOMERID from SIT_CID";
		for(int q = 0 ; q <= 240 ;q++)
		{
			//System.out.println(readExcelConfig.generate_leadID(query, "CUSTOMERID" ,q));
			customerId = readExcelConfig.generate_leadID(query, "CUSTOMERID" ,q);
			String AlphaNumericString = ReadConfig.generateRandomMob(9); 
			leadId = AlphaNumericString.concat("4321");
			AppleadId = AlphaNumericString.concat("1234");
			String BaseURI = "https://webserver-vil-uatnew.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
			//System.out.println(BaseURI);
			Response resp1 = RestAssured.given().
					auth().
					oauth2(TokenListner.token(BaseURI)).
					header("Content-Type","application/json").
					header("x-provider","credilio").
					body(payload(customerId,leadId)).
					when().
					post(BaseURI);
			JsonPath output = new JsonPath(resp1.asString());
			//System.out.println(output.prettify());
			
			Response resp2 = RestAssured.given().
					auth().
					oauth2(TokenListner.token(BaseURI)).
					header("Content-Type","application/json").
					header("x-provider","credilio").
					body(payloadupdate(leadId,AppleadId)).
					when().
					post(BaseURI);
			JsonPath output2 = new JsonPath(resp2.asString());
			//System.out.println(output2.prettify());
			Thread.sleep(2000);
			System.out.println(customerId +" " +leadId + " "+AppleadId);
		}
	}
	
	public void leadupdate()
	{
		
	}
	
	@Test
	public void test() throws Exception
	{
		String query = "select CUSTOMERID from CID";
		for(int q = 0 ; q <= 3 ;q++)
		{
			System.out.println(readExcelConfig.generate_leadID(query, "CUSTOMERID" ,q));
		}
		
	}
	
	public static String payload(String customerId , String leadId)
	{
		String data = "{\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"pan\": \"AAAPA1046V\",\r\n"
				+ "        \"city\": \"THANE\",\r\n"
				+ "        \"name\": \"Manoj Bhole\",\r\n"
				+ "        \"state\": \"MAHARASHTRA\",\r\n"
				+ "        \"income\": 1320008,\r\n"
				+ "        \"leadId\": "+leadId+",\r\n"
				+ "        \"agentId\": \"DUMMY001\",\r\n"
				+ "        \"pincode\": 400604,\r\n"
				+ "        \"product\": \"CREDIT_CARD\",\r\n"
				+ "        \"createdAt\": \"2024-06-07 04:36:01\",\r\n"
				+ "        \"customerId\": \""+customerId+"\",\r\n"
				+ "        \"journeyType\": \"CUSTOMER\",\r\n"
				+ "        \"bureauProfile\": \"EXCELLENT\",\r\n"
				+ "        \"primaryMobile\": 9373737606,\r\n"
				+ "        \"employmentType\": \"SALARIED\",\r\n"
				+ "        \"secondaryMobile\": \"\",\r\n"
				+ "        \"bureauScoreRange\": \"800-900\"\r\n"
				+ "    },\r\n"
				+ "    \"type\": \"LEAD_CREATION\"\r\n"
				+ "}";
		return data;
	}
	public static String payloadupdate(String leadId , String AppleadId)
	{
		String data = "{\r\n"
				+ "    \"type\": \"APPLICATION_STATUS_UPDATION\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"cardId\": \"AXIS_008\",\r\n"
				+ "        \"leadId\": "+leadId+",\r\n"
				+ "        \"status\": \"Card Issued\",\r\n"
				+ "        \"agentId\": \"8411effe494be249f4e5\",\r\n"
				+ "        \"product\": \"CREDIT_CARD\",\r\n"
				+ "        \"remarks\": \"As per NSDL Its Valid PAN but Applicant name Mismatched\",\r\n"
				+ "        \"utmLink\": \"https://customer.easycardsloans.com/credit-card/resume-journey/1715733621924298\",\r\n"
				+ "        \"createdAt\": \"2024-05-15 06:10:21\",\r\n"
				+ "        \"subStatus\": \"\",\r\n"
				+ "        \"bankLeadId\": 27136002176,\r\n"
				+ "        \"leadAgeing\": 2,\r\n"
				+ "        \"submitDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"journeyType\": \"CUSTOMER1\",\r\n"
				+ "        \"pendingWith\": \"No Action\",\r\n"
				+ "        \"approvedDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"cardSelected\": \"SimplySAVE SBI Credit Card\",\r\n"
				+ "        \"customerType\": \"VI\",\r\n"
				+ "        \"applicationId\": "+AppleadId+",\r\n"
				+ "        \"hasMoreOffers\": true,\r\n"
				+ "        \"cardIssuedDate\": \"15-May-2024 06:18:30\",\r\n"
				+ "        \"selectedLender\": \"SBI Card\",\r\n"
				+ "        \"finalCardStatus\": \"Rejected\",\r\n"
				+ "        \"customerResumeLink\": \"https://www.credilio.in/\",\r\n"
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
