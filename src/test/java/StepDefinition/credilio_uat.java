package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utitlities.ReadConfig;
import Utitlities.TokenListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class credilio_uat {
	//initialise logger
	static Logger log = LogManager.getLogger("StepDef");
	int i = 1;
	static String leadId = "";
	static String AppleadId = "";
	@Given("fill the lead form with  {string} ,  {string} ,{string} , {string} ,{string} ,{string} detailes IN UAT")
	public void fill_the_lead_form_with_detailes_in_uat(String string, String string2, String string3, String string4, String string5, String string6) throws Exception {
		//initialise logger
		log.fatal("Setup1 executed...");
				System.setProperty("http.proxyHost", "proxy.tcs.com");
				System.setProperty("http.proxyPort", "8080");
				System.setProperty("https.proxyHost", "proxy.tcs.com");
				System.setProperty("https.proxyPort", "8080");
		String AlphaNumericString = ReadConfig.generateRandomMob(9); 
		leadId = AlphaNumericString;
		AppleadId = AlphaNumericString;
		System.out.println(AlphaNumericString);
		RestAssured.useRelaxedHTTPSValidation();
		String BaseURI = "https://webserver-vil-sit.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
		//System.out.println(BaseURI);
		Response resp1 = RestAssured.given().
				auth().
				oauth2(TokenListner.token(BaseURI)).
				header("Content-Type","application/json").
				header("x-provider","credilio").
				body(payload(string,string2,string3,string4,string5)).
				when().
				post(BaseURI);
		//System.out.println(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());	
		//String responseBody = resp1.jsonPath().prettify();
		System.out.println(payload(string,string2,string3,string4,string5));
		JsonPath output = new JsonPath(resp1.asString());
		System.out.println(output.prettify());
		//SELECT request  from VIL_ApiLogging WHERE request like '%836939306%' and url like '%/o/vil-headless-create-order/v1.0/createOrder%';
		log.info("Callback 1 --> fill_the_lead_form_with_detailes_in_uat Done");
Thread.sleep(2000);
	}


	@Given("hit clickOutWebhook_APPLICATION_STATUS_UPDATION with card as a {string} and  {string} and {string} IN UAT")
	public void hit_click_out_webhook_application_status_updation_with_card_as_a_and_and_in_uat(String string, String string2, String string3) throws Exception {
		String BaseURI = "https://webserver-vil-sit.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
		//System.out.println(BaseURI);
		Response resp1 = RestAssured.given().
				auth().
				oauth2(TokenListner.token(BaseURI)).
				header("Content-Type","application/json").
				header("x-provider","credilio").
				body(payloadupdate(string,string2,string3)).
				when().
				post(BaseURI);
		//System.out.println(payloadupdate(string,string2));
		//System.out.println(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());	
		//String responseBody = resp1.jsonPath().prettify();
		System.out.println(payloadupdate(string,string2,string3));
		JsonPath output1 = new JsonPath(resp1.asString());
		System.out.println(output1.prettify());
		//System.out.println(string +" " +string2);
		Thread.sleep(2000);
		log.info("Callback 2 --> hit_click_out_webhook_application_status_updation_with_card_as_a_and_and_in_uat Done");
	}
	public static String payload(String pan, String name, String income, String pincode, String primaryMobile)
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
				+ "        \"customerId\": \"1000098802\",\r\n"
				+ "        \"journeyType\": \"CUSTOMER\",\r\n"
				+ "        \"bureauProfile\": \"EXCELLENT\",\r\n"
				+ "        \"primaryMobile\": "+primaryMobile+",\r\n"
				+ "        \"employmentType\": \"SALARIED\",\r\n"
				+ "        \"secondaryMobile\": \"\",\r\n"
				+ "        \"bureauScoreRange\": \"800-900\"\r\n"
				+ "    },\r\n"
				+ "    \"type\": \"LEAD_CREATION\"\r\n"
				+ "}";
		log.info("Callback 1 -- > LEAD_CREATION -- > Payload added");
		return data;
	}
	public static String payloadupdate(String cardId , String status , String subStatus)
	{
		String data = "{\r\n"
				+ "    \"type\": \"APPLICATION_STATUS_UPDATION\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"cardId\": \""+cardId+"\",\r\n"
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
				+ "        \"applicationId\": "+AppleadId+",\r\n"
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
		log.info("Callback 2 -- > APPLICATION_STATUS_UPDATION -- > Payload added");
		return data;
	}
}
