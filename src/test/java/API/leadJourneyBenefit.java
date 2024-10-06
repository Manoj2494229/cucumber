package API;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utitlities.Help;
import Utitlities.apiCall;
import Utitlities.readExcelConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.leadJourney_payload;

public class leadJourneyBenefit extends Help{

	static String keyword = null;

	static Response resp_LEAD_CREATION;
	static Response resp_APPLICATION_STATUS_UPDATION;
	static String leadId = "";


	String clickOutWebhook 	= 	"https://webserver-vil-sit.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
	@Test
	public void leadJourneyAllBenefit() throws Exception
	{		System.setProperty("http.proxyHost", "proxy.tcs.com");
	System.setProperty("http.proxyPort", "8080");
	System.setProperty("https.proxyHost", "proxy.tcs.com");
	System.setProperty("https.proxyPort", "8080");
	RestAssured.useRelaxedHTTPSValidation();
	
		//generate unique lead id 
		Faker faker = new Faker();
		leadId = faker.number().digits(10);
		String q = "select CUSTOMERID , MSIDN from CID";
		String cid = readExcelConfig.generate_leadID(q, "MSIDN", 2);
		
		System.out.println(cid);
				
		resp_LEAD_CREATION = apiCall.post_credilio(clickOutWebhook, leadJourney_payload.payload_LEAD_CREATION(leadId, "AAAPA1046V", "MANOJ BHOLE","120000", "400604", "9373737606"));
		resp_APPLICATION_STATUS_UPDATION = apiCall.post_credilio(clickOutWebhook, leadJourney_payload.payloadupdate_APPLICATION_STATUS_UPDATION(leadId, "Card Issued", ""));


		JsonPath output_LEAD_CREATION = new JsonPath(resp_LEAD_CREATION.asString());
		JsonPath output_APPLICATION_STATUS_UPDATION  = new JsonPath(resp_APPLICATION_STATUS_UPDATION.asString());

		String responseBody = output_APPLICATION_STATUS_UPDATION.prettify();
		System.out.println(responseBody);



	}


}
