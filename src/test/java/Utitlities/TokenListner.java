package Utitlities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenListner {
	  static Logger log = LogManager.getLogger("StepDef");
	public  static String  token(String URI)
	{
		String token = "";

		if(URI.contains("sit"))
		{
			Response resp = RestAssured.
					given().
					formParam("client_id", "id-a5909c26-8871-1ef9-954e-aedfec9a8833").
					formParam("client_secret", "secret-516f105a-57dc-091c-5015-291c207542").
					formParam("grant_type", "client_credentials").
					post("https://webserver-vil-sit.lfr.cloud/o/oauth2/token");

			token = resp.jsonPath().get("access_token");
			RestAssured.useRelaxedHTTPSValidation();
		}else if (URI.contains("uat"))
		{
			//System.out.println("please enter valid UAT");
			Response resp = RestAssured.
					given().
					formParam("client_id", "id-d256f865-f2b7-c3b2-3070-ffaf4e82c19").
					formParam("client_secret", "secret-b96bb018-fa2d-e586-72ab-2d05f4ba077").
					formParam("grant_type", "client_credentials").
					post("https://webserver-vil-uatnew.lfr.cloud/o/oauth2/token");
			token = resp.jsonPath().get("access_token");
			//System.out.println(token);
			RestAssured.useRelaxedHTTPSValidation();
		}else if (URI.contains("dev"))
		{
			Response resp = RestAssured.
					given().
					formParam("client_id", "id-56e5c15e-e9ab-ba93-a261-53b8b61cef").
					formParam("client_secret", "secret-df8ed5aa-e4c1-c652-a4f6-90c783a31ca2").
					formParam("grant_type", "client_credentials").
					post("https://webserver-vil-dev.lfr.cloud/o/oauth2/token");

			token = resp.jsonPath().get("access_token");
			//System.out.println(token);

			RestAssured.useRelaxedHTTPSValidation();

		}else
		{
			System.out.println("Enter Valid Token");
		}
		//log.info("Token added ");
		return token;

			

	}
}
