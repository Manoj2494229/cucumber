package StepDefinition;

import org.testng.annotations.Test;

import Utitlities.TokenListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class credilio_journey {
	int i = 1;
	@Given("fill the lead form with  {string} ,  {string} ,{string} , {string} ,{string} ,{string} detailes")
	public void fill_the_lead_form_with_detailes(String string, String string2, String string3, String string4, String string5, String string6) {
		
		RestAssured.useRelaxedHTTPSValidation();
		
		System.out.println("PAN = "+string);
		System.out.println("NAME = "+string2);
		System.out.println("income = "+string3);
		System.out.println("pincode =  "+string4);
		System.out.println("primaryMobile = "+string5);
		System.out.println("employmentType = "+string6);
		for(int k = 0 ;k<=100;k++)
		{
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
			System.out.println(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());	
			//String responseBody = resp1.jsonPath().prettify();
			//System.out.println(payload(string,string2,string3,string4,string5));
			JsonPath output = new JsonPath(resp1.asString());
			System.out.println(output.prettify());
		}
		
	}

	@Given("fetch the lead from response")
	//@Test(invocationCount = 100, threadPoolSize = 100)
	public void fetch_the_lead_from_response() {
		fill_the_lead_form_with_detailes( "AAAPA1046V","MANOJ BHOLE"," 110000","400604","9373737606","SALARIED");
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
				+ "        \"leadId\": 1717758361237413,\r\n"
				+ "        \"agentId\": \"DUMMY001\",\r\n"
				+ "        \"pincode\": "+pincode+",\r\n"
				+ "        \"product\": \"CREDIT_CARD\",\r\n"
				+ "        \"createdAt\": \"2024-06-07 04:36:01\",\r\n"
				+ "        \"customerId\": \"1000071602\",\r\n"
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

}
